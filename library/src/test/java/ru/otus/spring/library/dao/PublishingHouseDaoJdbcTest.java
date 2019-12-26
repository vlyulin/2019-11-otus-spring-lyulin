package ru.otus.spring.library.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import ru.otus.spring.library.domain.PublishingHouse;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Тестирование операций с объектом PublishingHouse")
@SpringBootTest(properties = {
        InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
        ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
})
// @JdbcTest
@Import(PublishingHouseDaoJdbc.class)
class PublishingHouseDaoJdbcTest {

    @Autowired
    private PublishingHouseDaoJdbc publishingHouseDaoJdbc;

    @DisplayName("Тестирование подсчета объектов PublishingHouse")
    @Test
    void count() {
        int count = publishingHouseDaoJdbc.count();
        assertThat(count).isNotZero();
    }

    @DisplayName("Тестирование вставки объекта PublishingHouse")
    @Test
    void insert() {
        PublishingHouse reference_ph = new PublishingHouse(-1,"PH для тестирования", 1980);
        publishingHouseDaoJdbc.insert(reference_ph);
        PublishingHouse ph = publishingHouseDaoJdbc.getById(-1);
        publishingHouseDaoJdbc.deleteById(-1);
        assertThat(reference_ph.equals(ph));
    }

    @Test
    void getById() {
        PublishingHouse reference_ph = new PublishingHouse(-1,"PH для тестирования", 1980);
        publishingHouseDaoJdbc.insert(reference_ph);
        PublishingHouse ph = publishingHouseDaoJdbc.getById(-1);
        assertThat(reference_ph.equals(ph));
        publishingHouseDaoJdbc.deleteById(-1);
    }

    @Test
    void getAll() {
        List<PublishingHouse> phs = publishingHouseDaoJdbc.getAll();
        assertThat(phs.size()).isGreaterThan(0);
    }

    @Test
    void deleteById() {
        PublishingHouse reference_ph = new PublishingHouse(-1,"PH для тестирования", 1980);
        publishingHouseDaoJdbc.insert(reference_ph);
        publishingHouseDaoJdbc.deleteById(-1);
        Throwable exception = assertThrows(EmptyResultDataAccessException.class,() -> publishingHouseDaoJdbc.getById(-1));
    }
}