package ru.otus.spring.library.rest.services;

public interface MessageService {
    void printMessage(String message);
    void printMessageByKey(String messageKey);
    void printMessageByKey(String messageKey, Object... args);
    String readLn();
    String readLn(String promptMessageKey);
}
