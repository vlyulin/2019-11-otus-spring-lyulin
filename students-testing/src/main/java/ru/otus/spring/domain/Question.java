package ru.otus.spring.domain;

/**
 * Вопрос.
 * Сам знает, что спросить, сам знает, как проверить ответ
 */
public class Question {

    private int     id; // номер вопроса
    private String  question;
    private String  rightAnswer;
    private boolean rightAnswerFlag = false;

//    public Question() {
//
//    }

    public Question (int id,
                     String question,
                     String rightAnswer) {
        this.id          = id;
        this.question    = question;
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
}
