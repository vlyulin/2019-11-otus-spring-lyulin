package ru.otus.spring.library.rest.repositories;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import ru.otus.spring.library.rest.models.Comment;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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

}