package ru.otus.spring.libraryorm.repositories;

import ru.otus.spring.libraryorm.models.Book;
import ru.otus.spring.libraryorm.repositories.exceptions.BookNotFoundException;

import java.util.List;
import java.util.Optional;

public interface BooksRepository {
    List<Book> getAllBooks();
    List<Book> getBooks(
            String bookName,
            String genreCode,
            String genreMeaning,
            String authorName,
            String publishingHouseName,
            int publishingYear,
            int pages
    );
    Optional<Book> findBookById(long book_id) throws BookNotFoundException;
}
