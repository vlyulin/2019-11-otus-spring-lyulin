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
import ru.otus.spring.libraryorm.models.Comment;
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
    private static final int TOXIC_BOOK_COMMENTS_CNT = 2;
    private static final long TOXIC_BOOK_FIRST_COMMENT_ID = 1;
    public static final long TOXIC_BOOK_SECOND_COMMENT_ID = 2;
    public static final String NEW_COMMENT = "NEW COMMENT";
    public static final int EXPECTED_NUMBER_UPDATED_COMMENTS = 1;

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
       assertThat(booksRepositoryJpa.findBookById(TOXIC_BOOK_ID).get())
               .isNotNull().hasFieldOrPropertyWithValue("name", TOXIC_BOOK_NAME);
    }

    @DisplayName("Проверка ошибки поиска книги по неверному id")
    @Test
    void testBookNotFoundException() {
        Assertions.assertThrows(BookNotFoundException.class, () -> booksRepositoryJpa.findBookById(MISSED_BOOK_ID) );
    }

    @DisplayName("Проверка получения комментариев для книги")
    @Test
    void getAllBookComments() throws BookNotFoundException {
        List<Comment> comments = booksRepositoryJpa.getAllBookComments(TOXIC_BOOK_ID);
        Comment comment1 = em.find(Comment.class,TOXIC_BOOK_FIRST_COMMENT_ID);
        Comment comment2 = em.find(Comment.class, TOXIC_BOOK_SECOND_COMMENT_ID);
        assertThat(comments).hasSize(TOXIC_BOOK_COMMENTS_CNT).containsExactlyInAnyOrder(comment1, comment2);
    }

    @DisplayName("Проверка добавления комментария к книге")
    @Test
    void addBookComment() throws BookNotFoundException {

        Comment comment = booksRepositoryJpa.addBookComment(TOXIC_BOOK_ID, NEW_COMMENT);
        Comment referenceComment = em.find(Comment.class, comment.getCommentId());

        assertThat(referenceComment.getBookId()).isEqualTo(TOXIC_BOOK_ID);
        assertThat(referenceComment.getComment()).isEqualTo(NEW_COMMENT);
    }

    @DisplayName("Проверка изменения комментария к книге")
    @Test
    void updateBookComment() {
        int cnt = booksRepositoryJpa.updateBookComment(TOXIC_BOOK_FIRST_COMMENT_ID, NEW_COMMENT);
        assertThat(cnt).isEqualTo(EXPECTED_NUMBER_UPDATED_COMMENTS);
        Comment comment = em.find(Comment.class,TOXIC_BOOK_FIRST_COMMENT_ID);
        assertThat(comment.getComment()).isEqualTo(NEW_COMMENT);
        // Проверка наличия информации о пользователе и времени внесшем изменения
        assertThat(comment.getLastUpdatedBy()).isNotNull();
        assertThat(comment.getLastUpdateDate()).isNotNull();
    }

    @DisplayName("Проверка удаления комментария")
    @Test
    void deleteBookComment() {
        int cnt = booksRepositoryJpa.deleteBookComment(TOXIC_BOOK_FIRST_COMMENT_ID);
        assertThat(cnt).isEqualTo(EXPECTED_NUMBER_UPDATED_COMMENTS);
        Comment comment = em.find(Comment.class,TOXIC_BOOK_FIRST_COMMENT_ID);
        assertThat(comment).isNull();
    }
}