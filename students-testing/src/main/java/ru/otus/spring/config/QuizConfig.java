package ru.otus.spring.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
@PropertySource("classpath:quiz.properties")
public class QuizConfig {

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms =
                new ReloadableResourceBundleMessageSource();
        ms.setBasename("/bundle");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
