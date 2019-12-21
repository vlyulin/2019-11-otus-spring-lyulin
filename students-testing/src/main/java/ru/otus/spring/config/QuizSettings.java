package ru.otus.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class QuizSettings {
    private Locale locale;
    private String quizFileName;

    public QuizSettings(@Value("${locale.language:ru}") String language,
                        @Value("${locale.country:RU}") String country,
                        @Value("${quiz.file.name.base:quiz}") String quizFileName) {
        this.locale = new Locale(language, country);
        this.quizFileName = String.format("%s_%s_%s.csv", quizFileName, language, country);
    }

    public Locale getLocale() {
        return locale;
    }

    public String getQuizFileName() {
        return quizFileName;
    }
}
