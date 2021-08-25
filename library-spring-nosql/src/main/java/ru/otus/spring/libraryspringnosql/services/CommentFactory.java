package ru.otus.spring.libraryspringnosql.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.spring.libraryspringnosql.models.Comment;

// CommentFactory сделан исключительно для того, чтобы в одном месте назначать идентификатор через NextSequenceService
@Service
public class CommentFactory {

    private long seq = 0;

    @Autowired
    private NextSequenceService nextSequenceService;

    public Comment getComment() {
        Comment comment = new Comment();
        comment.setId(nextSequenceService.getNextSequence(Comment.SEQUENCE_NAME));
        return comment;
    }
}
