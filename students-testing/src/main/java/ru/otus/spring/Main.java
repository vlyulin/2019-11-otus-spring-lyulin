package ru.otus.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.otus.spring.domain.QuizPlayer;
import ru.otus.spring.service.QuizPlayerService;

@Configuration
@ComponentScan
public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(Main.class);

        QuizPlayerService quizPlayerService = ctx.getBean(QuizPlayerService.class);
        QuizPlayer player = quizPlayerService.get();
        player.play();
    }
}
