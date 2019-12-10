package ru.otus.spring.config;

import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * Глобальные переменные
 */
@Component
public class QuizSettings {

    private Locale quizLocale = Locale.ENGLISH;

    public void setQuizLocale(Locale quizLocale) {
        this.quizLocale = quizLocale;
    }

    public Locale getQuizLocale() {
        return quizLocale;
    }
}
