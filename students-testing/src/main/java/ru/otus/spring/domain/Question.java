package ru.otus.spring.domain;

import java.util.Objects;

/**
 * Вопрос.
 * Сам знает, что спросить, сам знает, как проверить ответ
 */
public class Question {

    private int id;
    private String question;
    private String rightAnswer;
    private boolean rightAnswerFlag = false;

    public Question(int id,
                    String question,
                    String rightAnswer) {
        this.id = id;
        this.question = question;
        this.rightAnswer = rightAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public void processAnswer(String answer) {
        rightAnswerFlag = rightAnswer.equals(answer);
    }

    public Boolean isRightAnswer() {
        return rightAnswerFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;
        Question question1 = (Question) o;
        return id == question1.id &&
                rightAnswerFlag == question1.rightAnswerFlag &&
                question.equals(question1.question) &&
                rightAnswer.equals(question1.rightAnswer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question, rightAnswer, rightAnswerFlag);
    }
}
