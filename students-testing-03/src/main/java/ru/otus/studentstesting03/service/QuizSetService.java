package ru.otus.studentstesting03.service;

import ru.otus.studentstesting03.domain.Question;
import ru.otus.studentstesting03.domain.QuizSet;

import java.io.IOException;

public interface QuizSetService {
    QuizSet<Question> getByName(String name) throws IOException;
}
