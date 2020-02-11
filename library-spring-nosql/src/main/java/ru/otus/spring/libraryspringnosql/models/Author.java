package ru.otus.spring.libraryspringnosql.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Data
@NoArgsConstructor
//@Document(collection = "authors")
public class Author {
//    @Id
//    private long id;
    @Field(name = "name")
    private String name;
    @Field(name = "country")
    private String country;
    @Field(name = "sex")
    private char sex;
    @Field(name = "date_of_birth")
    private LocalDate dateOfBirth;

    public Author(/*long id, */String name, String country, char sex, LocalDate dateOfBirth) {
//        this.id = id;
        this.name = name;
        this.country = country;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
    }
}
