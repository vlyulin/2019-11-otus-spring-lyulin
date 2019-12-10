package ru.otus.spring.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.otus.spring.config.QuizSettings;

import java.util.List;
import java.util.Locale;

/**
 * Реализация вопроса с выбором ответа из множества вариантов
 */
@Component
@Scope(value = "prototype")
public class OneChoiceQuestionImpl implements Question {

    private MessageSource   messageSource;
    private QuizSettings    quizSettings;

    private Integer         id; // номер вопроса
    private String          question;
    private Integer         rightAnswer;
    private List<String>    answers;
    private Boolean         rightAnswerFlag = false;

    public OneChoiceQuestionImpl(Integer id,
                                 String question,
                                 List<String> answers,
                                 Integer rightAnswer) {
        this.id          = id;
        this.question    = question;
        this.answers     = answers;
        this.rightAnswer = rightAnswer;
    }

    // Я так и не понял, почему через setter autowire отработало, и объект привязался,
    // а через @Autowire private MessageSource messageSource; - нет
    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Autowired
    public void setQuizSettings(QuizSettings quizSettings) {
        this.quizSettings = quizSettings;
    }

    @Override
    public String getQuestion() {

        StringBuilder sb = new StringBuilder(question);
        sb.append(System.getProperty("line.separator"));
        sb.append(
                messageSource.getMessage(
                    "choose_answer",
                    null,
                    quizSettings.getQuizLocale()
                )
        );
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
        Integer userAnswer = -1;
        try {
            userAnswer = Integer.parseInt(answer);
        }
        catch (Exception e) {
            System.err.println(
                    messageSource.getMessage(
                            "NUMBER_EXPECTED",
                            new String[] {e.toString()},
                            quizSettings.getQuizLocale()
                    )
            );
        }
        rightAnswerFlag = (rightAnswer == userAnswer)? true : false;
    }

    @Override
    public Boolean isRightAnswer() {
        return rightAnswerFlag;
    }
}
