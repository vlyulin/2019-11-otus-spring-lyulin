package ru.otus.spring.library.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.spring.library.security.models.Author;

public interface AuthorsReporitory extends JpaRepository<Author, Long> {
}
