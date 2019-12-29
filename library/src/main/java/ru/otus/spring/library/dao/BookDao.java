package ru.otus.spring.library.dao;

import ru.otus.spring.library.domain.Book;

import java.util.List;

public interface BookDao {

    int count();

    void insert(Book book);

    Book getById(long id);

    List<Book> getAll();

    // Поиск книг по аттрибутам
    List<Book> getBooks(
      String bookName,
      String genreCode,
      String authorName,
      String publishingHouseName,
      int publishingYear,
      int pages
    );

    void deleteById(long id);
}
