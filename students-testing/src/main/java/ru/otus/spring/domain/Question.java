package ru.otus.spring.domain;

/**
 * Вопрос.
 * Сам знает, что спросить, сам знает, как проверить ответ
 */
public interface Question {
    String  getQuestion();
    void    processAnswer(String answer);
    Boolean isRightAnswer();
}
