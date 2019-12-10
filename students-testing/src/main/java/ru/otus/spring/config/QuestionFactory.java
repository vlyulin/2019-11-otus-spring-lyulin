package ru.otus.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.otus.spring.domain.FreeQuestionImpl;
import ru.otus.spring.domain.OneChoiceQuestionImpl;
import ru.otus.spring.domain.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * Создание вопросов различных типов в зависимости от данных
 */
@Configuration
public class QuestionFactory {

    @Bean
    @Scope(value = "prototype")
    FreeQuestionImpl freeQuestionImpl (
            Integer id,
            String question,
            String rightAnswer
    ) {
        return new FreeQuestionImpl(id, question, rightAnswer);
    }

    @Bean
    @Scope(value = "prototype")
    OneChoiceQuestionImpl oneChoiceQuestionImpl (
            Integer id,
            String question,
            List<String> answers,
            Integer rightAnswer ) {
        return new OneChoiceQuestionImpl( id, question, answers, rightAnswer );
    }

    public Question getQuestion(String[] strArr ) {
        // Если что-то пошло не так или явно переданна ошибочная структура сообщения,
        // то ничего и не возвращаем
        if (strArr == null || strArr.length < 3 ) {
            // TODO: Поругаться при передаче некорректных данных для создания вопроса
            return null;
        }

        Question question = null;
        Integer id = Integer.parseInt(strArr[0]);
        String  questionType    = strArr[1];
        String  questionMsg     = strArr[2];
        String  rightAnswer     = strArr[3];

        switch(questionType) {
            case "FREE_ANSWER":
                question = freeQuestionImpl(id, questionMsg, rightAnswer);
                break;

            case "LIST_WITH_ONE_CHOICE":
                List<String> answers = new ArrayList<String>();
                for (int idx = 4; idx < strArr.length; idx++) {
                    answers.add(strArr[idx]);
                }
                Integer rightAnswerInt;
                try {
                    rightAnswerInt = Integer.parseInt(rightAnswer);
                } catch (Exception e){
                    // Беда с данными
                    // TODO: Поругаться при передаче некорректных данных для создания вопроса
                    return null;
                }
                question = oneChoiceQuestionImpl (
                                    id,
                                    questionMsg,
                                    answers,
                                    rightAnswerInt
                           );
                break;
        }

        return question;
    }
}
