package ru.otus.spring.libraryorm.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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
// TODO: Как привязать жанр?
//    @OneToOne(targetEntity = LookupValue.class)
//    @JoinColumn(name = "genre", referencedColumnName = "lookup_code", unique = true, insertable = false, updatable = false)
//    @WhereJoinTable(clause = "lookup_type = '" + GENRES + "' " +
//            "and language = '" + settings.getLanguage() + "')
//    В LOOKUP_VALUES составной PK, а в таблице BOOKS хотелось иметь только колонку GENRE (LOOKUP_CODE),
//    что было бы достаточно
//    Но связать эти таблицы без FK не удалось
//    org.springframework.beans.factory.BeanCreationException:
//    Error creating bean with name 'entityManagerFactory' defined in class path resource
//    [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]:
//    Invocation of init method failed; nested exception is org.hibernate.AnnotationException:
//    referencedColumnNames(lookup_code) of ru.otus.spring.libraryorm.models.Book.genre referencing ru.otus.spring.
//    libraryorm.models.LookupValue not mapped to a single property

//    @OneToOne(targetEntity = LookupValue.class)
//    @JoinColumn(name = "genre_id")
//    private LookupValue genre;

    @OneToOne(targetEntity = Author.class)
    @JoinColumn(name = "author_id")
    private Author author;
    @OneToOne(targetEntity = PublishingHouse.class)
    @JoinColumn(name = "publishing_house_id")
    private PublishingHouse publishingHouse;

    @OneToMany(targetEntity = Comment.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    private List<Comment> comments;
}
