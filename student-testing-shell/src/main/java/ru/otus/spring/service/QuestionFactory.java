package ru.otus.spring.service;

import ru.otus.spring.domain.Question;
import ru.otus.spring.service.exceptions.QuestionFactoryException;

public interface QuestionFactory {
    Question getQuestion(String[] strArr) throws QuestionFactoryException;
}
