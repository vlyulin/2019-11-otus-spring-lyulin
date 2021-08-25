package ru.otus.spring.springbatch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.spring.springbatch.models.h2.Comment;

public interface H2BookCommentsRepository extends JpaRepository<Comment, Long> {
}
