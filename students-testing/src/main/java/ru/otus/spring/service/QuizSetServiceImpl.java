package ru.otus.spring.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.dao.QuizSetDao;
import ru.otus.spring.domain.Question;
import ru.otus.spring.domain.QuizSet;

import java.io.IOException;

@Service
public class QuizSetServiceImpl implements QuizSetService {
    private final QuizSetDao quizSetDao;

    public QuizSetServiceImpl(QuizSetDao quizSetDao) {
        this.quizSetDao = quizSetDao;
    }

    @Override
    public QuizSet<Question> getByName(String name) throws IOException {
        return quizSetDao.getByName(name);
    }
}
