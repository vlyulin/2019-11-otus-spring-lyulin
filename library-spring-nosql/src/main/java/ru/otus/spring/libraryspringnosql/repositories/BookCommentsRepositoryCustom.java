package ru.otus.spring.libraryspringnosql.repositories;

import ru.otus.spring.libraryspringnosql.models.Comment;

import java.util.List;

public interface BookCommentsRepositoryCustom {
    Comment addBookComment(long bookId, String cmt);
    public Comment updateBookComment(long commentId, String cmt);
    public List<Comment> findCommentsByBookId(long bookId);
}
