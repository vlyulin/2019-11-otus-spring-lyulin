package ru.otus.studentstesting03.service;

import org.springframework.stereotype.Service;
import ru.otus.studentstesting03.dao.QuizSetDao;
import ru.otus.studentstesting03.domain.Question;
import ru.otus.studentstesting03.domain.QuizSet;

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
