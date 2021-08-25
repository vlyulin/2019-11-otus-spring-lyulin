package ru.otus.spring.libraryspringwebflux.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;
import ru.otus.spring.libraryspringwebflux.models.User;

public interface UserRepository extends ReactiveMongoRepository<User, Long> {
    Mono<User> findByLoginIgnoreCase(String login);
    Mono<User> findById(long userId);
}
