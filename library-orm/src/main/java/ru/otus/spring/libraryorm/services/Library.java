package ru.otus.spring.libraryorm.services;

import org.springframework.stereotype.Service;
import ru.otus.spring.libraryorm.models.Book;
import ru.otus.spring.libraryorm.models.Comment;
import ru.otus.spring.libraryorm.repositories.BookCommentsRepository;
import ru.otus.spring.libraryorm.repositories.BooksRepository;
import ru.otus.spring.libraryorm.repositories.exceptions.BookNotFoundException;

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
        printBooks( booksRepository.getAllBooks() );
    }

    public void getBooks(String bookName, String genreCode, String genreMeaning, String authorName, String publishingHouseName, int publishingYear, int pages) {
        List<Book> books = booksRepository.getBooks(bookName, genreCode, genreMeaning, authorName, publishingHouseName, publishingYear, pages);
        printBooks(books);
    }

    public void findBookById(long bookId) {
        Optional<Book> book = null;
        try {
            book = booksRepository.findBookById(bookId);
        } catch (BookNotFoundException e) {
            ms.printMessageByKey(MSG_BOOK_NOT_FOUND,e.getMessage());
            return;
        }
        List<Book> books = new ArrayList<Book>();
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
        Optional<Book> book = null;
        try {
            book = booksRepository.findBookById(bookId);
        } catch (BookNotFoundException e) {
            ms.printMessageByKey(MSG_BOOK_NOT_FOUND,e.getMessage());
            return;
        }
        printBookComments(bookCommentsRepository.getAllBookComments(bookId));
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
        Optional<Book> book = null;
        try {
            bookCommentsRepository.addBookComment(bookId, cmt);
        } catch (BookNotFoundException e) {
            ms.printMessageByKey(MSG_BOOK_NOT_FOUND, bookId);
            return;
        }
    }

    public void updateBookComment(long commentId, String comment) {
        int cnt = bookCommentsRepository.updateBookComment(commentId, comment);
        if( cnt == 0) {
            ms.printMessageByKey(MSG_COMMENT_NOT_FOUND, commentId);
        }
    }

    public void deleteBookComment(long commentId) {
        int cnt = bookCommentsRepository.deleteBookComment(commentId);
        if( cnt == 0) {
            ms.printMessageByKey(MSG_COMMENT_NOT_FOUND, commentId);
        }
    }

}
