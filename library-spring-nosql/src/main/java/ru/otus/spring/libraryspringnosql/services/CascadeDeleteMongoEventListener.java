package ru.otus.spring.libraryspringnosql.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import ru.otus.spring.libraryspringnosql.models.Book;
import ru.otus.spring.libraryspringnosql.models.Comment;

//@Service
public class CascadeDeleteMongoEventListener extends AbstractMongoEventListener<Object> {

//    TODO: Совсем непонятно, как узнать удаляем мы или просто сохраняем?
//    В event типа операции не нашел
//    @Autowired
//    private MongoOperations mongoOperations;
//
//    @Override
//    public void onBeforeConvert(BeforeConvertEvent<Object> event) {
//        Object source = event.getSource();
//        if (source instanceof Book) {
//            Book book = (Book)source;
//            Query query = new Query();
//            query.addCriteria(Criteria.where("comment.bookId").is(book.getId()));
//            mongoOperations.remove(query, Comment.class);
//        }
//        super.onBeforeConvert(event);
//    }
}
