package ru.otus.spring.libraryspringdata.services;

import ru.otus.spring.libraryspringdata.models.Book;
import ru.otus.spring.libraryspringdata.models.Comment;

import java.util.List;

public interface Library {
    void getAllBooks();

    void getBooks(
            String bookName,
            String genreMeaning,
            String authorName,
            String publishingHouseName,
            int publishingYearFrom,
            int publishingYearTo,
            int pagesFrom,
            int pagesTo
    );

    void findBookById(long bookId);

    void printBooks(List<Book> booksList);

    void showBookComments(long bookId);

    void printBookComments(List<Comment> bookComments);

    void addBookComment(long bookId, String cmt);

    void updateBookComment(long commentId, String comment);

    void deleteBookComment(long commentId);
}
