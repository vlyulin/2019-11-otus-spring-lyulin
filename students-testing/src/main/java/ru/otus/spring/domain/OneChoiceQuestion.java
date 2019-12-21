package ru.otus.spring.domain;

import java.util.List;
import java.util.Objects;

/**
 * Реализация вопроса с выбором ответа из множества вариантов
 */
public class OneChoiceQuestion extends Question {

    private List<String>    answers;

    public OneChoiceQuestion(int id,
                              String question,
                              List<String> answers,
                              int rightAnswer) {
        super(id, question, Integer.toString(rightAnswer));
        this.answers = answers;
    }

    @Override
    public String getQuestion() {

        StringBuilder sb = new StringBuilder(super.getQuestion());
        sb.append(System.getProperty("line.separator"));
        // формирование строки с вариантами ответов
        for(int idx = 0; idx < answers.size(); idx++ ) {
            sb.append(idx+1).append(") ").append(answers.get(idx));
            if(idx < answers.size()-1) {
                sb.append(System.getProperty("line.separator"));
            }
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OneChoiceQuestion)) return false;
        if (!super.equals(o)) return false;
        OneChoiceQuestion that = (OneChoiceQuestion) o;
        return answers.equals(that.answers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), answers);
    }
}
