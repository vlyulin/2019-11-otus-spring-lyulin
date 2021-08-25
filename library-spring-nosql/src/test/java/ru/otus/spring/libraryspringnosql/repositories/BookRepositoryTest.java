package ru.otus.spring.libraryspringnosql.repositories;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import de.flapdoodle.embed.process.collections.Collections;
import org.bson.Document;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoAdmin;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.otus.spring.libraryspringnosql.models.*;
import ru.otus.spring.libraryspringnosql.services.AppSession;
import ru.otus.spring.libraryspringnosql.services.CommentFactory;
import ru.otus.spring.libraryspringnosql.services.NextSequenceService;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

// Для себя сохранил источник знаний:
// https://www.baeldung.com/spring-boot-embedded-mongodb
@DataMongoTest
@ExtendWith(SpringExtension.class)
@Import({CommentFactory.class, NextSequenceService.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Тестирование репозитория Books")
class BookRepositoryTest {

    private static final String BOOKS_COLLECTION_NAME = "books";
    public static final String USERS_COLLECTION_NAME = "users";

    private static final int BOOKS_COUNT = 3;
    private static final int SINGLE_BOOK_COUNT = 1;
    private static final long TOXIC_BOOK_ID = 1;
    private static final String TOXIC_BOOK_NAME = "В ядовитом поясе";
    private static final String TOXIC_BOOK_PATTERN = "ядов";

    @Value("${spring.data.mongodb.database:library}")
    private String databaseName;

    @Autowired
    private MongoTemplate mongoTemplate;

    // @Autowired
    // private UserRepository userRepository;

    @Autowired
    private BooksRepository booksRepository;

//    @Autowired
//    private CommentFactory commentFactory;

//    @Autowired
//    private BookCommentsRepository bookCommentsRepository;

    @MockBean
    private AppSession session;

    @BeforeAll
    public /*static*/ void setup(@Autowired MongoTemplate mongoTemplate) {

        TestUtils.cleanUp(mongoTemplate, databaseName);

        User user = new User(101, "User01", "12345678", "User 01");
        mongoTemplate.save(user, USERS_COLLECTION_NAME);

        user = new User(102, "User02", "12345678", "User 02");
        mongoTemplate.save(user, USERS_COLLECTION_NAME);

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

            mongoTemplate.save(book, BOOKS_COLLECTION_NAME);

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

            mongoTemplate.save(book, BOOKS_COLLECTION_NAME);

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

            mongoTemplate.save(book, BOOKS_COLLECTION_NAME);
    }

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
                "-1","-1","-1",
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