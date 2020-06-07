package ru.otus.spring.integration.models;

import lombok.Data;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// https://www.baeldung.com/spring-boot-mongodb-upload-file
@Data
@Document(collation = Photo.PHOTOS_COLLECTION_NAME)
public class Photo {

    public static final String PHOTOS_COLLECTION_NAME = "photos";

    @Id
    private String id;

    private String title;

    private Binary image;

    public Photo(String title) {
        this.title = title;
    }
}
