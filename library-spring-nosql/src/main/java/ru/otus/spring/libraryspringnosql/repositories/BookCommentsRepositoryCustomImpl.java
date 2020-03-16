package ru.otus.spring.libraryspringnosql.repositories;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import ru.otus.spring.libraryspringnosql.models.Book;
import ru.otus.spring.libraryspringnosql.models.Comment;
import ru.otus.spring.libraryspringnosql.services.AppSession;
import ru.otus.spring.libraryspringnosql.services.CommentFactory;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class BookCommentsRepositoryCustomImpl implements BookCommentsRepositoryCustom {

    @Autowired
    BooksRepository booksRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    MongoOperations mongoOperations;

    @Autowired
    private AppSession session;

    @Autowired
    CommentFactory commentFactory;

    @Override
    public Comment addBookComment(long bookId, String cmt) {

        List<Book> books = booksRepository.findAll();
        System.out.println("books.count " + books.size());

        Optional<Book> optBook = booksRepository.findById(bookId);
        System.out.println("optBook = "+optBook.get());
        if( optBook.get() == null ) return null;

        Comment comment = commentFactory.getComment();
        comment.setBook(optBook.get());
        comment.setComment(cmt);
        comment.setCreatedBy(session.getUser());
        comment.setCreationDate(LocalDate.now());

        mongoOperations.save(comment, Comment.COMMENT_COLLECTION_NAME);
        return comment;
    }

    @Override
    public Comment updateBookComment(long commentId, String cmt) {

        Comment comment =  mongoOperations.findOne(
                Query.query(Criteria.where("_id").is(commentId)),
                Comment.class,
                Comment.COMMENT_COLLECTION_NAME
        );
        comment.setComment(cmt);
        comment.setLastUpdatedBy(session.getUser());
        comment.setLastUpdateDate(LocalDate.now());
        mongoOperations.save(comment, Comment.COMMENT_COLLECTION_NAME);

        return comment;
    }

    @Override
    public List<Comment> findCommentsByBookId(long bookId) {
        // Еще одна попытка заставить искать по идентификатору книги
        List<Comment> comments = mongoOperations.find(
                Query.query(Criteria.where("book.$id").is(bookId)),
                Comment.class,
                Comment.COMMENT_COLLECTION_NAME
        );
        return comments;
    }

    @Override
    public void deleteCommentsByBookId(long bookId) {
        mongoOperations.remove(
                Query.query(Criteria.where("book.$id").is(bookId)),
                Comment.class,
                Comment.COMMENT_COLLECTION_NAME
        );
    }
}
