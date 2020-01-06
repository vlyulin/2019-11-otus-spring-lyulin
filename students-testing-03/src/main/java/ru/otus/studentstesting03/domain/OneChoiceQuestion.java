package ru.otus.studentstesting03.domain;

import java.util.List;

/**
 * Реализация вопроса с выбором ответа из множества вариантов
 */
public class OneChoiceQuestion extends Question {

    private int             id; // номер вопроса
    private String          question;
    private int             rightAnswer;
    private List<String>    answers;
    private boolean         rightAnswerFlag = false;

    public OneChoiceQuestion(int id,
                             String question,
                             List<String> answers,
                             int rightAnswer) {
        super(id, question, Integer.toString(rightAnswer));
        this.id              = id;
        this.question        = question;
        this.answers         = answers;
        this.rightAnswer     = rightAnswer;
    }

    @Override
    public String getQuestion() {

        StringBuilder sb = new StringBuilder(question);
        sb.append(System.getProperty("line.separator"));
        // формирование строки с вариантами ответов
        for( int idx = 0; idx < answers.size(); idx++ ) {
            sb.append(idx+1);
            sb.append(") ");
            sb.append(answers.get(idx));
            if (idx < answers.size()-1 ) {
                sb.append(System.getProperty("line.separator"));
            }
        }
        return sb.toString();
    }

    @Override
    public void processAnswer(String answer) {
        int userAnswer = Integer.parseInt(answer);
        rightAnswerFlag = (rightAnswer == userAnswer);
    }

    @Override
    public Boolean isRightAnswer() {
        return rightAnswerFlag;
    }
}
