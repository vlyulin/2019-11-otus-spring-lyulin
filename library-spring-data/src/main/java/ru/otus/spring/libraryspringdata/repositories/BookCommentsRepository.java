package ru.otus.spring.libraryspringdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.spring.libraryspringdata.models.Comment;

import java.util.List;

public interface BookCommentsRepository extends JpaRepository<Comment, Long>, BookCommentsRepositoryCustom {

//    List<Comment> getAllBookComments(long book_id);
//    Comment addBookComment(long bookId, String cmt);
//    int updateBookComment(long commentId, String cmt);
//    int deleteBookComment(long commentId);
}
