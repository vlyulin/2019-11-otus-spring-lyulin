package ru.otus.studentstesting03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.otus.studentstesting03.domain.QuizPlayer;
import ru.otus.studentstesting03.service.QuizPlayerService;

@SpringBootApplication
// implements CommandLineRunner
public class StudentsTesting03Application  {

	@Autowired
	private QuizPlayerService quizPlayerService;

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(StudentsTesting03Application.class, args);
		QuizPlayerService quizPlayerService = ctx.getBean(QuizPlayerService.class);
		QuizPlayer quizPlayer = quizPlayerService.get();
		quizPlayer.play();
	}

//	@Override
//	public void run(String... args) throws Exception {
//		QuizPlayer quizPlayer = quizPlayerService.get();
//		quizPlayer.play();
//	}

}
