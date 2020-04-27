package ru.otus.spring.library.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.spring.library.rest.models.Comment;

import java.util.List;

public interface BookCommentsRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByBookId(long bookId);

}
