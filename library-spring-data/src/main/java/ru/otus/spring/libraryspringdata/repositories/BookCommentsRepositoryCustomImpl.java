package ru.otus.spring.libraryspringdata.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import ru.otus.spring.libraryspringdata.models.Comment;
import ru.otus.spring.libraryspringdata.services.AppSession;

import java.time.LocalDate;

@Repository
public class BookCommentsRepositoryCustomImpl implements BookCommentsRepositoryCustom {

    @Autowired
    @Lazy
    BookCommentsRepository bookCommentsRepository;

//    @Autowired
//    private AppSession session;

    @Override
    public Comment addBookComment(long bookId, String cmt) {
        Comment comment = new Comment();
        comment.setBookId(bookId);
        comment.setComment(cmt);
//        comment.setCreatedBy(session.getUser());
        comment.setCreationDate(LocalDate.now());

        bookCommentsRepository.save(comment);
        return comment;
    }
}
