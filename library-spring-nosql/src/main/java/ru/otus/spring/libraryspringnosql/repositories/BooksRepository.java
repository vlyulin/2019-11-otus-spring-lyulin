package ru.otus.spring.libraryspringnosql.repostory;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.spring.libraryspringnosql.models.Book;

public interface BooksRepository extends MongoRepository<Book, Long> {
}
