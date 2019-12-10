package ru.otus.spring.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import ru.otus.spring.domain.QuizSet;
import ru.otus.spring.domain.QuizSetImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Configuration
@PropertySource("classpath:test.properties")
class QuizConfigTest {

    // Не могу получить свойство
    @Value("${quiz_ru_RU}")
    private String ru_file;

    @Test
    void loadCSV() {
        String[][] reference_data = {
                {"3","FREE_ANSWER,Вам нравится Spring? (Y/N)","Y"},
                {"1","LIST_WITH_ONE_CHOICE","Сколько будет 1 + 1?","2","1","2","3","4","5"},
                {"2","LIST_WITH_ONE_CHOICE","Сколько будет 2 + 2?","4","1","2","3","4","5"}
        };
        ArrayList<String[]> reference_data_list = new ArrayList<String[]>(Arrays.asList(reference_data));

        // Проверяем, что установлено свойство quiz_ru_RU
        Assertions.assertNotNull(ru_file); // не могу получить свойство
        // Проверить наличие файла
        // ...
        // Проверить данные
        // List<String[]> strings = QuizConfig.loadCSV(ru_file);
        List<String[]> strings = QuizConfig.loadCSV("quiz_ru_RU.csv");

        assertAll("Russian data CSV loading",
                () -> assertArrayEquals(reference_data[0], reference_data_list.get(0)),
                () -> assertArrayEquals(reference_data[0], reference_data_list.get(0)),
                () -> assertArrayEquals(reference_data[0], reference_data_list.get(0))
        );
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInQuizConfigTest() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}