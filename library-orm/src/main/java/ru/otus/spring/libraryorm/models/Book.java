package ru.otus.spring.libraryorm.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book {
    private static final String GENRES = "GENRES";

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

    /* Так как в @Entity язык интерфейса неизвестен, то идея иметь описание жанра для разных языков
     * и уже репозиторий будет определять на каком языке выдавать описание жанра,
     * но застрял на
     * Could not set field value [LookupValue(id=1, lookupType=GENRES, lookupCode=HARD_SCIENCE_FICTION,
     * language=RU, enabledFlag=Y, startDateActive=+169108099-07-05, endDateActive=+169104628-12-09,
     * meaning=Твердая научная фантастика, description=Твердая научная фантастика)]
     * value by reflection : [class ru.otus.spring.libraryorm.models.Book.genres]
     * setter of ru.otus.spring.libraryorm.models.Book.genres;
     */
    @ManyToOne(targetEntity = LookupValue.class)
    @JoinColumnsOrFormulas({
            @JoinColumnOrFormula(formula=@JoinFormula(
                    value="(SELECT lv.lookup_value_id FROM lookup_values lv " +
                            "WHERE lv.lookup_type = 'GENRES' " +
                            "and lv.lookup_code = genre " +
                            "and lv.enabled_flag = 'Y' " +
                            "and lv.language = 'RU')", referencedColumnName="lookup_value_id")),
            @JoinColumnOrFormula(column = @JoinColumn(name = "genre", referencedColumnName="lookup_code"))
    })
    @MapKey(name = "language")
    private Map<String,LookupValue> genres = new HashMap<>();

    @ManyToOne(targetEntity = Author.class)
    @JoinColumn(name = "author_id")
    private Author author;
    @ManyToOne(targetEntity = PublishingHouse.class)
    @JoinColumn(name = "publishing_house_id")
    private PublishingHouse publishingHouse;

    // FetchType.LAZY дает ошибку
    // failed to lazily initialize a collection of role: ru.otus.spring.libraryorm.models.Book.comments,
    // could not initialize proxy - no Session
    // Не удалось победить
    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(targetEntity = Comment.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="book_id")
    private List<Comment> comments = new ArrayList<>();

    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setBook(this);
    }

    public void removeComment(Comment comment) {
        comments.remove(comment);
        comment.setBook(null);
    }
}
