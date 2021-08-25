package ru.otus.spring.libraryacl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.spring.libraryacl.models.Author;

public interface AuthorsReporitory extends JpaRepository<Author, Long> {
}
