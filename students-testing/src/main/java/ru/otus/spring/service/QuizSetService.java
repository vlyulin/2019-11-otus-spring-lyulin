package ru.otus.spring.service;

import ru.otus.spring.domain.Question;
import ru.otus.spring.domain.QuizSet;

import java.io.IOException;

public interface QuizSetService {
    QuizSet<Question> getByName(String name) throws IOException;
}
