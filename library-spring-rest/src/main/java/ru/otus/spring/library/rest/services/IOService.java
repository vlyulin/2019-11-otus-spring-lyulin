package ru.otus.spring.library.rest.services;

public interface IOService {
    void printLn(String msg);
    String readLn();
    String readLn(String msg);
}
