package ru.otus.studentstesting03.dao;

import ru.otus.studentstesting03.domain.OneChoiceQuestion;
import ru.otus.studentstesting03.domain.Question;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Создание вопросов различных типов в зависимости от данных
 */
public class QuestionFactory {

    public Question getQuestion(String[] strArr) throws IOException {
        // Если что-то пошло не так, или явно переданна ошибочная структура сообщения,
        // то ничего и не возвращаем
        if (strArr == null || strArr.length < 3 ) {
            // пропускаем пустые строки
            return null;
        }

        Question question = null;
        int id = Integer.parseInt(strArr[0]);
        String  questionType    = strArr[1];
        String  questionMsg     = strArr[2];
        String  rightAnswer     = strArr[3];

        switch(questionType) {
            case "FREE_ANSWER":
                // question = freeQuestionImpl(id, questionMsg, rightAnswer);
                question = new Question(id, questionMsg, rightAnswer);
                break;

            case "LIST_WITH_ONE_CHOICE":
                List<String> answers = new ArrayList<String>();
                for (int idx = 4; idx < strArr.length; idx++) {
                    answers.add(strArr[idx]);
                }

                int rightAnswerInt = Integer.parseInt(rightAnswer);

                question = new OneChoiceQuestion(
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
