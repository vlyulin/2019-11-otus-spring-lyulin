package ru.otus.spring.libraryspringnosql.bee.changelog;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import org.springframework.data.mongodb.core.MongoTemplate;
import ru.otus.spring.libraryspringnosql.models.*;

import java.time.LocalDate;
import java.util.List;

@ChangeLog( order = "001" )
public class DatabaseChangelog {

    @ChangeSet(order = "001", id = "users", author = "vlyulin")
    public void insertUsers(final MongoTemplate mongoTemplate) {
        User user = new User(101, "User01", "12345678", "User 01");
        mongoTemplate.insert(user, "users");

        user = new User(102, "User02", "12345678", "User 02");
        mongoTemplate.insert(user, "users");
    }

    @ChangeSet(order = "002", id = "books", author = "vlyulin")
    public void insertBooks(final MongoTemplate mongoTemplate) {

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

    @ChangeSet(order = "003", id = "comments", author = "vlyulin")
    public void insertBookComments(final MongoTemplate mongoTemplate) {

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
}
