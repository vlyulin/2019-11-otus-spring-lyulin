package ru.otus.spring.library.docker.repositories;

import ru.otus.spring.library.docker.models.Book;

public interface BooksRepositoryCustom {
    void saveBookWithAcl(Book book);
}
