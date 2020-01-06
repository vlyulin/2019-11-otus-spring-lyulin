package ru.otus.studentstesting03.domain;

import java.util.Iterator;
import java.util.List;

public class QuizSetImpl implements QuizSet<Question> {

    private List<Question> questions;

    public QuizSetImpl(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public Iterator<Question> iterator() {
        return this.questions.iterator();
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
