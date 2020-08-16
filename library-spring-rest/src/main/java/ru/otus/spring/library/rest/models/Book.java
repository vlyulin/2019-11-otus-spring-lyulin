package ru.otus.spring.library.rest.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book {
    private static final String GENRES = "GENRES";
    private static final String LANGUAGE = "RU";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", updatable = false, nullable = false)
    private long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "publishing_year")
    private int publishingYear;
    @Column(name = "pages")
    private int pages;

    @ManyToOne(targetEntity = LookupValue.class, fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumnsOrFormulas({
            @JoinColumnOrFormula(formula=@JoinFormula(value="'"+GENRES+"'", referencedColumnName = "lookup_type")),
            @JoinColumnOrFormula(formula = @JoinFormula(value="'"+LANGUAGE+"'", referencedColumnName="language")),
            @JoinColumnOrFormula(column = @JoinColumn(name="genre", referencedColumnName = "lookup_code"))
    })
    private LookupValue genre;
    // Так и не смог добиться сохранения жанров как Map
    // @MapKey(name = "language")
    // private Map<String,LookupValue> genres; // = new HashMap<>();
    // B даже как List
    // private List<LookupValue> genres = new ArrayList<>();
    // Вынес для себя, что если у таблицы нет primary key или foreign key, то это становится нетривиальной задачей в JPA

    @ManyToOne(targetEntity = Author.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private Author author;
    @ManyToOne(targetEntity = PublishingHouse.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "publishing_house_id")
    private PublishingHouse publishingHouse;
}
