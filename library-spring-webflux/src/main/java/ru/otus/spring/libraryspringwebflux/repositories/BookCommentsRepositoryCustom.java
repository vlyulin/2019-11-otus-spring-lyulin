package ru.otus.spring.libraryspringwebflux.repositories;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.spring.libraryspringwebflux.models.Comment;

public interface BookCommentsRepositoryCustom {
    Mono<Comment> addBookComment(long bookId, String cmt);
    Mono<Comment> updateBookComment(long commentId, String cmt);
    Flux<Comment> findCommentsByBookId(long bookId);
    void deleteCommentsByBookId(long bookId);
}
