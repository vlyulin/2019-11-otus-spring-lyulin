package ru.otus.spring.libraryorm.repositories;

import ru.otus.spring.libraryorm.models.Comment;
import ru.otus.spring.libraryorm.repositories.exceptions.BookNotFoundException;

import java.util.List;

public interface BookCommentsRepository {

    List<Comment> getAllBookComments(long book_id);

    Comment addBookComment(long bookId, String cmt) throws BookNotFoundException;
    int updateBookComment(long commentId, String cmt);
    int deleteBookComment(long commentId);
}
