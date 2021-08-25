package ru.otus.spring.libraryspringwebflux.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Author {

    @Field(name = "name")
    private String name;
    @Field(name = "country")
    private String country;
    @Field(name = "sex")
    private char sex;
    @Field(name = "date_of_birth")
    private LocalDate dateOfBirth;

    public Author(String name, String country, char sex, LocalDate dateOfBirth) {
        this.name = name;
        this.country = country;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
    }
}
