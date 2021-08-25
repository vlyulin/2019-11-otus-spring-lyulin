package ru.otus.spring.oca.helpers.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.PassThroughLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.LinkedHashMap;

@Configuration
public class JobConfig {

    public static final String BATCH_LOGGER_NAME = "Batch";
    public static final String IN_FILE_PARAM_NAME = "InFileName";
    public static final String OUT_FILE_PARAM_NAME = "OutFileName";
    public static final String JSON_PATH = "JSON_PATH";
    public static final String JAVA_DOMAIN_PROCESSOR_STEP = "JavaDomainProcessorStep";
    public static final String JHIPSTER_PROCESSOR_STEP = "JHipsterProcessorStep";
    public static final String JOB_MAKE_JAVA_DOMAIN_OBJECT = "JobMakeJavaDomainObject";
    public static final String JOB_MAKE_JHIPSTER_OBJECT = "JobMakeJHipsterObject";
    private static final String OVERRIDDEN_BY_EXPRESSION = "beOverriden";


    private final Logger logger = LoggerFactory.getLogger(BATCH_LOGGER_NAME);

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @StepScope
    @Bean
    public ItemReader<LinkedHashMap> jsonItemReader(
            @Value("#{jobParameters["+IN_FILE_PARAM_NAME+"]}") String pathToFile,
            @Value("#{jobParameters["+JSON_PATH+"]}") String jsonPath
    ) {
        return (ItemReader<LinkedHashMap>) new JsonItemReader(pathToFile, jsonPath);
    }

    @StepScope
    @Bean
    public JavaDomenProcessor javaDomenProcessor() {
        return new JavaDomenProcessor();
    }

    @StepScope
    @Bean
    public JHipsterProcessor jHipsterProcessor() {
        return new JHipsterProcessor();
    }

    @StepScope
    @Bean
    public FlatFileItemWriter<String> writer(
            @Value("#{jobParameters["+OUT_FILE_PARAM_NAME+"]:'output/emptyparam.txt'}") String pathToFile) throws IOException {
        Resource outputResource = new FileSystemResource(pathToFile);
        FlatFileItemWriter writer = new FlatFileItemWriter<>();
        writer.setResource(outputResource);
        writer.setLineAggregator(new PassThroughLineAggregator<>());
        return writer;
    }

    /*
     * Генерация Java классов
     */
    @Bean(name = "JavaClassGeneratorStep")
    public Step makeJavaDomainObjectStep(
            ItemReader<LinkedHashMap> jsonItemReader,
            JavaDomenProcessor javaDomenProcessor,
            FlatFileItemWriter flatFileItemWriter
    ) {
        return stepBuilderFactory.get(JAVA_DOMAIN_PROCESSOR_STEP)
                .allowStartIfComplete(true)
                .<LinkedHashMap, String>chunk(1)
                .reader(jsonItemReader(OVERRIDDEN_BY_EXPRESSION, OVERRIDDEN_BY_EXPRESSION))
                .processor(javaDomenProcessor)
                .writer(flatFileItemWriter)
                .build();
    }

    /*
     * Генерация классов для JHipster
     */
    @Bean(name = "JHipsterClassGeneratorStep")
    public Step MakeJHipsterObjectStep(
            ItemReader<LinkedHashMap> jsonItemReader,
            JHipsterProcessor jHipsterProcessor,
            FlatFileItemWriter flatFileItemWriter
    ) {
        return stepBuilderFactory.get(JHIPSTER_PROCESSOR_STEP)
                .allowStartIfComplete(true)
                .<LinkedHashMap, String>chunk(1)
                .reader(jsonItemReader(OVERRIDDEN_BY_EXPRESSION, OVERRIDDEN_BY_EXPRESSION))
                .processor(jHipsterProcessor)
                .writer(flatFileItemWriter)
                .build();
    }

    /*
     * Генерация Java классов
     */
    @Bean(name = "JavaClassGeneratorJob")
    public Job javaClassGeneratorJob(@Qualifier("JavaClassGeneratorStep") Step javaClassGeneratorStep) {
        return jobBuilderFactory.get(JOB_MAKE_JAVA_DOMAIN_OBJECT)
                .start(javaClassGeneratorStep)
                .build();
    }

    /*
     * Генерация классов для JHipster
     */
    @Bean(name = "JHipsterClassGeneratorJob")
    public Job jHipsterClassGeneratorJob(@Qualifier("JHipsterClassGeneratorStep") Step jHipsterClassGeneratorStep) {
        return jobBuilderFactory.get(JOB_MAKE_JHIPSTER_OBJECT)
                .start(jHipsterClassGeneratorStep)
                .build();
    }
}
