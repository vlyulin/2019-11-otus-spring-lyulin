package ru.otus.spring.library.security.repositories;

import ru.otus.spring.library.security.models.Comment;

public interface BookCommentsRepositoryCustom {

    Comment addBookComment(long bookId, String cmt);
    public void updateBookComment(long commentId, String cmt);
}
