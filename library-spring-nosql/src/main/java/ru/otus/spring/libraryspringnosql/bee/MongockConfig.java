package ru.otus.spring.libraryspringnosql.bee;

import com.github.cloudyrock.mongock.SpringBootMongock;
import com.github.cloudyrock.mongock.SpringBootMongockBuilder;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.spring.libraryspringnosql.bee.changelog.DatabaseChangelog;
import ru.otus.spring.libraryspringnosql.services.CascadeDeleteMongoEventListener;

@Configuration
public class MongockConfig {

    @Value("${spring.data.mongodb.database:library}")
    private String databaseName;

    @Bean
    public SpringBootMongock mongock(ApplicationContext springContext, MongoClient mongoClient) {
        return (SpringBootMongock) new SpringBootMongockBuilder(mongoClient, databaseName, DatabaseChangelog.class.getPackage().getName())
                .setApplicationContext(springContext)
                .setLockQuickConfig()
                .build();
    }

    // Регистрация listener для каскадного удаления
    @Bean
    public CascadeDeleteMongoEventListener cascadeDeleteMongoEventListener() {
        return new CascadeDeleteMongoEventListener();
    }
}
