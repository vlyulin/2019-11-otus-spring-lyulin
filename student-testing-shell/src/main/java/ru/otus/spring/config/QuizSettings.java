package ru.otus.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class QuizSettings {
    private Locale locale;
    private String quizFileName;

    public QuizSettings( ApplicationSettings settings ) {
        this.locale = new Locale(settings.getLanguage(), settings.getCountry());
        this.quizFileName = String.format("%s_%s_%s.csv", settings.getBase(), settings.getLanguage(), settings.getCountry());
    }

    public Locale getLocale() {
        return locale;
    }

    public String getQuizFileName() {
        return quizFileName;
    }
}
