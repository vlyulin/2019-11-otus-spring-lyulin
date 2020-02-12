package ru.otus.spring.libraryspringnosql.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Service;
import ru.otus.spring.libraryspringnosql.models.Comment;

@Service
public class CommentEventListener extends AbstractMongoEventListener<Comment> {

    @Autowired
    SequenceGeneratorService sequenceGenerator;
    @Override
    public void onBeforeConvert(BeforeConvertEvent<Comment> event) {
        if (event.getSource().getId() < 1) {
            event.getSource().setId(sequenceGenerator.generateSequence(Comment.SEQUENCE_NAME));
        }
    }
}
