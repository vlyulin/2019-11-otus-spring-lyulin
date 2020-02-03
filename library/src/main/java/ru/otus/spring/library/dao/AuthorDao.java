package ru.otus.spring.library.dao;

import ru.otus.spring.library.domain.Author;

import java.util.List;

public interface AuthorDao {
    int count();

    void insert(Author author);

    Author getById(long id);

    List<Author> getAll();

    void deleteById(long id);
}
