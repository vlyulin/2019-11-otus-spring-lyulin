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

    // @Autowired
    // MongoTemplate mongoTemplate;

    @Autowired
    ReactiveMongoOperations reactiveMongoOperations;

    @Autowired
    private AppSession session;

    @Autowired
    CommentFactory commentFactory;

    @Override
    public Mono<Comment> addBookComment(long bookId, String cmt) {

        return booksRepository.findById(bookId)
                .map(book -> {
                    Comment comment = commentFactory.getComment();
                    comment.setBook(book);
                    comment.setComment(cmt);
                    comment.setCreatedBy(session.getUser());
                    comment.setCreationDate(LocalDate.now());

                    return comment;
                })
                .flatMap( comment -> {
                        reactiveMongoOperations.save(comment, Comment.COMMENT_COLLECTION_NAME)
                            .subscribe();
                        return Mono.just(comment);
                });

        // Mono<Book> monoBook = booksRepository.findById(bookId);
        // return monoBook.map(book -> {
        //     Comment comment = commentFactory.getComment();
        //     comment.setBook(book);
        //     comment.setComment(cmt);
        //     comment.setCreatedBy(session.getUser());
        //     comment.setCreationDate(LocalDate.now());
        //     reactiveMongoOperations.save(comment, Comment.COMMENT_COLLECTION_NAME);
        //     return comment;
        // });
    }

    @Override
    public Mono<Comment> updateBookComment(long commentId, String cmt) {

        return reactiveMongoOperations.findOne(
                Query.query(Criteria.where("_id").is(commentId)),
                Comment.class,
                Comment.COMMENT_COLLECTION_NAME
        ).map( comment -> {
                    comment.setComment(cmt);
                    // System.out.println("updateBookComment: " + session.getUser() + " " + LocalDate.now());
                    comment.setLastUpdatedBy(session.getUser());
                    comment.setLastUpdateDate(LocalDate.now());
                    return comment;
                })
                .flatMap( comment -> {
                    // System.out.println("updateBookComment save: "+comment.getComment());
                    reactiveMongoOperations.save(comment, Comment.COMMENT_COLLECTION_NAME).subscribe();
                    return Mono.just(comment);
                });

        // Comment comment =  reactiveMongoOperations.findOne(
        //         Query.query(Criteria.where("_id").is(commentId)),
        //         Comment.class,
        //         Comment.COMMENT_COLLECTION_NAME
        // );
        // comment.setComment(cmt);
        // comment.setLastUpdatedBy(session.getUser());
        // comment.setLastUpdateDate(LocalDate.now());
        // reactiveMongoOperations.save(comment, Comment.COMMENT_COLLECTION_NAME);
//
        // return comment;
    }

    @Override
    public Flux<Comment> findCommentsByBookId(long bookId) {
        return reactiveMongoOperations.find(
                Query.query(Criteria.where("book.$id").is(bookId)),
                Comment.class,
                Comment.COMMENT_COLLECTION_NAME
        );
    }

    @Override
    public void deleteCommentsByBookId(long bookId) {
        reactiveMongoOperations.remove(
                Query.query(Criteria.where("book.$id").is(bookId)),
                Comment.class,
                Comment.COMMENT_COLLECTION_NAME
        ).subscribe();
    }
}
