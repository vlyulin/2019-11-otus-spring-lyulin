package ru.otus.spring.service;

import ru.otus.spring.domain.QuizSet;
import ru.otus.spring.service.exceptions.QuestionFactoryException;
import ru.otus.spring.service.exceptions.QuizSetLoadException;

public interface QuizSetService {
    QuizSet getQuizSet() throws QuizSetLoadException, QuestionFactoryException;
}
