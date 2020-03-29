package ru.otus.spring.libraryspringwebflux.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {
    @Transient
    public static final String USERS_COLLECTION_NAME = "users";
    @Id
    private long id;
    @Field(name = "login")
    private String login;
    @Field(name = "password")
    private String password;
    @Field(name = "name")
    private String name;
}
