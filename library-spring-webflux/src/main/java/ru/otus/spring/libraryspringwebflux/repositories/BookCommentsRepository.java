package ru.otus.spring.libraryspringwebflux.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import ru.otus.spring.libraryspringwebflux.models.Comment;

public interface BookCommentsRepository
        extends ReactiveMongoRepository<Comment, Long>, BookCommentsRepositoryCustom
{
    Flux<Comment> findByBookId(long bookId);
}
