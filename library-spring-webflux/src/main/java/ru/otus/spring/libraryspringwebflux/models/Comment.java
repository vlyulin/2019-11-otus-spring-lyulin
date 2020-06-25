package ru.otus.spring.libraryspringwebflux.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="comments")
public class Comment {

    @Transient
    public static final String SEQUENCE_NAME = "comments_sequence";
    @Transient
    public static final String COMMENT_COLLECTION_NAME = "comments";

    @Id
    private long Id;
    @DBRef
    private Book book;
    @Field(name = "comment")
    private String comment;
    @DBRef
    private User createdBy;
    @Field(name = "creation_date")
    LocalDate creationDate;
    @DBRef
    private User lastUpdatedBy;
    @Field(name = "last_update_date")
    private LocalDate lastUpdateDate;
}
