package ru.otus.spring.libraryacl.repositories;

import ru.otus.spring.libraryacl.models.Comment;

public interface BookCommentsRepositoryCustom {

    Comment addBookComment(long bookId, String cmt);
    public void updateBookComment(long commentId, String cmt);
}
