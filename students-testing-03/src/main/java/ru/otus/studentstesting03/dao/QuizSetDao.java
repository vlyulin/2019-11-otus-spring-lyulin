package ru.otus.studentstesting03.dao;

import ru.otus.studentstesting03.domain.Question;
import ru.otus.studentstesting03.domain.QuizSet;

import java.io.IOException;

public interface QuizSetDao {
    QuizSet<Question> getByName(String name) throws IOException;
}
