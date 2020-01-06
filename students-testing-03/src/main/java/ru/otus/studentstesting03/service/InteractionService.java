package ru.otus.studentstesting03.service;

import java.io.IOException;

public interface InteractionService {
    void print(String message);
    void printTag(String messageTag);
    void printTag(String messageTag, String message);
    String readLine() throws IOException;
}
