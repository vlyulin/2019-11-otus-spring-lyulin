package ru.otus.spring.libraryspringdata.services;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import ru.otus.spring.libraryspringdata.models.Book;
import ru.otus.spring.libraryspringdata.models.Comment;
import ru.otus.spring.libraryspringdata.models.LookupValue;
import ru.otus.spring.libraryspringdata.models.LookupValueId;
import ru.otus.spring.libraryspringdata.repositories.BookCommentsRepository;
import ru.otus.spring.libraryspringdata.repositories.BooksRepository;
import ru.otus.spring.libraryspringdata.repositories.exceptions.BookNotFoundException;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Library {
    public static final String GENRE = "GENRES";
    private static final String MSG_BOOK_LIST_MSG = "BOOK_LIST_MSG";
    private static final String MSG_BOOK_DESC = "BOOK_OUT_FMT";
    private static final String MSG_BOOK_COMMENTS_MSG = "BOOK_COMMENTS_MSG";
    private static final String MSG_BOOK_COMMENT = "BOOK_COMMENT_FMT";
    public static final String MSG_BOOK_NOT_FOUND = "BOOK_NOT_FOUND";
    public static final String MSG_COMMENT_NOT_FOUND = "COMMENT_NOT_FOUND";

    private final BooksRepository booksRepository;
    private final BookCommentsRepository bookCommentsRepository;
    private final MessageService ms;
    private final AppSession session;

    public Library(BooksRepository booksRepository, BookCommentsRepository bookCommntsRepository, MessageService ms, AppSession session) {
        this.booksRepository = booksRepository;
        this.bookCommentsRepository = bookCommntsRepository;
        this.ms = ms;
        this.session = session;
    }

    public void getAllBooks() {
        printBooks( booksRepository.findAll() );
    }

    public void getBooks(
            String bookName,
            String genreMeaning,
            String authorName,
            String publishingHouseName,
            int publishingYearFrom,
            int publishingYearTo,
            int pagesFrom,
            int pagesTo
    ) {

        bookName = (bookName.isEmpty() || bookName.isBlank())?null:bookName;
        genreMeaning = (genreMeaning.isEmpty() || genreMeaning.isBlank())?null:genreMeaning;
        authorName = (authorName.isEmpty() || authorName.isBlank())?null:authorName;
        publishingHouseName = (publishingHouseName.isEmpty() || publishingHouseName.isBlank())?null:publishingHouseName;

        List<Book> books = booksRepository
                .getBooks( bookName, genreMeaning, authorName, publishingHouseName,
                        publishingYearFrom, publishingYearTo, pagesFrom, pagesTo);

        printBooks(books);
    }

    public void findBookById(long bookId) {
        Optional<Book> book = booksRepository.findById(bookId);
        List<Book> books = new ArrayList<>();
        books.add(book.get());
        printBooks(books);
    }

    public void printBooks(List<Book> booksList) {
        ms.printMessageByKey(MSG_BOOK_LIST_MSG);
        for(Book book: booksList) {
            ms.printMessageByKey(MSG_BOOK_DESC,
                    book.getId(),
                    book.getName(),
                    book.getAuthor().getName(),
                    book.getGenre().getMeaning(),
                    book.getPublishingHouse().getName(),
                    book.getPublishingYear(),
                    book.getPages()
            );
        }
    }

    public void showBookComments(long bookId) {
        Optional<Book> book = booksRepository.findById(bookId);
        printBookComments(bookCommentsRepository.findByBookId(bookId));
    }

    public void printBookComments(List<Comment> bookComments) {
        ms.printMessageByKey(MSG_BOOK_COMMENTS_MSG);
        for(Comment comment: bookComments) {
            String updatedByName = (comment.getLastUpdatedBy() == null)?"":comment.getLastUpdatedBy().getName();
            String updated = (comment.getLastUpdateDate() == null)?"":
                    comment.getLastUpdateDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));

            ms.printMessageByKey(MSG_BOOK_COMMENT,
                    comment.getCommentId(),
                    comment.getComment(),
                    comment.getCreatedBy().getName(),
                    comment.getCreationDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)),
                    updatedByName,
                    updated
            );
        }
    }

    public void addBookComment(long bookId, String cmt) {
        bookCommentsRepository.addBookComment(bookId, cmt);
    }

    public void updateBookComment(long commentId, String comment) {
        bookCommentsRepository.updateBookComment(commentId, comment);
    }

    public void deleteBookComment(long commentId) {
        bookCommentsRepository.deleteById(commentId);
    }

}
