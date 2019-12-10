package ru.otus.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.otus.spring.config.QuizSettings;
import ru.otus.spring.domain.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Configuration
@ComponentScan
public class Main {

    private static Person getStudentName(AnnotationConfigApplicationContext ctx) {
        String studentName = "Noname";
        String studentLastName = "Noname";

        MessageSource messageSource = ctx.getBean(MessageSource.class);
        QuizSettings  quizSettings  = ctx.getBean(QuizSettings.class);

        java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(
                messageSource.getMessage("ASK_STUDENT_NAME", null, quizSettings.getQuizLocale())
        );
        try {
            studentName = in.readLine();
            if( studentName.isEmpty() || studentName.isBlank() ) {
                studentName = "Noname";
                System.out.println(
                        messageSource.getMessage("NONAME", new String[] {"Noname"}, quizSettings.getQuizLocale())
                );
            }
        } catch (IOException e) {
            studentName = "Noname";
            System.out.println(
                    messageSource.getMessage("NONAME", new String[] {"Noname"}, quizSettings.getQuizLocale())
            );
        }

        System.out.println(
                messageSource.getMessage("ASK_STUDENT_LASTNAME", null, quizSettings.getQuizLocale())
        );
        try {
            studentLastName = in.readLine();
            if( studentLastName.isEmpty() || studentLastName.isBlank() ) {
                studentLastName = "Noname";
            }
        } catch (IOException e) {
            studentLastName = "Noname";
        }

        return ctx.getBean(Person.class, studentName, studentLastName);
    };

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(Main.class);

        // Запросить имя
        Person student = getStudentName(ctx);

        // Собираем имя свойства определяющего имя файла в завимсимости от локали
        // Свойства имеют вид quiz_<локаль>
        // Файлы определяются как quiz_<локаль>.csv
        StringBuilder sb = new StringBuilder("quiz_");
        sb.append(ctx.getEnvironment().getProperty("locale"));

        QuizSet quizSet = ctx.getBean(QuizSet.class, ctx.getEnvironment().getProperty(sb.toString()));
        QuizPlayer quizPlayer = ctx.getBean(QuizPlayer.class, student, quizSet);

        // Приветствие студента
        quizPlayer.greeting();
        // Проведение тестирования и отображение результата
        quizPlayer.play();
    }
}
