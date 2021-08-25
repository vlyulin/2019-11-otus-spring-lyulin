package ru.otus.spring.libraryspringnosql.repositories;

import ru.otus.spring.libraryspringnosql.models.Comment;

import java.util.List;

public interface BookCommentsRepositoryCustom {
    Comment addBookComment(long bookId, String cmt);
    Comment updateBookComment(long commentId, String cmt);
    List<Comment> findCommentsByBookId(long bookId);
    void deleteCommentsByBookId(long bookId);
}
