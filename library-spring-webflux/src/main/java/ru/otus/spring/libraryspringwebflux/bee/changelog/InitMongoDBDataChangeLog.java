package ru.otus.spring.libraryspringwebflux.bee.changelog;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoDatabase;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import ru.otus.spring.libraryspringwebflux.models.*;
import ru.otus.spring.libraryspringwebflux.services.NextSequenceService;

import java.time.LocalDate;
import java.util.List;

@ChangeLog( order = "001" )
public class InitMongoDBDataChangeLog {

    @ChangeSet(order = "000", id = "dropDB", author = "vlyulin", runAlways = true)
    public void dropDB(MongoDatabase database){
        database.drop();
    }

    @ChangeSet(order = "002", id = "users", author = "vlyulin", runAlways = true)
    public void insertUsers( MongoTemplate mongoTemplate ) {
        User user01 = new User(101L, "User01", "12345678", "User 01");
        mongoTemplate.save(user01, User.USERS_COLLECTION_NAME);

        User user02 = new User(102L, "User02", "12345678", "User 02");
        mongoTemplate.save(user02, User.USERS_COLLECTION_NAME);
    }

    @ChangeSet(order = "002", id = "genres", author = "vlyulin", runAlways = true)
    public void insertGenres( MongoTemplate mongoTemplate ) {

        // First

        LookupValue lookupValueRU = new LookupValue();
        lookupValueRU.setId("HARD_SCIENCE_FICTION_RU"); // Облегчил себе жизнь
        lookupValueRU.setLookupType("GENRES");
        lookupValueRU.setLanguage("RU");
        lookupValueRU.setLookupCode("HARD_SCIENCE_FICTION");
        lookupValueRU.setMeaning("Твердая научная фантастика");
        lookupValueRU.setDescription("Твердая научная фантастика");
        lookupValueRU.setEnabledFlag('Y');
        mongoTemplate.save(lookupValueRU, LookupValue.LOOKUP_COLLECTION_NAME);

        LookupValue lookupValueEN = new LookupValue();
        lookupValueEN.setId("HARD_SCIENCE_FICTION_SU");
        lookupValueEN.setLookupType("GENRES");
        lookupValueEN.setLanguage("US");
        lookupValueEN.setLookupCode("HARD_SCIENCE_FICTION");
        lookupValueEN.setMeaning("Hard SF");
        lookupValueEN.setDescription("Hard science fiction");
        lookupValueEN.setEnabledFlag('Y');
        mongoTemplate.save(lookupValueEN, LookupValue.LOOKUP_COLLECTION_NAME);

        // Second

        lookupValueRU = new LookupValue();
        lookupValueRU.setId("CHRONOFANTASTIC_RU");
        lookupValueRU.setLookupType("GENRES");
        lookupValueRU.setLanguage("RU");
        lookupValueRU.setLookupCode("CHRONOFANTASTIC");
        lookupValueRU.setMeaning("Хронофантастика");
        lookupValueRU.setDescription("Хронофантастика");
        lookupValueRU.setEnabledFlag('Y');
        mongoTemplate.save(lookupValueRU, LookupValue.LOOKUP_COLLECTION_NAME);

        lookupValueEN = new LookupValue();
        lookupValueEN.setId("CHRONOFANTASTIC_US");
        lookupValueEN.setLookupType("GENRES");
        lookupValueEN.setLanguage("US");
        lookupValueEN.setLookupCode("CHRONOFANTASTIC");
        lookupValueEN.setMeaning("Chronofantastic");
        lookupValueEN.setDescription("Chronofantastic");
        lookupValueEN.setEnabledFlag('Y');
        mongoTemplate.save(lookupValueEN, LookupValue.LOOKUP_COLLECTION_NAME);

        // Third

        lookupValueRU = new LookupValue();
        lookupValueRU.setId("SPACE_OPERA_RU");
        lookupValueRU.setLookupType("GENRES");
        lookupValueRU.setLanguage("RU");
        lookupValueRU.setLookupCode("SPACE_OPERA");
        lookupValueRU.setMeaning("Космическая опера");
        lookupValueRU.setDescription("Космическая опера");
        lookupValueRU.setEnabledFlag('Y');
        mongoTemplate.save(lookupValueRU, LookupValue.LOOKUP_COLLECTION_NAME);

        lookupValueEN = new LookupValue();
        lookupValueEN.setId("SPACE_OPERA_SU");
        lookupValueEN.setLookupType("GENRES");
        lookupValueEN.setLanguage("US");
        lookupValueEN.setLookupCode("SPACE_OPERA");
        lookupValueEN.setMeaning("Space Opera");
        lookupValueEN.setDescription("Space Opera");
        lookupValueEN.setEnabledFlag('Y');
        mongoTemplate.save(lookupValueEN, LookupValue.LOOKUP_COLLECTION_NAME);
    }

