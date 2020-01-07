package ru.otus.spring.dao;

import org.junit.jupiter.api.Test;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import ru.otus.spring.config.ApplicationSettings;
import ru.otus.spring.config.QuizSettings;
import ru.otus.spring.domain.OneChoiceQuestion;
import ru.otus.spring.domain.Question;
import ru.otus.spring.domain.QuizSet;
import ru.otus.spring.service.QuestionFactory;
import ru.otus.spring.service.QuestionFactoryImpl;
import ru.otus.spring.service.exceptions.QuizSetLoadException;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@EnableConfigurationProperties
@ComponentScan("ru.otus.spring.config")
@Import({QuizSetCsvDao.class, QuizSettings.class, ApplicationSettings.class})
class QuizSetCsvDaoTest {

    @Test
    void loadQuizSet() {

        List<Question> referenceQuestions = new ArrayList();
        referenceQuestions.add(new Question(3, "TEST Вам нравится Spring? (Y/N)", "Y"));
        referenceQuestions.add(
                new OneChoiceQuestion(1,
                        "TEST Сколько будет 1 + 1?",
                        Arrays.asList("1", "2", "3", "4", "5"),
                        2)
        );
        referenceQuestions.add(
                new OneChoiceQuestion(2,
                        "TEST Сколько будет 2 + 2?",
                        Arrays.asList("1", "2", "3", "4", "5"),
                        4)
        );

        QuizSettings quizSettingsMock = mock(QuizSettings.class);
        when(quizSettingsMock.getLocale()).thenReturn(new Locale("ru", "RU"));
        when(quizSettingsMock.getQuizFileName()).thenReturn("test_quiz_ru_RU.csv");

        QuestionFactory questionFactory = new QuestionFactoryImpl();
        QuizSetCsvDao quizSetCsvDao = new QuizSetCsvDao(quizSettingsMock, questionFactory);

        try {
            QuizSet quizSet = quizSetCsvDao.loadQuizSet();
            List<Question> questions = quizSet.getQuestions();
            assertArrayEquals(referenceQuestions.toArray(), questions.toArray(), "Различный список вопросов");
        } catch (QuizSetLoadException e) {
            e.printStackTrace();
        }
    }
}