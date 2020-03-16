package ru.otus.spring.libraryspringnosql.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;
import ru.otus.spring.libraryspringnosql.models.Comment;
import ru.otus.spring.libraryspringnosql.services.NextSequenceService;

// https://stackoverflow.com/questions/36448921/how-can-we-create-auto-generated-field-for-mongodb-using-spring-boot
// Нашел альтернативу для MongoDBEvents для автоматического назначения инкрементальных идентификаторов из последовательности
// Подход с MongoDBEvents у меня не заработал
// Класс оставил, так как жалко было удалять
public class CommentEventListener extends AbstractMongoEventListener<Comment> {

    @Autowired
    private NextSequenceService nextSequenceService;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Comment> event) {
        System.out.println("onBeforeConvert entring.");
        if (event.getSource().getId() <= 0) {
            System.out.println("Set id.");
            event.getSource().setId(nextSequenceService.getNextSequence(Comment.SEQUENCE_NAME));
        }
    }

    // Попытка разобраться почему не работал Listener. Проверка другого события.
    @Override
    public void onBeforeSave(BeforeSaveEvent<Comment> event) {
        super.onBeforeSave(event);
        System.out.println("onBeforeSave entring.");
        if (event.getSource().getId() <= 0) {
            System.out.println("Set id.");
            event.getSource().setId(nextSequenceService.getNextSequence(Comment.SEQUENCE_NAME));
        }
    }
}
