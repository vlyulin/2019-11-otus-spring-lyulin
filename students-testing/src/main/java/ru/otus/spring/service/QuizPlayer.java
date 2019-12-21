package ru.otus.spring.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.domain.Question;
import ru.otus.spring.domain.QuizSet;
import ru.otus.spring.domain.Student;
import ru.otus.spring.service.ConsoleMessageService;
import ru.otus.spring.service.exceptions.QuestionFactoryException;
import ru.otus.spring.service.exceptions.QuizSetLoadException;
import ru.otus.spring.service.exceptions.StudentInfoReadException;

import java.io.IOException;
import java.util.List;

/**
 * Универсальный проигрыватель наборов тестов (QuizSet)
 * Набор тестов (QuizSet) определяет набор вопросов, их последовательность
 * и правила подсчета результатов
 */
@Service
public class QuizPlayer {

    private static final String MSG_KEY_NO_QUESTIONS = "NO_QUESTIONS";
    private static final String MSG_KEY_YOUR_SCORE = "YOUR_SCORE";
    private static final String MSG_KEY_WELCOME = "WELCOME";
    private static final String MSG_KEY_NUMBER_EXPECTED = "NUMBER_EXPECTED";

    private final ConsoleMessageService ms;
    private final StudentService studentService;
    private final QuizSetService quizSetService;

    public QuizPlayer(
            ConsoleMessageService ms,
            StudentService studentService,
            QuizSetService quizSetService
    ) {
        this.ms = ms;
        this.studentService = studentService;
        this.quizSetService = quizSetService;
    }

    /**
     * Проведение опроса
     */
    public void play() throws StudentInfoReadException, QuizSetLoadException, QuestionFactoryException {

        Student student = studentService.getStudent();
        QuizSet quizSet = quizSetService.getQuizSet();

        greeting(student);

        if( quizSet == null || quizSet.getQuestions().isEmpty() || quizSet.getQuestions().size() == 0 ) {
            ms.printMessageByKey(MSG_KEY_NO_QUESTIONS, student.getName());
            return;
        }

        // Само проведение опроса
        List<Question> questions = quizSet.getQuestions();
        int idx = 0;
        for (Question question: questions) {
            ++idx;
            try {
                ms.printMessage(String.format("%d. %s", idx, question.getQuestion()));
                question.processAnswer(ms.readLn());
            }
            catch(NumberFormatException nfe) {
                ms.printMessageByKey(MSG_KEY_NUMBER_EXPECTED, nfe.toString());
            }
        }
        // Вывод результата опроса
        ms.printMessageByKey(MSG_KEY_YOUR_SCORE, quizSet.getScore());
    }

    public void greeting(Student student) {
        ms.printMessageByKey(MSG_KEY_WELCOME, student.getName());
    }
}
