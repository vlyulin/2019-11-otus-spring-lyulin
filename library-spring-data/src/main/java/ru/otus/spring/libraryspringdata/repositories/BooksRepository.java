package ru.otus.spring.libraryspringdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.otus.spring.libraryspringdata.models.Book;

import java.util.List;

public interface BooksRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b \n" +
            "WHERE (:bookName IS NULL OR UPPER(b.name) LIKE UPPER(:bookName)) \n" +
            "AND (:genreMeaning IS NULL OR UPPER(b.genre.meaning) LIKE UPPER(:genreMeaning)) \n" +
            "AND (:authorName IS NULL OR UPPER(b.author.name) LIKE UPPER(:authorName)) \n" +
            "AND (:publishingHouseName IS NULL OR UPPER(b.publishingHouse.name) LIKE UPPER(:publishingHouseName)) \n" +
            "AND (:publishingYearFrom = -1 OR :publishingYearFrom <= b.publishingYear) \n" +
            "AND (:publishingYearTo = -1 OR b.publishingYear <= :publishingYearTo) \n" +
            "AND (:pagesFrom = -1 OR :pagesFrom <= b.pages) \n" +
            "AND (:pagesTo = -1 OR b.pages <= :pagesTo) \n"
    )
    List<Book> getBooks(
            @Param("bookName") String bookName,
            @Param("genreMeaning") String genreMeaning,
            @Param("authorName") String authorName,
            @Param("publishingHouseName") String publishingHouseName,
            @Param("publishingYearFrom") int publishingYearFrom,
            @Param("publishingYearTo") int publishingYearTo,
            @Param("pagesFrom") int pagesFrom,
            @Param("pagesTo") int pagesTo
    );
}
