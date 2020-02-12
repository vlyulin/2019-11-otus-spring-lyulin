package ru.otus.spring.libraryspringdata.repositories;

import ru.otus.spring.libraryspringdata.models.Comment;

public interface BookCommentsRepositoryCustom {

    Comment addBookComment(long bookId, String cmt);

}
