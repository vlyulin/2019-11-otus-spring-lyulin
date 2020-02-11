package ru.otus.spring.libraryspringnosql.repostory;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.spring.libraryspringnosql.models.Author;

import java.util.List;

public interface AuthorRepository extends MongoRepository<Author, Long> {
    List<Author> findAll();
}
