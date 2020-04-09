package ru.otus.spring.springbatch.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.spring.springbatch.models.h2.Book;
import ru.otus.spring.springbatch.models.h2.Comment;
import ru.otus.spring.springbatch.repositories.H2BookCommentsRepository;
import ru.otus.spring.springbatch.repositories.H2BooksRepository;
import ru.otus.spring.springbatch.repositories.MongoBookCommentsRepository;
import ru.otus.spring.springbatch.repositories.MongoBookRepository;
import ru.otus.spring.springbatch.service.H2ToMongoConvertor;

import java.util.HashMap;

@SuppressWarnings("all")
@Configuration
public class JobConfig {
    private static final int CHUNK_SIZE = 5;
    private final Logger logger = LoggerFactory.getLogger("Batch");

    public static final String IMPORT_H2_TO_MONGO_JOB_NAME = "importH2ToMongoJob";

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;


    @StepScope
    @Bean
    public RepositoryItemReader<Book> bookReader(H2BooksRepository h2BooksRepository) {
        RepositoryItemReader<Book> reader = new RepositoryItemReader<>();
        reader.setRepository(h2BooksRepository);
        reader.setMethodName("findAll");
        reader.setSort(new HashMap<>());
        return reader;
    }

    @StepScope
    @Bean /*(name = "bookProcessor")*/
    public ItemProcessor<Book, ru.otus.spring.springbatch.models.mongo.Book> bookProcessor(H2ToMongoConvertor h2ToMongoConvertor) {
        return (ItemProcessor<Book, ru.otus.spring.springbatch.models.mongo.Book>) h2ToMongoConvertor::bookTransformation;
    }

    @StepScope
    @Bean
    public RepositoryItemWriter<ru.otus.spring.springbatch.models.mongo.Book> bookWriter(MongoBookRepository bookRepository) {
        RepositoryItemWriter writer = new RepositoryItemWriter();
        writer.setRepository(bookRepository);
        writer.setMethodName("save");
        return writer;
    }

    @Bean
    public Step step1MigateBooks(RepositoryItemReader<Book> bookReader,
                                 /*@Qualifier("bookProcessor") */ItemProcessor<Book, ru.otus.spring.springbatch.models.mongo.Book> bookProcessor,
                                 RepositoryItemWriter<ru.otus.spring.springbatch.models.mongo.Book> bookWriter) {
        return stepBuilderFactory.get("step1_MigateBooks")
                .<Book, ru.otus.spring.springbatch.models.mongo.Book>chunk(CHUNK_SIZE)
                .reader(bookReader)
                .processor(bookProcessor)
                .writer(bookWriter)
                .build();
    }

    @StepScope
    @Bean
    public RepositoryItemReader<Comment> commentReader(H2BookCommentsRepository h2BookCommentsRepository) {
        RepositoryItemReader<Comment> reader = new RepositoryItemReader<>();
        reader.setRepository(h2BookCommentsRepository);
        reader.setMethodName("findAll");
        reader.setSort(new HashMap<>());
        return reader;
    }

    @StepScope
    @Bean
    public ItemProcessor<Comment, ru.otus.spring.springbatch.models.mongo.Comment> commentProcessor(H2ToMongoConvertor h2ToMongoConvertor) {
        return (ItemProcessor<Comment, ru.otus.spring.springbatch.models.mongo.Comment>) h2ToMongoConvertor::commentTransformation;
    }

    @StepScope
    @Bean
    public RepositoryItemWriter<ru.otus.spring.springbatch.models.mongo.Comment> commentWriter(MongoBookCommentsRepository commentsRepository) {
        RepositoryItemWriter writer = new RepositoryItemWriter();
        writer.setRepository(commentsRepository);
        writer.setMethodName("save");
        return writer;
    }

    @Bean
    public Step step2MigateComments(RepositoryItemReader<Comment> commentReader,
                                    ItemProcessor<Comment, ru.otus.spring.springbatch.models.mongo.Comment> commentProcessor,
                                    RepositoryItemWriter<ru.otus.spring.springbatch.models.mongo.Comment> commentWriter
    ) {
        return stepBuilderFactory.get("step2_MigateComments")
                .<Comment, ru.otus.spring.springbatch.models.mongo.Comment>chunk(CHUNK_SIZE)
                .reader(commentReader)
                .processor(commentProcessor)
                .writer(commentWriter)
                .build();
    }

    @Bean
    public Job importH2ToMongoJob(Step step1MigateBooks, Step step2MigateComments) {
        return jobBuilderFactory.get(IMPORT_H2_TO_MONGO_JOB_NAME)
                .incrementer(new RunIdIncrementer())
                .start(step1MigateBooks)
                .next(step2MigateComments)
                // .end()
                .listener(new JobExecutionListener() {
                    @Override
                    public void beforeJob(JobExecution jobExecution) {
                        logger.info("Начало job");
                    }

                    @Override
                    public void afterJob(JobExecution jobExecution) {
                        logger.info("Конец job");
                    }
                })
                .build();
    }
}
