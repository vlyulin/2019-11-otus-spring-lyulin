package ru.otus.spring.libraryspringnosql.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import ru.otus.spring.libraryspringnosql.models.Book;
import ru.otus.spring.libraryspringnosql.models.Comment;
import ru.otus.spring.libraryspringnosql.services.AppSession;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class BookCommentsRepositoryCustomImpl implements BookCommentsRepositoryCustom {

    // Это из серии все поломать, но чтобы хоть как-то заработало :-)
//    @Autowired
//    BookCommentsRepository bookCommentsRepository;

    @Autowired
    BooksRepository booksRepository;

    @Autowired
    MongoOperations mongoOperations;

    @Autowired
    private AppSession session;

    @Override
    public Comment addBookComment(long bookId, String cmt) {

        Optional<Book> optBook = booksRepository.findById(bookId);
        if( optBook.isEmpty() ) return null;

        Comment comment = new Comment();
        comment.setBook(optBook.get());
        comment.setComment(cmt);
        comment.setCreatedBy(session.getUser());
        comment.setCreationDate(LocalDate.now());

        mongoOperations.save(comment);
//        bookCommentsRepository.save(comment);
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
        mongoOperations.save(comment);

        return comment;
    }

    @Override
    public List<Comment> findCommentsByBookId(long bookId) {
        // Еще одна попытка заставить искать по идентификатору книги
        return  mongoOperations.find(
                Query.query(Criteria.where("book._id").is(bookId)),
                Comment.class,
                Comment.COMMENT_COLLECTION_NAME
        );
    }
}
