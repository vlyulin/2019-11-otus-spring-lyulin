package ru.otus.spring.library.rest.repositories;

import ru.otus.spring.library.rest.models.Comment;

public interface BookCommentsRepositoryCustom {

    Comment addBookComment(long bookId, String cmt);
    public void updateBookComment(long commentId, String cmt);
}
