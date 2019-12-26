package ru.otus.spring.library.domain;

import java.util.Objects;

public class Book {

    private long id;
    private String name;
    private String genre;
    private long authorId;
    private long publishingHouseId;
    private int publishingYear;
    private int pages;

    public Book(long id, String name, String genre, long authorId, long publishingHouseId, int publishingYear, int pages) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.authorId = authorId;
        this.publishingHouseId = publishingHouseId;
        this.publishingYear = publishingYear;
        this.pages = pages;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public long getAuthorId() {
        return authorId;
    }

    public long getPublishingHouseId() {
        return publishingHouseId;
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
                authorId == book.authorId &&
                publishingHouseId == book.publishingHouseId &&
                publishingYear == book.publishingYear &&
                pages == book.pages &&
                name.equals(book.name) &&
                Objects.equals(genre, book.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, genre, authorId, publishingHouseId, publishingYear, pages);
    }
}
