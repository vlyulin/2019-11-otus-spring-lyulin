package ru.otus.spring.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.otus.spring.config.QuizSettings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/**
 * Универсальный проигрыватель наборов тестов (QuizSet)
 */

@Component
@Scope(value = "prototype")
public class QuizPlayer {

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private QuizSettings quizSettings;

    private Person  examinee;
    private QuizSet quizSet;

    public QuizPlayer ( Person person, QuizSet quizSet ) {
        this.examinee = person;
        this.quizSet = quizSet;
    }

    /**
     * Приветствие перед опросом
     */
    public void greeting() {
        System.out.println(
                messageSource.getMessage(
                        "WELCOME",
                        new String[] {examinee.getName()},
                        quizSettings.getQuizLocale()
                )
        );
    }

    /**
     * Проведение опроса
     */
    public void play() {
        int idx = 1;
        java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        if( quizSet.getQuestions().isEmpty() || quizSet.getQuestions().size() == 0 ) {
            System.out.println(
                messageSource.getMessage(
                        "NO_QUESTIONS",
                        new String[] {examinee.getName()},
                        quizSettings.getQuizLocale()
                )
            );
            return;
        }

        // Само проведение опроса
        Iterator<Question> it = quizSet.iterator();
        while(it.hasNext() ) {
            Question question = it.next();

            System.out.println( idx++ + ". " + question.getQuestion() );
            try {
                String answer = in.readLine();
                question.processAnswer(answer);
            }
            catch(IOException ioe) {
                System.err.println(
                        messageSource.getMessage(
                                "SOMETHING_WENT_WRONG",
                                new String[] {ioe.toString()},
                                quizSettings.getQuizLocale()
                        )
                );
                return;
            }
        }

        // Вывод результата
        // quizSet.printScore();
        // TODO: Переделать после того, как в quizSet разберусь почему не виден метод Question.isRightAnswer
        it = quizSet.iterator();
        Integer rightAnswerCounter = 0;
        while(it.hasNext() ) {
            Question q = it.next();
            if(q.isRightAnswer()) {
                rightAnswerCounter++;
            }
        }

        Double score = rightAnswerCounter.doubleValue() / quizSet.getQuestions().size() * 100;
        System.err.println(
                messageSource.getMessage(
                        "YOUR_SCORE",
                        new String[] {String.format("%.2f", score) + "%"},
                        quizSettings.getQuizLocale()
                )
        );
    }
}
