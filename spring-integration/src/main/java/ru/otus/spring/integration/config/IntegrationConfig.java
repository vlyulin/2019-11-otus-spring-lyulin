package ru.otus.spring.integration.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.core.GenericSelector;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.messaging.MessageHandler;
import ru.otus.spring.integration.services.CustomMongoMessageHandler;

import java.io.File;
import java.io.IOException;

@Configuration
@EnableIntegration
@IntegrationComponentScan
public class IntegrationConfig {

    @Autowired
    private MongoDbFactory mongoDbFactory;
    @Autowired
    private MongoConverter mongoConverter;

    public static String INPUT_DIR = "source";
    public static String OUTPUT_DIR = "src\\main\\resources\\target";

    public static final String DATABASE_CHANNEL = "databaseChannel.input";
    public static final String FILESYSTEM_CHANNEL = "fileSystemChannel.input";

    @Bean
    QueueChannel databaseChannel() {
        return new QueueChannel();
    }

    @Bean
    QueueChannel fileSystemChannel() {
        return new QueueChannel();
    }

    @Bean
    public MessageSource<File> sourceDirectory() throws IOException {
        Resource resource = new ClassPathResource(INPUT_DIR);
        FileReadingMessageSource messageSource = new FileReadingMessageSource();
        messageSource.setDirectory(resource.getFile());
        return messageSource;
    }

    public boolean isJpg(File file) {
        return file.getName().endsWith(".jpg");
    }

    @Bean
    public GenericSelector<File> onlyJpgs() {
        return new GenericSelector<File>() {
            @Override
            public boolean accept(File source) {
                return isJpg(source);
            }
        };
    }

    @Bean
    public GenericSelector<File> notJpgs() {
        return new GenericSelector<File>() {
            @Override
            public boolean accept(File source) {
                return !isJpg(source);
            }
        };
    }

    @Bean
    public MessageHandler targetDatabase() {
        return new CustomMongoMessageHandler();
    }

    @Bean
    public MessageHandler targetDirectory() throws IOException {
        Resource resource = new ClassPathResource(OUTPUT_DIR);
        FileWritingMessageHandler handler = new FileWritingMessageHandler(new File(OUTPUT_DIR));
        handler.setFileExistsMode(FileExistsMode.REPLACE);
        handler.setExpectReply(false);
        return handler;
    }

    @Bean
    public IntegrationFlow databaseSaver() throws IOException {
        return IntegrationFlows.from(DATABASE_CHANNEL)
                .handle(this.targetDatabase())
                .get();
    }

    @Bean
    public IntegrationFlow fileSaver() throws IOException {
        return IntegrationFlows.from(FILESYSTEM_CHANNEL)
                .handle(this.targetDirectory())
                .get();
    }

    @Bean
    public IntegrationFlow integrationFlow() throws IOException {
        return IntegrationFlows
                .from(sourceDirectory(), configurer -> configurer.poller(Pollers.fixedDelay(1000)))
                .routeToRecipients(route -> route
                        .recipient(DATABASE_CHANNEL, this.onlyJpgs())
                        .recipient(FILESYSTEM_CHANNEL, this.notJpgs())
                )
                .get();
    }
}
