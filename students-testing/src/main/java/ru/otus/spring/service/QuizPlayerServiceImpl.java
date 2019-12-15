package ru.otus.spring.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.domain.Person;
import ru.otus.spring.domain.Question;
import ru.otus.spring.domain.QuizPlayer;
import ru.otus.spring.domain.QuizSet;

@Service
public class QuizPlayerServiceImpl implements QuizPlayerService {

    private final InteractionService interactionService;
    private final PersonService personService;
    private final QuizSet<Question> quizSet;

    public QuizPlayerServiceImpl(
            InteractionService interactionService,
            PersonService personService,
            QuizSet<Question> quizSet
    ) {
        this.interactionService = interactionService;
        this.personService = personService;
        this.quizSet = quizSet;
    }

    @Override
    public QuizPlayer get() {
        Person examinee = personService.getStudent();
        return new QuizPlayer(interactionService, examinee, quizSet);
    }
}
