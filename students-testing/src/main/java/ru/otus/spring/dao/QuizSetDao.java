package ru.otus.spring.dao;

import ru.otus.spring.domain.QuizSet;
import ru.otus.spring.service.exceptions.QuestionFactoryException;
import ru.otus.spring.service.exceptions.QuizSetLoadException;

public interface QuizSetDao {
    QuizSet loadQuizSet() throws QuizSetLoadException, QuestionFactoryException;
}
