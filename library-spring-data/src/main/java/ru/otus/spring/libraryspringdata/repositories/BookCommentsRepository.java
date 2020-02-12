package ru.otus.spring.libraryspringdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.spring.libraryspringdata.models.Comment;

import java.util.List;

public interface BookCommentsRepository extends JpaRepository<Comment, Long>, BookCommentsRepositoryCustom {
    List<Comment> findByBookId(long bookId);
}
