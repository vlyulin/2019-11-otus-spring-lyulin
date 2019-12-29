package ru.otus.spring.library.services;

import org.springframework.stereotype.Service;
import ru.otus.spring.library.dao.AuthorDao;
import ru.otus.spring.library.dao.BookDao;
import ru.otus.spring.library.dao.LookupValueDao;
import ru.otus.spring.library.dao.PublishingHouseDao;
import ru.otus.spring.library.domain.Author;
import ru.otus.spring.library.domain.Book;
import ru.otus.spring.library.domain.LookupValue;

import java.util.List;
import java.util.Map;

@Service
public class Library {
    public static final String GENRE = "GENRES";

    private Map<String,LookupValue> genres;

    private LookupValueDao lookupValueDao;
    private AuthorDao authorDao;
    private PublishingHouseDao publishingHouseDao;
    private BookDao bookDao;

    public Library(LookupValueDao lookupValueDao, AuthorDao authorDao, PublishingHouseDao publishingHouseDao, BookDao bookDao) {
        this.lookupValueDao = lookupValueDao;
        this.authorDao = authorDao;
        this.publishingHouseDao = publishingHouseDao;
        this.bookDao = bookDao;

        genres = lookupValueDao.getLookupTypeValues(GENRE);
    }

    public void printBooks( List<Book> booksList) {
        System.out.println("Books list:");
        for(Book book: booksList) {
            System.out.println(
                    book.getName()
                            + " " + book.getGenre().getMeaning()
                            + " " + book.getAuthor().getName()
                            + " " + book.getPublishingHouse().getName()
                            + " " + book.getPages()
            );
        }
    }

    public void listAllLibraryBooks() {
        List<Book> bookList = bookDao.getAll();
        printBooks(bookList);
    }

    public void listBooksByQuery(String bookName, String genreCode, String authorName, String publishingHouseName, int publishingYear, int pages) {
        List<Book> booksList = bookDao.getBooks(bookName, genreCode, authorName, publishingHouseName, publishingYear, pages);
        printBooks(booksList);
    }

    public void insertAuthor( Author author) {
        authorDao.insert(author);
    }
}
