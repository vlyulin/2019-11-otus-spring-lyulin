package ru.otus.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.otus.spring.service.QuizPlayer;

@Configuration
@ComponentScan
public class Main {

    public static void main(String[] args) throws Exception {

        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(Main.class);

        QuizPlayer player = ctx.getBean(QuizPlayer.class);
        player.play();
    }
}
