package ru.otus.spring.domain;

import java.util.List;

public class QuizSetImpl implements QuizSet {

    private List<Question> questions;

    public QuizSetImpl(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public List<Question> getQuestions() {
        return questions;
    }

    @Override
    public String getScore() {
        int rightAnswersAmount = 0;

        for( Question q: questions ) {
            if( q.isRightAnswer()) {
                rightAnswersAmount++;
            }
        }
        double score = (double)rightAnswersAmount / questions.size() * 100;
        return String.format("%.2f", score) + "%";
    }
}
