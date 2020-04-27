package ru.otus.spring.library.rest.repositories;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.library.rest.models.Book;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Тестирование репозитория Books")
@DataJpaTest
@Transactional
class BooksRepositoryJpaTest {

    private static final int BOOKS_COUNT = 3;
    private static final int SINGLE_BOOK_COUNT = 1;
    private static final long TOXIC_BOOK_ID = 1;
    private static final String TOXIC_BOOK_NAME = "В ядовитом поясе";
    private static final String TOXIC_BOOK_PATTERN = "%ядов%";

    @Autowired
    private TestEntityManager em;

    @Autowired
    BooksRepository booksRepository;

    @DisplayName("Получение списка всех книг")
    @Test
    void findAll() {
        List<Book> books = booksRepository.findAll();
        assertThat(books).hasSize(BOOKS_COUNT);
    }

    @DisplayName("Получение списка книг по заданным значениям аттрибутов")
    @Test
    void getBooks() {
        List<Book> books = booksRepository.getBooks(
                TOXIC_BOOK_PATTERN,
                null,null,null,
                -1,-1,-1, -1);
        assertThat(books).hasSize(SINGLE_BOOK_COUNT);
        Book book = books.get(0);
        assertThat(book).isNotNull().hasFieldOrPropertyWithValue("name", TOXIC_BOOK_NAME);
    }

    @DisplayName("Получение книги по идентификатору")
    @Test
    void findBookById()  {
       assertThat(booksRepository.findById(TOXIC_BOOK_ID)).isNotEmpty().get()
               .isNotNull().hasFieldOrPropertyWithValue("name", TOXIC_BOOK_NAME);
    }

}