package ru.otus.spring.library.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import ru.otus.spring.library.domain.Author;

import java.sql.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Тестирование операций с объектом Author")
@SpringBootTest(properties = {
        InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
        ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
})
// @JdbcTest
@Import(AuthorDaoJdbc.class)
class AuthorDaoJdbcTest {

    @Autowired
    private AuthorDaoJdbc authorDaoJdbc;

    @Test
    void count() {
        int count = authorDaoJdbc.count();
        assertThat(count).isNotZero();
    }

    @Test
    @DisplayName("Тестирование вставки Author в базу")
    void insert() {
        Author reference_author = new Author(-1,"Автор для тестирования", "EN", 'M', Date.valueOf("1980-01-10"));
        authorDaoJdbc.insert(reference_author);
        Author author = authorDaoJdbc.getById(-1);
        authorDaoJdbc.deleteById(-1);
        assertThat(reference_author.equals(author));
    }

    @Test
    @DisplayName("Тестирование запроса Author по идентификатору")
    void getById() {
        Author reference_author = new Author(1,"Дойл, Артур Конан", "EN", 'M', Date.valueOf("1859-05-22"));
        Author author = authorDaoJdbc.getById(1);
        assertThat(reference_author.equals(author));
    }

    @Test
    void getAll() {
        List<Author> authors = authorDaoJdbc.getAll();
        assertThat(authors.size()).isGreaterThan(0);
    }

    @Test
    void deleteById() {
        Author reference_author = new Author(-1,"Автор для тестирования", "EN", 'M', Date.valueOf("1980-01-10"));
        authorDaoJdbc.insert(reference_author);
        authorDaoJdbc.deleteById(-1);
        Throwable exception = assertThrows(EmptyResultDataAccessException.class,() -> authorDaoJdbc.getById(-1));
    }
}