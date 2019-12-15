package ru.otus.spring.dao;

import ru.otus.spring.domain.Question;
import ru.otus.spring.domain.QuizSet;

import java.io.IOException;

public interface QuizSetDao {
    QuizSet<Question> getByName(String name) throws IOException;
}
