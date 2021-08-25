package ru.otus.spring.libraryspringnosql.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.spring.libraryspringnosql.models.User;

public interface UserRepository extends MongoRepository<User, Long> {
    User findByLoginIgnoreCase(String login);
}
