package ru.otus.spring.libraryspringwebflux.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.spring.libraryspringwebflux.models.Comment;
import ru.otus.spring.libraryspringwebflux.services.AppSession;
import ru.otus.spring.libraryspringwebflux.services.CommentFactory;

import java.time.LocalDate;

// https://howtodoinjava.com/spring-webflux/spring-webflux-tutorial/
@Repository
public class BookCommentsRepositoryCustomImpl implements BookCommentsRepositoryCustom {

    @Autowired
    BooksRepository booksRepository;

    @Autowired
    ReactiveMongoOperations reactiveMongoOperations;

    @Autowired
    private AppSession session;

    @Autowired
    CommentFactory commentFactory;

    @Override
    public Mono<Comment> addBookComment(long bookId, String cmt) {

        return booksRepository.findById(bookId)
                .map( book -> {
                    return commentFactory.getComment(book, cmt);
                })
                .flatMap(comment -> {
                    return reactiveMongoOperations.save(comment, Comment.COMMENT_COLLECTION_NAME);
                });
    }

    @Override
    public Mono<Comment> updateBookComment(long commentId, String cmt) {

        return reactiveMongoOperations.findOne(
                Query.query(Criteria.where("_id").is(commentId)),
                Comment.class,
                Comment.COMMENT_COLLECTION_NAME
        ).map( comment -> {
                    comment.setComment(cmt);
                    comment.setLastUpdatedBy(session.getUser());
                    comment.setLastUpdateDate(LocalDate.now());
                    return comment;
                })
                .flatMap( comment -> {
                    reactiveMongoOperations.save(comment, Comment.COMMENT_COLLECTION_NAME).subscribe();
                    return Mono.just(comment);
                });
    }

    @Override
    public Flux<Comment> findCommentsByBookId(long bookId) {
        return reactiveMongoOperations.find(
                Query.query(Criteria.where("book.$id").is(bookId)),
                Comment.class,
                Comment.COMMENT_COLLECTION_NAME
        );
    }

    public void deleteCommentsByBookId(long bookId) {
        reactiveMongoOperations.remove(
                Query.query(Criteria.where("book._id").is(bookId)),
                Comment.class,
                Comment.COMMENT_COLLECTION_NAME
        ).subscribe();
    }
}
