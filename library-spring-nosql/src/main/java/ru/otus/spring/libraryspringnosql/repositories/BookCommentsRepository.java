package ru.otus.spring.libraryspringnosql.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.spring.libraryspringnosql.models.Comment;

import java.util.List;

public interface BookCommentsRepository extends MongoRepository<Comment, Long>, BookCommentsRepositoryCustom {
    // TODO: не ищет
    List<Comment> findByBookId(long bookId);
}
