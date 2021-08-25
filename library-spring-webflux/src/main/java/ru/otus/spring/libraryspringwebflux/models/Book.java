package ru.otus.spring.libraryspringwebflux.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "books")
public class Book {
    private static final String GENRES = "GENRES";
    private static final String LANGUAGE = "RU";
    @Transient
    public static final String BOOKS_COLLECTION_NAME = "books";

    @Id
    private long id;
    @Field(name = "name")
    private String name;
    @Field(name = "publishing_year")
    private int publishingYear;
    @Field(name = "pages")
    private int pages;
    @Field(name="genre")
    private List<LookupValue> genres;
    @Field(name = "author")
    private Author author;
    @Field(name="publishing_house")
    private PublishingHouse publishingHouse;

    public LookupValue getGenre(String language) {
        return genres.stream()
                .filter(lookupValue -> language.equals(lookupValue.getLanguage()))
                .findAny()
                .orElse(null);
    }
}
