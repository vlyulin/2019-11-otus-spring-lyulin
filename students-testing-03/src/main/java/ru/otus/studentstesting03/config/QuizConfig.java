package ru.otus.studentstesting03.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import ru.otus.studentstesting03.domain.*;
import ru.otus.studentstesting03.service.*;

import java.io.IOException;
import java.util.*;

@Configuration
public class QuizConfig {

    @Value("${localization.language}")
    private String localeLanguage = "ru";
    @Value("${localization.country}")
    private String localeCountry = "RU";

    @Autowired
    private Environment env;

    private static final String QUIZ_FILE_PREFIX = "datafiles.quiz_";

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
        String file_name = env.getProperty(sb.toString());
        if (file_name == null || file_name.isEmpty() || file_name.isBlank()) {
            console.printTag("NO_PROPERTY_DEFINED", sb.toString());
            throw new IOException();
        }

        try {
            quizSet = quizSetService.getByName(file_name);
        } catch (IOException ioe ) {
            console.printTag("NO_DATA_FOUND", sb.toString());
            throw new IOException(ioe);
        }
        return quizSet;
    }
}
