package ru.otus.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ConfigurableApplicationContext;
import ru.otus.spring.service.QuizPlayer;

@SpringBootApplication
public class Main {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext ctx = SpringApplication.run(Main.class, args);
        QuizPlayer player = ctx.getBean(QuizPlayer.class);
        player.play();
    }
}
