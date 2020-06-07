package ru.otus.spring.springbatch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.JobRepositoryTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.spring.springbatch.config.JobConfig;
import ru.otus.spring.springbatch.models.mongo.Book;
import ru.otus.spring.springbatch.models.mongo.Comment;
import ru.otus.spring.springbatch.repositories.MongoBookCommentsRepository;
import ru.otus.spring.springbatch.repositories.MongoBookRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@SpringBatchTest
@DisplayName("Тестирование миграции базы H2 -> MongoDB")
public class importH2ToMongoJobTest {

    private static final int BOOKS_COUNT = 3;
    private static final int COMMENTS_COUNT = 5;

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Autowired
    private JobRepositoryTestUtils jobRepositoryTestUtils;

    @Autowired
    private MongoBookRepository mongoBookRepository;

    @Autowired
    private MongoBookCommentsRepository mongoBookCommentsRepository;

    @BeforeEach
    void clearMetaData() {
        jobRepositoryTestUtils.removeJobExecutions();
    }

    @Test
    void testJob() throws Exception {
        Job job = jobLauncherTestUtils.getJob();
        assertThat(job).isNotNull()
                .extracting(Job::getName)
                .isEqualTo(JobConfig.IMPORT_H2_TO_MONGO_JOB_NAME);

        JobExecution jobExecution = jobLauncherTestUtils.launchJob();
        assertThat(jobExecution.getExitStatus().getExitCode()).isEqualTo("COMPLETED");

        List<Book> books = mongoBookRepository.findAll();
        assertThat(books).hasSize(BOOKS_COUNT);

        List<Comment> comments = mongoBookCommentsRepository.findAll();
        assertThat(comments).hasSize(COMMENTS_COUNT);
    }
}
