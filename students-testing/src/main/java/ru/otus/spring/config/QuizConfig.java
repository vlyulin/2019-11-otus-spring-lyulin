package ru.otus.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.otus.spring.domain.*;
import ru.otus.spring.service.*;

import java.io.IOException;
import java.util.*;

@Configuration
@PropertySource("classpath:quiz.properties")
public class QuizConfig {

    @Value("${locale_language}")
    private String localeLanguage = "ru";
    @Value("${locale_country}")
    private String localeCountry = "RU";

    private static final String QUIZ_FILE_PREFIX = "quiz_";

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms =
                new ReloadableResourceBundleMessageSource();
        ms.setBasename("/bundle");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }

    @Bean
    public InteractionService interactionService( MessageSource messageSource ) {

        Locale locale = null;

        // Установка по умолчанию, если не установлен язык
        if(localeLanguage == null ) {
            localeLanguage = "ru";
            localeCountry = "RU";
        }

        if(localeCountry == null) {
            locale = new Locale(localeLanguage);
        }
        else {
            locale = new Locale(localeLanguage, localeCountry);
        }

        return new InteractionServiceImpl(messageSource, locale);
    }

    @Bean
    PersonService personService(InteractionService console) {
        return new PersonServiceImpl(console);
    }

    @Bean
    QuizSet<Question> quizSet(InteractionService console, QuizSetService quizSetService ) throws IOException {
        QuizSet<Question> quizSet = null;

        if(localeLanguage == null || localeLanguage.isEmpty() || localeLanguage.isBlank()) {
            localeLanguage = "ru";
            localeCountry = "RU";
        }

        StringBuilder sb = new StringBuilder(QUIZ_FILE_PREFIX);
        sb.append(localeLanguage);
        if (localeCountry.length() > 0) {
            sb.append("_");
            sb.append(localeCountry);
        }
        sb.append(".csv");
        try {
            quizSet = quizSetService.getByName(sb.toString());
        } catch (IOException ioe ) {
            console.printTag("NO_DATA_FOUND", sb.toString());
            throw new IOException(ioe);
        }
        return quizSet;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
