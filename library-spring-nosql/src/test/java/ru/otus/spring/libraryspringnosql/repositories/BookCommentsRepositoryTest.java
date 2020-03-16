package ru.otus.spring.libraryspringnosql.repositories;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.otus.spring.libraryspringnosql.models.*;
import ru.otus.spring.libraryspringnosql.services.AppSession;
import ru.otus.spring.libraryspringnosql.services.CommentFactory;
import ru.otus.spring.libraryspringnosql.services.NextSequenceService;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

// https://stackoverflow.com/questions/36448921/how-can-we-create-auto-generated-field-for-mongodb-using-spring-boot

@DataMongoTest
@ExtendWith(SpringExtension.class)
// Вот тут для меня загадка, почему одни классы импортировать не надо, а без этих не компилируется
@Import({CommentFactory.class, NextSequenceService.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Тестирование репозитория BookComments")
class BookCommentsRepositoryTest {

    private static final long TOXIC_BOOK_ID = 1;
    private static final int TOXIC_BOOK_COMMENTS_CNT = 2;
    private static final long TOXIC_BOOK_FIRST_COMMENT_ID = 1;
    public static final long TOXIC_BOOK_SECOND_COMMENT_ID = 2;
    public static final String NEW_COMMENT = "NEW COMMENT";
    public static final String USER_01 = "User01";
    public static final String PASSWORD = "12345678";
    public static final String CMT_TEXT_1 = "Стоит почитать.";
    public static final String CMT_TEXT_2 = "Не читал, но осуждаю.";
    public static final String CMT_COLLECTION_NAME = "comments";

    @Value("${spring.data.mongodb.database:library}")
    private String databaseName;

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    CommentFactory commentFactory;

    @Autowired
    BookCommentsRepository bookCommentsRepository;

    @MockBean
    private AppSession session;

    public /*static*/ void setupAddingBooks(MongoTemplate mongoTemplate) {

        User user = new User(101, "User01", "12345678", "User 01");
        mongoTemplate.insert(user, "users");

        user = new User(102, "User02", "12345678", "User 02");
        mongoTemplate.insert(user, "users");

        Author author = new Author();
        author.setCountry("EN");
        author.setDateOfBirth(LocalDate.of(1859, 5, 22));
        author.setSex('M');
        author.setName("Дойл, Артур Конан");

        PublishingHouse publishingHouse1 = new PublishingHouse();
        publishingHouse1.setName("ИК «Столица» (Изд. группа GELEOS Publishing House)");
        publishingHouse1.setSettlementYear(2010);

        LookupValue lookupValueRU = new LookupValue();
        lookupValueRU.setLookupType("GENRES");
        lookupValueRU.setLanguage("RU");
        lookupValueRU.setLookupCode("HARD_SCIENCE_FICTION");
        lookupValueRU.setMeaning("Твердая научная фантастика");
        lookupValueRU.setDescription("Твердая научная фантастика");
        lookupValueRU.setEnabledFlag('Y');

        LookupValue lookupValueEN = new LookupValue();
        lookupValueEN.setLookupType("GENRES");
        lookupValueEN.setLanguage("RU");
        lookupValueEN.setLookupCode("HARD_SCIENCE_FICTION");
        lookupValueEN.setMeaning("Hard SF");
        lookupValueEN.setDescription("Hard science fiction");
        lookupValueEN.setEnabledFlag('Y');

        List<LookupValue> lookupValueList = List.of(lookupValueRU, lookupValueEN);

        Book book = new Book(1L, "В ядовитом поясе", 2010, 320, lookupValueList, author, publishingHouse1);

        mongoTemplate.insert(book, "books");

        // Second book

        author = new Author();
        author.setCountry("RU");
        author.setDateOfBirth(LocalDate.of(1920, 1, 2));
        author.setSex('M');
        author.setName("Азимов, Айзек");

        PublishingHouse publishingHouse2 = new PublishingHouse();
        publishingHouse2.setName("PH «Stolitca» (GELEOS Publishing House)");
        publishingHouse2.setSettlementYear(1990);

        lookupValueRU = new LookupValue();
        lookupValueRU.setLookupType("GENRES");
        lookupValueRU.setLanguage("RU");
        lookupValueRU.setLookupCode("CHRONOFANTASTIC");
        lookupValueRU.setMeaning("Хронофантастика");
        lookupValueRU.setDescription("Хронофантастика");
        lookupValueRU.setEnabledFlag('Y');

        lookupValueEN = new LookupValue();
        lookupValueEN.setLookupType("GENRES");
        lookupValueEN.setLanguage("RU");
        lookupValueEN.setLookupCode("CHRONOFANTASTIC");
        lookupValueEN.setMeaning("Chronofantastic");
        lookupValueEN.setDescription("Chronofantastic");
        lookupValueEN.setEnabledFlag('Y');

        lookupValueList = List.of(lookupValueRU, lookupValueEN);

        book = new Book(2L, "Конец Вечности", 1955, 247, lookupValueList, author, publishingHouse2);

        mongoTemplate.insert(book, "books");

        // Third book

        author = new Author();
        author.setCountry("US");
        author.setDateOfBirth(LocalDate.of(1904, 10, 21));
        author.setSex('M');
        author.setName("Гамильтон, Эдмонд");

        lookupValueRU = new LookupValue();
        lookupValueRU.setLookupType("GENRES");
        lookupValueRU.setLanguage("RU");
        lookupValueRU.setLookupCode("SPACE_OPERA");
        lookupValueRU.setMeaning("Космическая опера");
        lookupValueRU.setDescription("Космическая опера");
        lookupValueRU.setEnabledFlag('Y');

        lookupValueEN = new LookupValue();
        lookupValueEN.setLookupType("GENRES");
        lookupValueEN.setLanguage("RU");
        lookupValueEN.setLookupCode("SPACE_OPERA");
        lookupValueEN.setMeaning("Space Opera");
        lookupValueEN.setDescription("Space Opera");
        lookupValueEN.setEnabledFlag('Y');

        lookupValueList = List.of(lookupValueRU, lookupValueEN);

        book = new Book(3L, "Звёздные короли", 1947, 150, lookupValueList, author, publishingHouse1);

        mongoTemplate.insert(book, "books");
    }

    @BeforeAll
    public /*static*/ void setupComments(@Autowired MongoTemplate mongoTemplate ) {

        TestUtils.cleanUp(mongoTemplate, databaseName);
        setupAddingBooks(mongoTemplate);

        Book book1 = mongoTemplate.findById(1, Book.class);
        Book book2 = mongoTemplate.findById(2, Book.class);
        Book book3 = mongoTemplate.findById(3, Book.class);

        User user101 = mongoTemplate.findById(101, User.class);
        User user102 = mongoTemplate.findById(102, User.class);

        Comment comment = commentFactory.getComment();
        comment.setBook(book1);
        comment.setComment(CMT_TEXT_1);
        comment.setCreatedBy(user101);
        comment.setCreationDate(LocalDate.now());
        mongoTemplate.save(comment, CMT_COLLECTION_NAME);

        comment = commentFactory.getComment();
        comment.setBook(book1);
        comment.setComment(CMT_TEXT_2);
        comment.setCreatedBy(user102);
        comment.setCreationDate(LocalDate.now());
        mongoTemplate.save(comment, CMT_COLLECTION_NAME);

        comment = commentFactory.getComment();
        comment.setBook(book2);
        comment.setComment("Замечательная книга.");
        comment.setCreatedBy(user101);
        comment.setCreationDate(LocalDate.now());
        mongoTemplate.save(comment, CMT_COLLECTION_NAME);

        comment = commentFactory.getComment();
        comment.setBook(book2);
        comment.setComment("Можно почитать.");
        comment.setCreatedBy(user102);
        comment.setCreationDate(LocalDate.now());
        mongoTemplate.save(comment, CMT_COLLECTION_NAME);

        comment = commentFactory.getComment();
        comment.setBook(book3);
        comment.setComment("Нудятина какая-то.");
        comment.setCreatedBy(user102);
        comment.setCreationDate(LocalDate.now());
        mongoTemplate.save(comment, CMT_COLLECTION_NAME);
    }

    @DisplayName("Проверка получения комментариев для книги")
    @Test
    void getAllBookComments() {
        // TODO: Не проходит, так как не ищет комментарии по книге
        List<Comment> comments = bookCommentsRepository.findCommentsByBookId(TOXIC_BOOK_ID);

        Comment comment1 = mongoTemplate.findOne(
                Query.query(Criteria.where("comment").is(CMT_TEXT_1)), Comment.class, CMT_COLLECTION_NAME
        );
        Comment comment2 = mongoTemplate.findOne(
                Query.query(Criteria.where("comment").is(CMT_TEXT_2)), Comment.class, CMT_COLLECTION_NAME
        );
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
        // Comment referenceComment = mongoTemplate.
        //         findById(comment.getId(), Comment.class, CMT_COLLECTION_NAME);
        // Но ищет по тексту. Загадка.
        Comment referenceComment = mongoTemplate.findOne(
                Query.query(Criteria.where("comment").is(NEW_COMMENT)), Comment.class, CMT_COLLECTION_NAME
        );

        assertThat(referenceComment).isNotNull().hasFieldOrPropertyWithValue("book.id",TOXIC_BOOK_ID);
        assertThat(referenceComment).isNotNull().hasFieldOrPropertyWithValue("comment",NEW_COMMENT);
        mongoTemplate.remove(Query.query(Criteria.where("comment").is(NEW_COMMENT)), CMT_COLLECTION_NAME);
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

        Comment originalComment = mongoTemplate.findOne(
                Query.query(Criteria.where("comment").is(CMT_TEXT_1)), Comment.class, CMT_COLLECTION_NAME
        );
        Comment comment = bookCommentsRepository.updateBookComment(originalComment.getId(), NEW_COMMENT);
        assertThat(comment).isNotNull().hasFieldOrPropertyWithValue("comment",NEW_COMMENT);
        // Проверка наличия информации о пользователе внесшем изменения и времени изменения
        assertThat(comment.getLastUpdatedBy()).isNotNull();
        assertThat(comment.getLastUpdateDate()).isNotNull();
        // Восстановление комментария
        comment = bookCommentsRepository.updateBookComment(originalComment.getId(), originalComment.getComment());
    }
}