package ru.otus.spring.libraryacl.repositories;

import ru.otus.spring.libraryacl.models.Book;

public interface BookRepositoryCustom {
    void saveBookWithAcl(Book book);
}
