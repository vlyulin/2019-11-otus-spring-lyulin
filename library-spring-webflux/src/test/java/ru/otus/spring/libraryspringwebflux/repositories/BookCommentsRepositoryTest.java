package ru.otus.spring.libraryspringwebflux.repositories;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import ru.otus.spring.libraryspringwebflux.models.*;
import ru.otus.spring.libraryspringwebflux.services.AppSession;
import ru.otus.spring.libraryspringwebflux.services.CommentFactory;
import ru.otus.spring.libraryspringwebflux.services.NextSequenceService;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

// https://stackoverflow.com/questions/36448921/how-can-we-create-auto-generated-field-for-mongodb-using-spring-boot
// https://www.baeldung.com/reactive-streams-step-verifier-test-publisher

// @ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@DataMongoTest
// Вот тут для меня загадка, почему одни классы импортировать не надо, а без этих не компилируется
@Import({CommentFactory.class, NextSequenceService.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Тестирование репозитория BookComments")
class BookCommentsRepositoryTest {

    private static final long TOXIC_BOOK_ID = 1;
    private static final int TOXIC_BOOK_COMMENTS_CNT = 2;
    // private static final long TOXIC_BOOK_FIRST_COMMENT_ID = 1;
    // public static final long TOXIC_BOOK_SECOND_COMMENT_ID = 2;
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
    ReactiveMongoTemplate reactiveMongoTemplate;

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

        // TODO: Правильно ли при инициализации базы не использовать рективщину?
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
    // Интересный подход
    // https://github.com/hantsy/spring-reactive-sample/blob/master/boot-data-mongo/src/test/java/com/example/demo/PostRepositoryTest.java
    void getAllBookComments() {
        Flux<Comment> comments = bookCommentsRepository.findCommentsByBookId(TOXIC_BOOK_ID);

        // TODO: Надо ли тут reactiveMongoTemplate или можно было бы и MongoTemplate обойтись?
        Mono<Comment> comment1 = reactiveMongoTemplate.findOne(
                Query.query(Criteria.where("comment").is(CMT_TEXT_1)), Comment.class, CMT_COLLECTION_NAME
        );
        Mono<Comment> comment2 = reactiveMongoTemplate.findOne(
                Query.query(Criteria.where("comment").is(CMT_TEXT_2)), Comment.class, CMT_COLLECTION_NAME
        );
        // TODO: Разобраться, что такое scanable
        // Scannable.from(comments).inners().count();
        StepVerifier
                .create(comments)
                // TODO: Тут важен порядок. А как делать если порядок не известен?
                .expectNext(comment1.block(), comment2.block())
                // .expectNextCount(TOXIC_BOOK_COMMENTS_CNT)
                .expectComplete()
                .verify();

        // assertThat(comments).hasSize(TOXIC_BOOK_COMMENTS_CNT).containsExactlyInAnyOrder(comment1, comment2);
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

        // TODO: Вопрос, правильно ли, что обязанность делать subscribe, это дело репозитория?
        //  Иначе у меня в базе не сохранялось
        Mono<Comment> comment = bookCommentsRepository.addBookComment(TOXIC_BOOK_ID, NEW_COMMENT);
        // comment.subscribe();

        StepVerifier
                .create(comment)
//                .expectNextMatches(cmt -> cmt.getComment().equals(NEW_COMMENT))
                .assertNext(cmt -> {
                    assertEquals(NEW_COMMENT, cmt.getComment());
                })
                .expectComplete()
                .verify();

        // assertThat(comment).isNotNull();

        // TODO: Не ищет комментарии по идентификатору
        // Comment referenceComment = mongoTemplate.
        //         findById(comment.getId(), Comment.class, CMT_COLLECTION_NAME);
        // Но ищет по тексту. Загадка.
        Mono<Comment> foundedComment = reactiveMongoTemplate.findOne(
                Query.query(Criteria.where("comment").is(NEW_COMMENT)), Comment.class, CMT_COLLECTION_NAME
        );

        StepVerifier
                .create(foundedComment)
                // TODO: Почему expectNextMatches выдает ошибку
                // java.lang.AssertionError: expectation "expectNextMatches" failed (expected: onNext(); actual: onComplete())
                // А assertNext проходит нормально?
//                .expectNextMatches(fcmt -> fcmt.getBook().getId() == TOXIC_BOOK_ID)
//                .expectNextMatches(fcmt -> fcmt.getComment().equals(NEW_COMMENT))
//                .expectNextMatches(cmt -> cmt.getComment().equals(NEW_COMMENT))
//                .expectNextMatches(cmt -> cmt.getBook().getId() == TOXIC_BOOK_ID)
                .assertNext(cmt -> {
                    assertEquals(cmt.getBook().getId(), TOXIC_BOOK_ID);
                    assertEquals(cmt.getComment(), NEW_COMMENT);
                })
                .expectComplete()
                .verify();

        // Восстанавление состояние базы
        reactiveMongoTemplate.remove(
                Query.query(Criteria.where("comment").is(NEW_COMMENT)), CMT_COLLECTION_NAME
        ).subscribe();
    }

    @DisplayName("Проверка изменения комментария к книге")
    @Test
    void updateBookComment() {

        Comment originalComment;
        User user = new User();
        user.setId(101L);
        user.setLogin(USER_01);
        user.setName(USER_01);
        user.setPassword(PASSWORD);

        Mockito.when(session.getUser()).thenReturn(user);

        // Сохранение состояния комментария для его восстановления после теста
        originalComment = reactiveMongoTemplate.findOne(
                Query.query(Criteria.where("comment").is(CMT_TEXT_1)), Comment.class, CMT_COLLECTION_NAME
        ).block();

        Mono<Comment> comment = bookCommentsRepository.updateBookComment(originalComment.getId(), NEW_COMMENT);

        StepVerifier
                .create(comment)
//                .expectNextMatches(cmt -> cmt.getLastUpdateDate() != null)
//                .expectNextMatches(cmt -> cmt.getLastUpdateDate() != null)
                .assertNext(cmt -> {
                    // Проверка наличия информации о пользователе внесшем изменения и времени изменения
                    assertNotNull(cmt.getLastUpdatedBy());
                    assertNotNull(cmt.getLastUpdateDate());
                })
                .expectComplete()
                .verify();

        Mono<Comment> referenceComment = reactiveMongoTemplate.findOne(
                Query.query(Criteria.where("comment").is(NEW_COMMENT)), Comment.class, CMT_COLLECTION_NAME
        );

        StepVerifier
                .create(referenceComment)
                // TODO: expectNextMatches выдает ошибку
                // .expectNextMatches(rcmt -> rcmt.getBook().getId() == TOXIC_BOOK_ID)
                // .expectNextMatches(rcmt -> rcmt.getComment().equals(NEW_COMMENT))
                .assertNext(cmt -> {
                    // Проверка наличия информации о пользователе внесшем изменения и времени изменения
                    assertEquals(cmt.getBook().getId(), TOXIC_BOOK_ID);
                    assertEquals(cmt.getComment(), NEW_COMMENT);
                    assertNotNull(cmt.getLastUpdatedBy());
                    assertNotNull(cmt.getLastUpdateDate());
                })
                .expectComplete()
                .verify();

        // Восстановление комментария
        Mono<Comment> updatedComment = bookCommentsRepository.updateBookComment(originalComment.getId(), originalComment.getComment());
        updatedComment.subscribe();
    }
}