package ru.otus.spring.domain;

import static org.junit.jupiter.api.Assertions.*;

class FreeQuestionImplTest {

    Question freeQuestionImpl = new Question(1,"Question?", "Answer");

    @org.junit.jupiter.api.Test
    void getQuestion() {
        assertEquals("Question?", freeQuestionImpl.getQuestion());
    }

    @org.junit.jupiter.api.Test
    void processAnswer() {
        freeQuestionImpl.processAnswer("Answer");
        assertEquals(true,freeQuestionImpl.isRightAnswer());
    }

    @org.junit.jupiter.api.Test
    void isRightAnswer() {
        freeQuestionImpl.processAnswer("Answer");
        assertEquals(true,freeQuestionImpl.isRightAnswer());
    }

}