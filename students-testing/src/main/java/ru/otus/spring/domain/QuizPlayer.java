package ru.otus.spring.domain;

import ru.otus.spring.service.InteractionService;

import java.io.IOException;
import java.util.Iterator;

/**
 * Универсальный проигрыватель наборов тестов (QuizSet)
 */
public class QuizPlayer {

    private final InteractionService console;
    private final Person  examinee;
    private final QuizSet<Question> quizSet;

    public QuizPlayer (InteractionService interactionService, Person examinee, QuizSet<Question> quizSet ) {
        this.console = interactionService;
        this.examinee = examinee;
        this.quizSet = quizSet;
    }

    /**
     * Проведение опроса
     */
    public void play() {
        int idx = 1;

        greeting();

        if( quizSet.getQuestions().isEmpty() || quizSet.getQuestions().size() == 0 ) {
            console.printTag("NO_QUESTIONS",examinee.getName());
            return;
        }

        // Само проведение опроса
        Iterator<Question> it = quizSet.iterator();
        while(it.hasNext() ) {
            Question question = it.next();
            console.print(idx++ + ". " + question.getQuestion());
            try {
                question.processAnswer(console.readLine());
            }
            catch(NumberFormatException nfe) {
                console.printTag("NUMBER_EXPECTED", nfe.toString());
            }
            catch(IOException ioe) {
                console.printTag("SOMETHING_WENT_WRONG", ioe.toString());
                return;
            }
        }

        // Вывод результата
        console.printTag("YOUR_SCORE", quizSet.getScore());
    }

    public void greeting() {
        console.printTag("WELCOME", examinee.getName());
    }
}
