package ru.otus.spring.libraryspringdata.repositories;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.otus.spring.libraryspringdata.models.Comment;
import ru.otus.spring.libraryspringdata.models.User;
import ru.otus.spring.libraryspringdata.repositories.exceptions.BookNotFoundException;
import ru.otus.spring.libraryspringdata.services.AppSession;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@DisplayName("Тестирование репозитория BookComments")
@DataJpaTest
class BookCommentsRepositoryJpaTest {

    private static final long TOXIC_BOOK_ID = 1;
    private static final int TOXIC_BOOK_COMMENTS_CNT = 2;
    private static final long TOXIC_BOOK_FIRST_COMMENT_ID = 1;
    public static final long TOXIC_BOOK_SECOND_COMMENT_ID = 2;
    public static final String NEW_COMMENT = "NEW COMMENT";
    public static final int EXPECTED_NUMBER_UPDATED_COMMENTS = 1;
    public static final String USER_01 = "User01";
    public static final String PASSWORD = "12345678";

    @Autowired
    private TestEntityManager em;

    @MockBean
    private AppSession session;

    @Autowired
    private BookCommentsRepository bookCommentsRepository;

    @DisplayName("Проверка получения комментариев для книги")
    @Test
    void getAllBookComments() {
        List<Comment> comments = bookCommentsRepository.findByBookId(TOXIC_BOOK_ID);
        Comment comment1 = em.find(Comment.class,TOXIC_BOOK_FIRST_COMMENT_ID);
        Comment comment2 = em.find(Comment.class, TOXIC_BOOK_SECOND_COMMENT_ID);
        assertThat(comments).hasSize(TOXIC_BOOK_COMMENTS_CNT).containsExactlyInAnyOrder(comment1, comment2);
    }

    @DisplayName("Проверка добавления комментария к книге")
    @Test
    void addBookComment() throws BookNotFoundException {

        User user = new User();
        user.setId(101L);
        user.setLogin(USER_01);
        user.setName(USER_01);
        user.setPassword(PASSWORD);

        when(session.getUser()).thenReturn(user);

        Comment comment = bookCommentsRepository.addBookComment(TOXIC_BOOK_ID, NEW_COMMENT);
        assertThat(comment).isNotNull();
        Comment referenceComment = em.find(Comment.class, comment.getCommentId());

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

        bookCommentsRepository.updateBookComment(TOXIC_BOOK_FIRST_COMMENT_ID, NEW_COMMENT);
        Comment comment = em.find(Comment.class,TOXIC_BOOK_FIRST_COMMENT_ID);

        assertThat(comment).isNotNull().hasFieldOrPropertyWithValue("comment",NEW_COMMENT);
        // Проверка наличия информации о пользователе и времени внесшем изменения
        assertThat(comment.getLastUpdatedBy()).isNotNull();
        assertThat(comment.getLastUpdateDate()).isNotNull();
    }
}