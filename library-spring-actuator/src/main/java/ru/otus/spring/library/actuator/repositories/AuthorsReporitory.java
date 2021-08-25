package ru.otus.spring.library.actuator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.spring.library.actuator.models.Author;

public interface AuthorsReporitory extends JpaRepository<Author, Long> {
}
