package ru.otus.spring.libraryspringnosql.services;

public interface IOService {
    void printLn(String msg);
    String readLn();
    String readLn(String msg);
}
