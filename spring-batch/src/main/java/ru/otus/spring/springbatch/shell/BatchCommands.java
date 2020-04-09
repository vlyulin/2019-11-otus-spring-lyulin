package ru.otus.spring.springbatch.shell;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.spring.springbatch.config.AppProps;
import ru.otus.spring.springbatch.config.JobConfig;


import javax.sql.DataSource;

@RequiredArgsConstructor
@ShellComponent
public class BatchCommands {

    private final AppProps appProps;
    private final Job importH2ToMongoJob;
    private final DataSource dataSource;

    private final JobLauncher jobLauncher;
    private final JobOperator jobOperator;
    private final JobExplorer jobExplorer;

    @SneakyThrows
    @ShellMethod(value = "startMigrationJobWithJobLauncher", key = "sm-jl")
    public void startMigrationJobWithJobLauncher() {
        JobExecution execution = jobLauncher.run(importH2ToMongoJob, new JobParametersBuilder()
                .toJobParameters());
        System.out.println(execution);
    }

    @SneakyThrows
    @ShellMethod(value = "startMigrationJobWithJobOperator", key = "sm-jo")
    public void startMigrationJobWithJobOperator() {
        Long executionId = jobOperator.start(JobConfig.IMPORT_H2_TO_MONGO_JOB_NAME, "");
        System.out.println(jobOperator.getSummary(executionId));
    }

    @ShellMethod(value = "showInfo", key = "i")
    public void showInfo() {
        System.out.println(jobExplorer.getJobNames());
        System.out.println(jobExplorer.getLastJobInstance(JobConfig.IMPORT_H2_TO_MONGO_JOB_NAME));
    }
}
