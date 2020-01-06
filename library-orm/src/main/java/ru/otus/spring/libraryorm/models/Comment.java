package ru.otus.spring.libraryorm.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id", updatable = false, nullable = false)
    private long commentId;
    @Column(name = "book_id")
    private long bookId;
    @Column(name = "comment")
    private String comment;
    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "created_by")
    private User createdBy;
    @Column(name = "creation_date")
    LocalDate creationDate;
    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "last_updated_by")
    private User lastUpdatedBy;
    @Column(name = "last_update_date")
    LocalDate lastUpdateDate;
}
