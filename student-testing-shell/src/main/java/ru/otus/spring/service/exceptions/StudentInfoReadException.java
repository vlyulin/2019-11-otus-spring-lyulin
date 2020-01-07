package ru.otus.spring.service.exceptions;

public class StudentInfoReadException extends Exception {
    public StudentInfoReadException(String message, Throwable cause) {
        super(message, cause);
    }
}
