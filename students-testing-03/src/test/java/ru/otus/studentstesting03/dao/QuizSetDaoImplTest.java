package ru.otus.studentstesting03.dao;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class QuizSetDaoImplTest {

    @Test
    void getByName() {
        String[][] reference_data = {
                {"3","FREE_ANSWER,Вам нравится Spring? (Y/N)","Y"},
                {"1","LIST_WITH_ONE_CHOICE","Сколько будет 1 + 1?","2","1","2","3","4","5"},
                {"2","LIST_WITH_ONE_CHOICE","Сколько будет 2 + 2?","4","1","2","3","4","5"}
        };
        ArrayList<String[]> reference_data_list = new ArrayList<String[]>(Arrays.asList(reference_data));

        Mockito.when(QuizSetDaoImpl.getByName())

    }
}