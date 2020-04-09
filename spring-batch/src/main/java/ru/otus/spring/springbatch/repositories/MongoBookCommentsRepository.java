package ru.otus.spring.springbatch.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.spring.springbatch.models.mongo.Comment;

public interface MongoBookCommentsRepository extends MongoRepository<Comment, Long> {
}
