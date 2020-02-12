package ru.otus.spring.service;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.spring.service.exceptions.QuestionFactoryException;
import ru.otus.spring.service.exceptions.QuizSetLoadException;
import ru.otus.spring.service.exceptions.StudentInfoReadException;

@ShellComponent
public class QuizPlayerShell {
    private final QuizPlayer quizPlayer;

    public QuizPlayerShell(QuizPlayer quizPlayer) {
        this.quizPlayer = quizPlayer;
    }

    @ShellMethod(key = {"start-player","start","play"}, value="Start test.", prefix="-")
    public void startTest() {
        try {
            quizPlayer.play();
        } catch (StudentInfoReadException e) {
            e.printStackTrace();
        } catch (QuizSetLoadException e) {
            System.out.println("Error loading test questions: " + e.getMessage());
        } catch (QuestionFactoryException e) {
            System.out.println("Data corrupted: " + e.getMessage());;
        }
    }
}
