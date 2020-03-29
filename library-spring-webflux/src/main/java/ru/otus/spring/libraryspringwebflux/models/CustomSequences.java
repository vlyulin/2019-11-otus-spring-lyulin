package ru.otus.spring.libraryspringwebflux.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// https://stackoverflow.com/questions/36448921/how-can-we-create-auto-generated-field-for-mongodb-using-spring-boot
@Data
@Document(collection = "customSequences")
public class CustomSequences {
    @Id
    private String id;
    private Long seq;
}
