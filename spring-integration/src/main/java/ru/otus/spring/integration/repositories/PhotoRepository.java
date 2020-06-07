package ru.otus.spring.integration.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.spring.integration.models.Photo;

public interface PhotoRepository extends MongoRepository<Photo, String> {
}
