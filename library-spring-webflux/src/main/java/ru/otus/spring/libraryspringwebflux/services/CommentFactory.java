package ru.otus.spring.libraryspringwebflux.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.otus.spring.libraryspringwebflux.models.Book;
import ru.otus.spring.libraryspringwebflux.models.Comment;

import java.time.LocalDate;

// CommentFactory сделан исключительно для того,
// чтобы в одном месте назначать идентификатор через NextSequenceService
@Service
public class CommentFactory {

    private long seq = 0;

    @Autowired
    private NextSequenceService nextSequenceService;

    @Autowired
    private AppSession session;

    public Mono<Comment> getComment() {
        Comment comment = new Comment();
        comment.setId(nextSequenceService.getNextSequence(Comment.SEQUENCE_NAME));
        return Mono.just(comment);
    }

    public Mono<Comment> getComment(Book book, String text) {
        Comment comment = new Comment();
        comment.setId(nextSequenceService.getNextSequence(Comment.SEQUENCE_NAME));
        comment.setBook(book);
        comment.setComment(text);
        comment.setCreatedBy(session.getUser());
        comment.setCreationDate(LocalDate.now());
        return Mono.just(comment);
    }
}
