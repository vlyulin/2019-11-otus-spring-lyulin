package ru.otus.spring.domain;

import java.util.List;

/**
 * Набор вопросов для тестирования.
 * Так же класс, реализующий данный интерфейс должен уметь подсчитывать результат прохождения теста.
 */
public interface QuizSet<Question> extends Iterable<Question> {
        List<Question> getQuestions();

        /**
         * Печать результатов прохождения теста
         */
        void printScore(); // печать прохождения теста
}
