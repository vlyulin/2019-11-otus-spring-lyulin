package ru.otus.spring.springbatch.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.spring.springbatch.models.mongo.Book;

public interface MongoBookRepository extends MongoRepository<Book, Long> {
}
