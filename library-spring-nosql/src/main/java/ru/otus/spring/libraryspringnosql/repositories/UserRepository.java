package ru.otus.spring.libraryspringnosql.repostory;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.spring.libraryspringnosql.models.Author;
import ru.otus.spring.libraryspringnosql.models.User;

public interface UserRepository extends MongoRepository<Author, Long> {
    User findByLoginIgnoreCase(String login);
}
