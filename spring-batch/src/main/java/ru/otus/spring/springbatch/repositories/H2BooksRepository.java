package ru.otus.spring.springbatch.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.spring.springbatch.models.h2.Book;

import java.util.List;

public interface H2BooksRepository extends JpaRepository<Book, Long> {

    @EntityGraph(attributePaths = {"author", "publishingHouse", "genre"})
    List<Book> findAll();

}
