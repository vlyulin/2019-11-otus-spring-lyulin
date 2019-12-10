package ru.otus.spring.domain;

import java.util.Iterator;
import java.util.List;

public class QuizSetImpl<Question> implements QuizSet<Question> {

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
    public void printScore() {
        System.out.println("print score");
        // Не понимаю, почему в данном месте не вижу методов интерфейса Question
        // Из=за этого не могу подсчитать результат тестирования в классе QuizSetImpl
        for( Question q: questions ) {
            // не вижу q.isRightAnswer
        }
    }
}
