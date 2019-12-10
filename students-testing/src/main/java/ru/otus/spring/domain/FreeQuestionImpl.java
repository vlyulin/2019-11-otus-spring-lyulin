package ru.otus.spring.domain;

import java.util.List;

/**
 * Реализация вопроса с произвольным ответом
 */
public class FreeQuestionImpl implements Question {

    private Integer        id; // номер вопроса
    private String         question;
    private String         rightAnswer;
    private Boolean        rightAnswerFlag = false;

    public FreeQuestionImpl(Integer id,
                            String question,
                            String rightAnswer) {
        this.id          = id;
        this.question    = question;
        this.rightAnswer = rightAnswer;
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public void processAnswer(String answer) {
        rightAnswerFlag = (rightAnswer.equals(answer))? true : false;
    }

    @Override
    public Boolean isRightAnswer() {
        return rightAnswerFlag;
    }
}
