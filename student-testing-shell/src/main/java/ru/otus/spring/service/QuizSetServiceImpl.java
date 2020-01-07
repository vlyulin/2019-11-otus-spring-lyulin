package ru.otus.spring.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.dao.QuizSetDao;
import ru.otus.spring.domain.QuizSet;
import ru.otus.spring.service.exceptions.QuestionFactoryException;
import ru.otus.spring.service.exceptions.QuizSetLoadException;

@Service
public class QuizSetServiceImpl implements QuizSetService {
    private final QuizSetDao quizSetDao;

    public QuizSetServiceImpl(QuizSetDao quizSetDao) {
        this.quizSetDao = quizSetDao;
    }

    @Override
    public QuizSet getQuizSet() throws QuizSetLoadException, QuestionFactoryException {
        return quizSetDao.loadQuizSet();
    }
}
