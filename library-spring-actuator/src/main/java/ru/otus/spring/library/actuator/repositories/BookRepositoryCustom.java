package ru.otus.spring.library.actuator.repositories;

import ru.otus.spring.library.actuator.models.Book;

public interface BookRepositoryCustom {
    void saveBookWithAcl(Book book);
}
