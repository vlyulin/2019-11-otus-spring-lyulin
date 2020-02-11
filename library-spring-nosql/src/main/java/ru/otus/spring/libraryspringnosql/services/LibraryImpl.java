package ru.otus.spring.libraryspringnosql.services;

import org.springframework.stereotype.Service;
import ru.otus.spring.libraryspringnosql.models.Book;
import ru.otus.spring.libraryspringnosql.models.Comment;
import ru.otus.spring.libraryspringnosql.repositories.BookCommentsRepository;
import ru.otus.spring.libraryspringnosql.repositories.BooksRepository;
import ru.otus.spring.libraryspringnosql.repositories.UserRepository;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
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

    private final AppSession session;
    private final MessageService ms;
    private final UserRepository userRepository;
    private final BooksRepository booksRepository;
    private final BookCommentsRepository bookCommentsRepository;

    public Library(AppSession session, MessageService ms, UserRepository userRepository, BooksRepository booksRepository, BookCommentsRepository bookCommentsRepository) {
        this.session = session;
        this.ms = ms;
        this.userRepository = userRepository;
        this.booksRepository = booksRepository;
        this.bookCommentsRepository = bookCommentsRepository;
    }

    public void getAllBooks() {
        printBooks(booksRepository.findAll());
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
        List<Book> books = booksRepository
                .getBooks(bookName, genreMeaning, authorName, publishingHouseName,
                        publishingYearFrom, publishingYearTo, pagesFrom, pagesTo);
        printBooks(books);
    }

    public void findBookById(long bookId) {
        Optional<Book> book = booksRepository.findById(bookId);
        book.ifPresent(b -> printBooks(List.of(b)));
    }

    public void deleteBookById(long bookId) {
        booksRepository.deleteById(bookId);
    }

    public void printBooks(List<Book> booksList) {
        ms.printMessageByKey(MSG_BOOK_LIST_MSG);
        for(Book book: booksList) {
            ms.printMessageByKey(MSG_BOOK_DESC,
                    book.getId(),
                    book.getName(),
                    book.getAuthor().getName(),
                    book.getGenre(session.getSettings().getLanguage()).getMeaning(),
                    book.getPublishingHouse().getName(),
                    book.getPublishingYear(),
                    book.getPages()
            );
        }
    }

    public void showAllComments() {
        printBookComments(bookCommentsRepository.findAll());
    }

    public void showBookComments(long bookId) {
        // TODO: проблема с поиском комментариев
//        printBookComments(bookCommentsRepository.findByBookId(bookId));
        // Другой вариант, и тоже не ищет. Что-то делаю не так
        printBookComments(bookCommentsRepository.findCommentsByBookId(bookId));
    }

    public void printBookComments(List<Comment> bookComments) {
        ms.printMessageByKey(MSG_BOOK_COMMENTS_MSG);
        for(Comment comment: bookComments) {
            String updatedByName = (comment.getLastUpdatedBy() == null)?"":comment.getLastUpdatedBy().getName();
            String updated = (comment.getLastUpdateDate() == null)?"":
                    comment.getLastUpdateDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));

            ms.printMessageByKey(MSG_BOOK_COMMENT,
                    comment.getId(),
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
