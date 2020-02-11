package ru.otus.spring.libraryspringnosql.services;

import ru.otus.spring.libraryspringnosql.models.Book;
import ru.otus.spring.libraryspringnosql.models.Comment;

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

    void deleteBookById(long bookId);

    void printBooks(List<Book> booksList);

    void showAllComments();

    void showBookComments(long bookId);

    void printBookComments(List<Comment> bookComments);

    void addBookComment(long bookId, String cmt);

    void updateBookComment(long commentId, String comment);

    void deleteBookComment(long commentId);
}
