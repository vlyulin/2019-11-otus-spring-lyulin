package ru.otus.spring.libraryspringnosql.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// https://stackoverflow.com/questions/36448921/how-can-we-create-auto-generated-field-for-mongodb-using-spring-boot
// Альтернатива MongoDBEvents для автоматического назначения инкрементальных идентификаторов из последовательности
// Подход с MongoDBEvents у меня не заработал
@Data
@Document(collection = "customSequences")
public class CustomSequences {
    @Id
    private String id;
    private int seq;
}
