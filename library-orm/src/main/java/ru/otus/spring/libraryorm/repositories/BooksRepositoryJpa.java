package ru.otus.spring.libraryorm.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import ru.otus.spring.libraryorm.services.AppSession;
import ru.otus.spring.libraryorm.models.Book;
import ru.otus.spring.libraryorm.models.Comment;
import ru.otus.spring.libraryorm.repositories.exceptions.BookNotFoundException;

@Transactional
@Repository
public class BooksRepositoryJpa implements BooksRepository {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private AppSession session;

    @Override
    public List<Book> getAllBooks() {
        TypedQuery<Book> query = em.createQuery(
                "select b from Book b join fetch b.author join fetch b.publishingHouse",
                Book.class);
        return query.getResultList();
    }

    @Override
    public List<Book> getBooks(String bookName, String genreCode, String genreMeaning, String authorName, String publishingHouseName, int publishingYear, int pages) {
        String bookNameTmp = (bookName == null || bookName.isBlank() || bookName.isEmpty())?null:bookName;
        String authorNameTmp = (authorName == null || authorName.isBlank() || authorName.isEmpty())?null:authorName;
        String publishingHouseNameTmp = (publishingHouseName == null || publishingHouseName.isBlank() || publishingHouseName.isEmpty())?null:publishingHouseName;
        Integer publishingYearTmp = (publishingYear == 0)?null:Integer.valueOf(publishingYear);
        Integer pagesTmp = (pages == 0)?null:Integer.valueOf(pages);

        TypedQuery<Book> query = em.createQuery(
                "SELECT b FROM Book b JOIN FETCH b.author a JOIN FETCH b.publishingHouse ph\n" +
                        "WHERE 1 = 1\n" +
                        "AND (:book_name IS NULL OR UPPER(b.name) LIKE UPPER(:book_name))\n" +
                        "AND (:author_name IS NULL OR UPPER(a.name) LIKE UPPER(:author_name))\n" +
                        "AND (:publishing_house_name IS NULL OR UPPER(ph.name) LIKE UPPER(:publishing_house_name))\n" +
                        "AND (:publishing_year IS NULL OR b.publishingYear = :publishing_year)\n" +
                        "AND (:pages IS NULL OR b.pages = :pages)",
                Book.class
        );

        query.setParameter("book_name", bookNameTmp);
        query.setParameter("author_name", authorNameTmp);
        query.setParameter("publishing_house_name", publishingHouseNameTmp);
        query.setParameter("publishing_year", publishingYearTmp);
        query.setParameter("pages", pagesTmp);
        return query.getResultList();
    }

    @Override
    public Optional<Book> findBookById(long bookId) throws BookNotFoundException {
        Book book = em.find(Book.class, bookId);
        if( book == null ) {
            throw new BookNotFoundException("id = " + bookId);
        }
        return Optional.ofNullable(book);
    }
}
