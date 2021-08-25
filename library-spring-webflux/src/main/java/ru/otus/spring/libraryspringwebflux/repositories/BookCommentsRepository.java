package ru.otus.spring.libraryspringwebflux.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import ru.otus.spring.libraryspringwebflux.models.Comment;

public interface BookCommentsRepository
        extends ReactiveMongoRepository<Comment, Long>, BookCommentsRepositoryCustom
{
    Flux<Comment> findByBookId(long bookId);
    Flux<Comment> findByComment(String comment);

    // Интересное
    // https://stackoverflow.com/questions/47438745/how-to-get-max-field-value-in-collection
    // https://docs.spring.io/spring-data/mongodb/docs/2.0.1.RELEASE/reference/html/
    // Mono<Comment> findFirstByOrderByIdDesc();
    // @Query("select max(cmt.id) from comments cmt")
    // long findFirstOrderById();
}
