package ru.otus.spring.library.domain;

import java.util.Objects;

public class Book {

    private long id;
    private String name;
    // private String genre;
    // private long authorId;
    // private long publishingHouseId;
    private int publishingYear;
    private int pages;

    private LookupValue genre;
    private Author author;
    private PublishingHouse publishingHouse;

    public Book(long id, String name, LookupValue genre, Author author, PublishingHouse publishingHouse, int publishingYear, int pages) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.author = author;
        this.publishingHouse = publishingHouse;
        this.publishingYear = publishingYear;
        this.pages = pages;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LookupValue getGenre() {
        return genre;
    }

    public Author getAuthor() {
        return author;
    }

    public PublishingHouse getPublishingHouse() {
        return publishingHouse;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return id == book.id &&
                author.equals(book) && // authorId == book.authorId &&
                publishingHouse.equals(book.publishingHouse) && // publishingHouseId == book.publishingHouseId &&
                publishingYear == book.publishingYear &&
                pages == book.pages &&
                name.equals(book.name) &&
                Objects.equals(genre, book.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, genre, author, publishingHouse, publishingYear, pages);
    }
}
