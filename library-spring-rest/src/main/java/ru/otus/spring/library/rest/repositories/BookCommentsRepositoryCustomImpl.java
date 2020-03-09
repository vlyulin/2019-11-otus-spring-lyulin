package ru.otus.spring.library.rest.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import ru.otus.spring.library.rest.models.Comment;
import ru.otus.spring.library.rest.services.AppSession;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public class BookCommentsRepositoryCustomImpl implements BookCommentsRepositoryCustom {

    @Autowired
    @Lazy
    BookCommentsRepository bookCommentsRepository;

    @Autowired
    private AppSession session;

    @Override
    public Comment addBookComment(long bookId, String cmt) {
        Comment comment = new Comment();
        comment.setBookId(bookId);
        comment.setComment(cmt);
        comment.setCreatedBy(session.getUser());
        comment.setCreationDate(LocalDate.now());

        bookCommentsRepository.save(comment);
        return comment;
    }

    @Override
    public void updateBookComment(long commentId, String cmt) {
        Optional<Comment> optComment = bookCommentsRepository.findById(commentId);
        if(optComment.isEmpty()) return;
        Comment comment = optComment.get();
        comment.setComment(cmt);
        comment.setLastUpdatedBy(session.getUser());
        comment.setLastUpdateDate(LocalDate.now());
        bookCommentsRepository.save(comment);
    }
}
