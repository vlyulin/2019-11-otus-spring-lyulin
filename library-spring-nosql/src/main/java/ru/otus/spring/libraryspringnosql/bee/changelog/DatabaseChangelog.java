package ru.otus.spring.libraryspringnosql.bee.changelog;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.client.MongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
import ru.otus.spring.libraryspringnosql.models.Author;
import com.mongodb.util.JSON;

import java.time.LocalDate;


@ChangeLog
public class DatabaseChangelog {

//    @Autowired
//    MongoTemplate mongoTemplate;

    @ChangeSet(order = "001", id = "Author", author = "vlyulin")
    public void insertAuthors(DB db) {
//        DBCollection authorsCollection = db.getCollection("authors");
//        MongoCollection<Author> authorMongoCollection =
//                (MongoCollection<Author>) db.getCollection("authors");

//        insert into authors (author_id, name, country, sex, date_of_birth)
//        values (1, 'Дойл, Артур Конан', 'EN', 'M', DATE '1859-05-22');
//        long id, String name, String country, char sex, LocalDate dateOfBirth)

        Author author = new Author(1, "Дойл, Артур Конан", "EN",
                'M', LocalDate.of(1859, 05, 22));
//        BasicDBObject a = new BasicDBObject().append()
        DBCollection dbCollection = db.getCollection("authors");
        DBObject dbObject = (DBObject) JSON.parse(
                "{'id':'2', 'name':'Дойл, Артур Конан', 'country':'EN', 'sex':'M', 'date_of_birth':'2020-02-05T21:00:00.000+00:00'}");
        dbCollection.insert(dbObject);

//        BObject dbObject = (DBObject) JSON
//                .parse("{'name':'mkyong', 'age':30}");
//        collection.insert(dbObject);
//        dbCollection.
//        mongoTemplate.save(author, "authors");
//
//        insert into authors (author_id, name, country, sex, date_of_birth)
//        values (2, 'Азимов, Айзек', 'RU', 'M', DATE '1920-01-02');
//
//        insert into authors (author_id, name, country, sex, date_of_birth)
//        values (3, 'Гамильтон, Эдмонд', 'US', 'M', DATE '1904-10-21');
    }
}