    @ChangeSet(order = "004", id = "books", author = "vlyulin", runAlways = true)
    public void insertBooks( MongoTemplate mongoTemplate ) {

        Author author = new Author();
        author.setCountry("EN");
        author.setDateOfBirth(LocalDate.of(1859, 5, 22));
        author.setSex('M');
        author.setName("Дойл, Артур Конан");

        PublishingHouse publishingHouse1 = new PublishingHouse();
        publishingHouse1.setName("ИК «Столица» (Изд. группа GELEOS Publishing House)");
        publishingHouse1.setSettlementYear(2010);

        // https://stackoverflow.com/questions/40843120/how-to-write-mongotemplate-query-and-criteria-for-a-complex-document-structure
        List<LookupValue> lookupValueList = mongoTemplate.find(
                Query.query(
                        Criteria.where("lookup_type").is(LookupValue.GENRES_LOOKUP_TYPE)
                                .and("lookup_code").is("HARD_SCIENCE_FICTION")
                ),
                LookupValue.class,
                LookupValue.LOOKUP_COLLECTION_NAME
        );

        Book book = new Book(1L,
                "В ядовитом поясе",
                2010,
                320,
                lookupValueList,
                author,
                publishingHouse1);
        mongoTemplate.save(book, Book.BOOKS_COLLECTION_NAME);

        // Second book

        author = new Author();
        author.setCountry("RU");
        author.setDateOfBirth(LocalDate.of(1920, 1, 2));
        author.setSex('M');
        author.setName("Азимов, Айзек");

        PublishingHouse publishingHouse2 = new PublishingHouse();
        publishingHouse2.setName("PH «Stolitca» (GELEOS Publishing House)");
        publishingHouse2.setSettlementYear(1990);

        lookupValueList = mongoTemplate.find(
                Query.query(
                        Criteria.where("lookup_type").is(LookupValue.GENRES_LOOKUP_TYPE)
                                .and("lookup_code").is("CHRONOFANTASTIC")
                ),
                LookupValue.class,
                LookupValue.LOOKUP_COLLECTION_NAME
        );

        Book book2 = new Book(2L,
                "Конец Вечности",
                1955,
                247,
                lookupValueList,
                author,
                publishingHouse2);

        mongoTemplate.save(book2, Book.BOOKS_COLLECTION_NAME);

        // Third book

        author = new Author();
        author.setCountry("US");
        author.setDateOfBirth(LocalDate.of(1904, 10, 21));
        author.setSex('M');
        author.setName("Гамильтон, Эдмонд");

        lookupValueList = mongoTemplate.find(
                Query.query(
                        Criteria.where("lookup_type").is(LookupValue.GENRES_LOOKUP_TYPE)
                                .and("lookup_code").is("SPACE_OPERA")
                ),
                LookupValue.class,
                LookupValue.LOOKUP_COLLECTION_NAME
        );

        Book book3 = new Book(3L,
                "Звёздные короли",
                1947,
                150,
                lookupValueList,
                author,
                publishingHouse1);

        mongoTemplate.save(book3, Book.BOOKS_COLLECTION_NAME);
    }

    @ChangeSet(order = "005", id = "comments", author = "vlyulin", runAlways = true)
    public void insertBookComments( MongoTemplate mongoTemplate ) {

        NextSequenceService nextSequenceService = new NextSequenceService(mongoTemplate);

        Book book1 = mongoTemplate.findById(1, Book.class);
        Book book2 = mongoTemplate.findById(2, Book.class);
        Book book3 = mongoTemplate.findById(3, Book.class);

        User user101 = mongoTemplate.findById(101, User.class);
        User user102 = mongoTemplate.findById(102, User.class);

        Long cmt01Id = nextSequenceService.getNextSequence(Comment.SEQUENCE_NAME);
        Comment comment = new Comment();
        comment.setId(cmt01Id);
        comment.setBook(book1);
        comment.setComment("Стоит почитать.");
        comment.setCreatedBy(user101);
        comment.setCreationDate(LocalDate.now());
        mongoTemplate.save(comment, "comments");

        Long cmt02Id = nextSequenceService.getNextSequence(Comment.SEQUENCE_NAME);
        comment = new Comment();
        comment.setId(cmt02Id);
        comment.setBook(book1);
        comment.setComment("Не читал, но осуждаю.");
        comment.setCreatedBy(user102);
        comment.setCreationDate(LocalDate.now());
        mongoTemplate.save(comment, "comments");

        Long cmt03Id = nextSequenceService.getNextSequence(Comment.SEQUENCE_NAME);
        comment = new Comment();
        comment.setId(cmt03Id);
        comment.setBook(book2);
        comment.setComment("Замечательная книга.");
        comment.setCreatedBy(user101);
        comment.setCreationDate(LocalDate.now());
        mongoTemplate.save(comment, "comments");

        Long cmt04Id = nextSequenceService.getNextSequence(Comment.SEQUENCE_NAME);
        comment = new Comment();
        comment.setId(cmt04Id);
        comment.setBook(book2);
        comment.setComment("Можно почитать.");
        comment.setCreatedBy(user102);
        comment.setCreationDate(LocalDate.now());
        mongoTemplate.save(comment, "comments");

        Long cmt05Id = nextSequenceService.getNextSequence(Comment.SEQUENCE_NAME);
        comment = new Comment();
        comment.setId(cmt05Id);
        comment.setBook(book3);
        comment.setComment("Нудятина какая-то.");
        comment.setCreatedBy(user102);
        comment.setCreationDate(LocalDate.now());
        mongoTemplate.save(comment, "comments");
    }
}
