package ru.otus.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Main.class, args);
        // ConfigurableApplicationContext ctx = SpringApplication.run(Main.class, args);
        // QuizPlayer player = ctx.getBean(QuizPlayer.class);
        // player.play();
    }
}
