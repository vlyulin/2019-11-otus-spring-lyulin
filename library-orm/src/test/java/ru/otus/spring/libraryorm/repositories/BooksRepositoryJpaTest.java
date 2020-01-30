package ru.otus.spring.libraryorm.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.otus.spring.libraryorm.services.AppSession;
import ru.otus.spring.libraryorm.config.Settings;
import ru.otus.spring.libraryorm.models.Book;
import ru.otus.spring.libraryorm.repositories.exceptions.BookNotFoundException;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Тестирование репозитория Books")
@DataJpaTest
@Import({BooksRepositoryJpa.class, UserRepositoryJpa.class, AppSession.class, Settings.class})
class BooksRepositoryJpaTest {

    private static final int BOOKS_COUNT = 3;
    private static final int SINGLE_BOOK_COUNT = 1;
    private static final long TOXIC_BOOK_ID = 1;
    private static final long MISSED_BOOK_ID = -100;
    private static final String TOXIC_BOOK_NAME = "В ядовитом поясе";

    @Autowired
    private TestEntityManager em;

    @Autowired
    BooksRepositoryJpa booksRepositoryJpa;

    @DisplayName("Получение списка всех книг")
    @Test
    void findAll() {
        List<Book> books = booksRepositoryJpa.getAllBooks();
        assertThat(books).hasSize(BOOKS_COUNT);
    }

    @DisplayName("Получение списка книг по заданным значениям аттрибутов")
    @Test
    void getBooks() {
        List<Book> books = booksRepositoryJpa.getBooks(
                "%ядовитом%",
                "","","","",0,0);
        assertThat(books).hasSize(SINGLE_BOOK_COUNT);
        Book book = books.get(0);
        assertThat(book).isNotNull().hasFieldOrPropertyWithValue("name", TOXIC_BOOK_NAME);
    }

    @DisplayName("Получение книги по идентификатору")
    @Test
    void findBookById() throws BookNotFoundException {
       assertThat(booksRepositoryJpa.findBookById(TOXIC_BOOK_ID)).isNotEmpty().get()
               .isNotNull().hasFieldOrPropertyWithValue("name", TOXIC_BOOK_NAME);
    }

    @DisplayName("Проверка ошибки поиска книги по неверному id")
    @Test
    void testBookNotFoundException() {
        Assertions.assertThrows(BookNotFoundException.class, () -> booksRepositoryJpa.findBookById(MISSED_BOOK_ID) );
    }
}