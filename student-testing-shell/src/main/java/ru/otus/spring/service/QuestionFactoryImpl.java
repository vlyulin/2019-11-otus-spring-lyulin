package ru.otus.spring.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.domain.OneChoiceQuestion;
import ru.otus.spring.domain.Question;
import ru.otus.spring.service.exceptions.QuestionFactoryException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Создание вопросов различных типов в зависимости от данных
 */
@Service
public class QuestionFactoryImpl implements QuestionFactory {

    @Override
    public Question getQuestion(String[] strArr) throws QuestionFactoryException {

        if (strArr == null || strArr.length < 3 ) {
            throw new QuestionFactoryException("Error during build question.");
        }

        try {
            int id = Integer.parseInt(strArr[0]);
            String questionType = strArr[1];
            String questionMsg = strArr[2];
            String rightAnswer = strArr[3];

            switch(questionType) {
                case "FREE_ANSWER":
                    return new Question(id, questionMsg, rightAnswer);
                case "LIST_WITH_ONE_CHOICE":
                    List<String> answers = new ArrayList<>(Arrays.asList(strArr).subList(4,strArr.length));
                    int rightAnswerInt = Integer.parseInt(rightAnswer);
                    return new OneChoiceQuestion(id, questionMsg, answers, rightAnswerInt);
            }
        } catch (NumberFormatException e) {
            throw new QuestionFactoryException("Error during build question.");
        }
        return null;
    }
}
