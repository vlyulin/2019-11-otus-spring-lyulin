package ru.otus.spring.service.exceptions;

public class QuizSetLoadException extends Exception {
    public QuizSetLoadException(String message, Exception e) {
        super(message + " " + e.toString());
    }
}
