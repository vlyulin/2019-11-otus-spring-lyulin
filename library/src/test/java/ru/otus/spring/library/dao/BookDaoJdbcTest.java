package ru.otus.spring.library.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import ru.otus.spring.library.config.Settings;
import ru.otus.spring.library.domain.Author;
import ru.otus.spring.library.domain.Book;
import ru.otus.spring.library.domain.PublishingHouse;

import java.sql.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Тестирование операций с объектом Book")
@SpringBootTest(properties = {
        InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
        ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
})
// @JdbcTest
@Import({Settings.class, BookDaoJdbc.class, AuthorDaoJdbc.class, PublishingHouseDaoJdbc.class})
class BookDaoJdbcTest {

    private final static String BOOK_NAME = "HARD_SCIENCE_FICTION";
    private final static String GENRE = "HARD_SCIENCE_FICTION";

    @Autowired
    private AuthorDaoJdbc authorDaoJdbc;
    @Autowired
    private PublishingHouseDaoJdbc publishingHouseDaoJdbc;
    @Autowired
    private BookDaoJdbc bookDaoJdbc;

    @DisplayName("Проверка подсчета количества Book")
    @Test
    void count() {
        int count = bookDaoJdbc.count();
        assertThat(count).isNotZero();
    }

    @DisplayName("Проверка вставки Book")
    @Test
    void insert() {
        Author reference_author = new Author(-1,"Автор для тестирования", "EN", 'M', Date.valueOf("1980-01-10"));
        authorDaoJdbc.insert(reference_author);

        PublishingHouse reference_ph = new PublishingHouse(-1,"PH для тестирования", 1980);
        publishingHouseDaoJdbc.insert(reference_ph);

        Book reference_book = new Book(-1,BOOK_NAME, GENRE, -1, -1, 2010, 300);
        bookDaoJdbc.insert(reference_book);
        Book book = bookDaoJdbc.getById(-1);
        assertThat(reference_author.equals(book));

        bookDaoJdbc.deleteById(-1);
        publishingHouseDaoJdbc.deleteById(-1);
        authorDaoJdbc.deleteById(-1);
    }

    @Test
    void getById() {
        Book book = bookDaoJdbc.getById(1);
        assertNotNull(book);
    }

    @Test
    void getAll() {
        List<Book> books = bookDaoJdbc.getAll();
        assertNotNull(books);
        assertThat(books.size()).isGreaterThan(0);
    }

    @Test
    void deleteById() {
        Author reference_author = new Author(-1,"Автор для тестирования", "EN", 'M', Date.valueOf("1980-01-10"));
        authorDaoJdbc.insert(reference_author);

        PublishingHouse reference_ph = new PublishingHouse(-1,"PH для тестирования", 1980);
        publishingHouseDaoJdbc.insert(reference_ph);

        Book reference_book = new Book(-1,BOOK_NAME, GENRE, -1, -1, 2010, 300);
        bookDaoJdbc.insert(reference_book);
        bookDaoJdbc.deleteById(-1);
        Throwable exception = assertThrows(EmptyResultDataAccessException.class,() -> bookDaoJdbc.getById(-1));

        publishingHouseDaoJdbc.deleteById(-1);
        exception = assertThrows(EmptyResultDataAccessException.class,() -> publishingHouseDaoJdbc.getById(-1));

        authorDaoJdbc.deleteById(-1);
        exception = assertThrows(EmptyResultDataAccessException.class,() -> authorDaoJdbc.getById(-1));
    }
}