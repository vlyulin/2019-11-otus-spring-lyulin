package ru.otus.spring.oca.helpers.shell;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.io.FileNotFoundException;

import static ru.otus.spring.oca.helpers.batch.JobConfig.*;

// @RequiredArgsConstructor
@ShellComponent
public class ShellCommangs {

    public static final String INPUT_DIR = "input";
    public static final String OUTPUT_DIR = "src/main/resources/output/";

    private final JobLauncher jobLauncher;
    private final Job javaClassGeneratorJob;
    private final Job jHipsterClassGeneratorJob;

    public ShellCommangs(@Autowired JobLauncher jobLauncher,
                         @Qualifier("JavaClassGeneratorJob") Job javaClassGeneratorJob,
                         @Qualifier("JHipsterClassGeneratorJob") Job jHipsterClassGeneratorJob
    ) {
        this.jobLauncher = jobLauncher;
        this.javaClassGeneratorJob = javaClassGeneratorJob;
        this.jHipsterClassGeneratorJob = jHipsterClassGeneratorJob;
    }

    /**
     * Формирование параметров для Jobs
     * @param inputFile -> соотв. параметр IN_FILE_PARAM_NAME, наименование входного файла
     * @param outputFile -> соотв. параметр OUT_FILE_PARAM_NAME, наименование выходного файла
     * @param jsonPath -> соотв. параметр JSON_PATH? путь во входном файле к атрибутам в формате JSON,
     *                 например, $.Resources.*.attributes[*]
     * @return JobParameters
     * @throws FileNotFoundException - если входной файл не найден,
     *          или не найдена директория OUTPUT_DIR для сохранения результата
     */
    private JobParameters makeJobParameters(
            String inputFile,
            String outputFile,
            String jsonPath
    ) throws FileNotFoundException {

        // Проверка наличия входного файла и output директории
        ClassPathResource inputFilePath = new ClassPathResource(INPUT_DIR+"/"+inputFile);
        ClassPathResource outputFilePath = new ClassPathResource(OUTPUT_DIR+"/"+outputFile);
        FileSystemResource fileSystemResource = new FileSystemResource(OUTPUT_DIR);

        if( !inputFilePath.exists()) {
            throw new FileNotFoundException("File not found: " + inputFilePath.getPath());
        }
        if( !fileSystemResource.exists()) {
            throw new FileNotFoundException("Directory not found: " + fileSystemResource.getPath());
        }

        // Подготовка параметров для Job
        JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
        jobParametersBuilder.addString(JSON_PATH, jsonPath);
        jobParametersBuilder.addString(IN_FILE_PARAM_NAME, inputFilePath.getPath());
        jobParametersBuilder.addString(OUT_FILE_PARAM_NAME, outputFilePath.getPath());

        return jobParametersBuilder.toJobParameters();
    }

    /**
     * Генератор атрибутов Java класса на основании описания Oracle Fusion сущности для REST интеграции
     * Например:
     * https://egxt-dev4.fa.em2.oraclecloud.com/fscmRestApi/resources/11.13.18.05/standardReceipts/describe
     * Пример запуска: j2j -input-file Receipt.json -output-file Receipt.java
     *
     * @param inputFile - файл должен находиться в директории resources/input/
     * @param outputFile - выходной файл будет создан в директории resources/output/
     * @param jsonPath - пример пути к атрибутам: $.Resources.*.attributes[*]
     * @throws JobParametersInvalidException
     * @throws JobExecutionAlreadyRunningException
     * @throws JobRestartException
     * @throws JobInstanceAlreadyCompleteException
     * @throws FileNotFoundException
     */
    @ShellMethod(value = "JsonToJava", key = "j2j", prefix = "-")
    public void jsonToJava(
            String inputFile,
            String outputFile,
            @ShellOption(defaultValue = "$.Resources.*.attributes[*]") String jsonPath
    ) throws JobParametersInvalidException, JobExecutionAlreadyRunningException,
            JobRestartException, JobInstanceAlreadyCompleteException, FileNotFoundException {

        JobParameters jobParameters = makeJobParameters(inputFile,outputFile,jsonPath);
        JobExecution execution = jobLauncher.run( javaClassGeneratorJob, jobParameters);
    }

    /**
     * Генератор атрибутов JHipster класса на основании описания Oracle Fusion сущности для REST интеграции
     * Например:
     * https://egxt-dev4.fa.em2.oraclecloud.com/fscmRestApi/resources/11.13.18.05/standardReceipts/describe
     * Пример запуска: j2h -input-file Receipt.json -output-file Receipt.jh
     * @param inputFile - файл должен находиться в директории resources/input/
     * @param outputFile - выходной файл будет создан в директории resources/output/
     * @param jsonPath - пример пути к атрибутам: $.Resources.*.attributes[*]
     * @throws JobParametersInvalidException
     * @throws JobExecutionAlreadyRunningException
     * @throws JobRestartException
     * @throws JobInstanceAlreadyCompleteException
     * @throws FileNotFoundException
     */
    @ShellMethod(value = "JsonToJHipster", key = "j2h", prefix = "-")
    public void jsonToJHipster(
            String inputFile,
            String outputFile,
            @ShellOption(defaultValue = "$.Resources.*.attributes[*]") String jsonPath
    ) throws JobParametersInvalidException, JobExecutionAlreadyRunningException,
            JobRestartException, JobInstanceAlreadyCompleteException, FileNotFoundException {

        JobParameters jobParameters = makeJobParameters(inputFile,outputFile,jsonPath);
        JobExecution execution = jobLauncher.run( jHipsterClassGeneratorJob, jobParameters);
    }
}
