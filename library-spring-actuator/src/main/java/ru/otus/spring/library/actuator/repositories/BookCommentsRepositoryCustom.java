package ru.otus.spring.library.actuator.repositories;

import ru.otus.spring.library.actuator.models.Comment;

public interface BookCommentsRepositoryCustom {

    Comment addBookComment(long bookId, String cmt);
    public void updateBookComment(long commentId, String cmt);
}
