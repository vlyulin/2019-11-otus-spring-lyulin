package ru.otus.spring.libraryspringnosql.repositories;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.otus.spring.libraryspringnosql.models.*;
import ru.otus.spring.libraryspringnosql.services.AppSession;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@DataMongoTest
@ExtendWith(SpringExtension.class)
@DisplayName("Тестирование репозитория BookComments")
class BookCommentsRepositoryTest {

    private static final long TOXIC_BOOK_ID = 1;
    private static final int TOXIC_BOOK_COMMENTS_CNT = 2;
    private static final long TOXIC_BOOK_FIRST_COMMENT_ID = 1;
    public static final long TOXIC_BOOK_SECOND_COMMENT_ID = 2;
    public static final String NEW_COMMENT = "NEW COMMENT";
    public static final String USER_01 = "User01";
    public static final String PASSWORD = "12345678";

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    BookCommentsRepository bookCommentsRepository;

    @MockBean
    private AppSession session;

    @BeforeAll
    public static void setupComments(@Autowired MongoTemplate mongoTemplate) {

        Book book1 = mongoTemplate.findById(1, Book.class);
        Book book2 = mongoTemplate.findById(2, Book.class);
        Book book3 = mongoTemplate.findById(3, Book.class);

        User user101 = mongoTemplate.findById(101, User.class);
        User user102 = mongoTemplate.findById(102, User.class);

        Comment comment = new Comment();
        comment.setId(1);
        comment.setBook(book1);
        comment.setComment("Стоит почитать.");
        comment.setCreatedBy(user101);
        comment.setCreationDate(LocalDate.now());
        mongoTemplate.insert(comment, "comments");

        comment = new Comment();
        comment.setId(2);
        comment.setBook(book1);
        comment.setComment("Не читал, но осуждаю.");
        comment.setCreatedBy(user102);
        comment.setCreationDate(LocalDate.now());
        mongoTemplate.insert(comment, "comments");

        comment = new Comment();
        comment.setId(3);
        comment.setBook(book2);
        comment.setComment("Замечательная книга.");
        comment.setCreatedBy(user101);
        comment.setCreationDate(LocalDate.now());
        mongoTemplate.insert(comment, "comments");

        comment = new Comment();
        comment.setId(4);
        comment.setBook(book2);
        comment.setComment("Можно почитать.");
        comment.setCreatedBy(user102);
        comment.setCreationDate(LocalDate.now());
        mongoTemplate.insert(comment, "comments");

        comment = new Comment();
        comment.setId(5);
        comment.setBook(book3);
        comment.setComment("Нудятина какая-то.");
        comment.setCreatedBy(user102);
        comment.setCreationDate(LocalDate.now());
        mongoTemplate.insert(comment, "comments");
    }

    @DisplayName("Проверка получения комментариев для книги")
    @Test
    void getAllBookComments() {
        // TODO: Не проходит, так как не ищет комментарии по книге
        List<Comment> comments = bookCommentsRepository.findByBookId(TOXIC_BOOK_ID);
        Comment comment1 = mongoTemplate.findById(TOXIC_BOOK_FIRST_COMMENT_ID, Comment.class, "comments");
        Comment comment2 = mongoTemplate.findById(TOXIC_BOOK_SECOND_COMMENT_ID, Comment.class, "comments");
        assertThat(comments).hasSize(TOXIC_BOOK_COMMENTS_CNT).containsExactlyInAnyOrder(comment1, comment2);
    }

    @DisplayName("Проверка добавления комментария к книге")
    @Test
    void addBookComment() {

        User user = new User();
        user.setId(101L);
        user.setLogin(USER_01);
        user.setName(USER_01);
        user.setPassword(PASSWORD);

        when(session.getUser()).thenReturn(user);

        Comment comment = bookCommentsRepository.addBookComment(TOXIC_BOOK_ID, NEW_COMMENT);
        assertThat(comment).isNotNull();
        // TODO: Не ищет комментарии по идентификатору
        Comment referenceComment = mongoTemplate.findById(comment.getId(), Comment.class, "comments");

        assertThat(referenceComment).isNotNull().hasFieldOrPropertyWithValue("bookId",TOXIC_BOOK_ID);
        assertThat(referenceComment).isNotNull().hasFieldOrPropertyWithValue("comment",NEW_COMMENT);
    }

    @DisplayName("Проверка изменения комментария к книге")
    @Test
    void updateBookComment() {

        User user = new User();
        user.setId(101L);
        user.setLogin(USER_01);
        user.setName(USER_01);
        user.setPassword(PASSWORD);

        Mockito.when(session.getUser()).thenReturn(user);

        Comment comment = bookCommentsRepository.updateBookComment(TOXIC_BOOK_FIRST_COMMENT_ID, NEW_COMMENT);

        assertThat(comment).isNotNull().hasFieldOrPropertyWithValue("comment",NEW_COMMENT);
        // Проверка наличия информации о пользователе внесшем изменения и времени изменения
        assertThat(comment.getLastUpdatedBy()).isNotNull();
        assertThat(comment.getLastUpdateDate()).isNotNull();
    }
}