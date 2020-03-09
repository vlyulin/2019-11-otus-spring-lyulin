package ru.otus.spring.library.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.spring.library.rest.models.Author;

public interface AuthorsReporitory extends JpaRepository<Author, Long> {
}
