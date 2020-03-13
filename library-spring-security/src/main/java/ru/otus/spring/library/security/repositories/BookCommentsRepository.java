package ru.otus.spring.library.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.spring.library.security.models.Comment;

import java.util.List;

public interface BookCommentsRepository extends JpaRepository<Comment, Long>, BookCommentsRepositoryCustom {

    List<Comment> findByBookId(long bookId);

}
