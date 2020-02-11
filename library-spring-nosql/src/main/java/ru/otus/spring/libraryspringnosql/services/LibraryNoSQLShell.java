package ru.otus.spring.libraryspringnosql.services;

import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class LibraryNoSQLShell {

    private final AppSession appSession;
    private final Library library;

    public LibraryNoSQLShell(AppSession appSession, Library library) {
        this.appSession = appSession;
        this.library = library;
    }

    @ShellMethod(key = {"connect", "conn"}, value = "Connect", prefix="-")
    public void connect() {
        appSession.openSession();
    }

    @ShellMethodAvailability(
            {"show-books", "books",
                    "query-books","q",
                    "get-book","gb",
                    "print-book-comments","pbc",
                    "add-book-comment","new-comment","nc",
                    "update-book-comment","update-comment","uc",
                    "delete-comment", "dc"
            })
    public Availability availabilityCheck() {
        return appSession.isConnected()
                ? Availability.available()
                : Availability.unavailable("You are not connected.");
    }

    @ShellMethod(key = {"show-books", "books"}, value = "Show all books", prefix="-")
    public void showAllBooks() {
        library.getAllBooks();
    }

    @ShellMethod(key = {"query-books","q"},
            value = "Query books by attrs (use % for patterns, for example -author-name '%Артур%'):", prefix="-")
    public void queryBooks(
            @ShellOption(defaultValue="-1") String bookName,
            @ShellOption(defaultValue="-1") String genreMeaning,
            @ShellOption(defaultValue="-1") String authorName,
            @ShellOption(defaultValue="-1") String publishingHouseName,
            @ShellOption(defaultValue="3000") int publishingYearFrom,
            @ShellOption(defaultValue="-1") int publishingYearTo,
            @ShellOption(defaultValue="10000") int pagesFrom,
            @ShellOption(defaultValue="-1") int pagesTo
    ) {
        library.getBooks(bookName, genreMeaning, authorName, publishingHouseName,
                publishingYearFrom, publishingYearTo, pagesFrom, pagesTo);
    }

    @ShellMethod(key = {"find-book","fb"}, value = "Find book by id", prefix="-")
    public void findBook(long bookId) {
        library.findBookById(bookId);
    }

    @ShellMethod(key = {"delete-book","db"}, value = "Delete book by id", prefix="-")
    public void deleteBookById(long bookId) { library.deleteBookById(bookId); }

    @ShellMethod(key = {"print-all-book-comments","pabc"}, value = "Print ALL book comments", prefix="-")
    public void printAllBookComments() {
        library.showAllComments();
    }

    @ShellMethod(key = {"print-book-comments","pbc"}, value = "Print book comments", prefix="-")
    public void printBookComments(long bookId) {
        library.showBookComments(bookId);
    }

    @ShellMethod(key = {"add-book-comment","new-comment","nc"}, value = "Add book comment", prefix="-")
    public void addBookComment(long bookId, String comment) {
        library.addBookComment(bookId, comment);
    }

    @ShellMethod(key = {"update-book-comment","update-comment","uc"}, value = "Update comment", prefix="-")
    public void updateBookComment(long commentId, String comment) {
        library.updateBookComment(commentId, comment);
    }

    @ShellMethod(key = {"delete-comment", "dc"}, value = "Delete comment", prefix="-")
    public void deleteComment(long commentId) {
        library.deleteBookComment(commentId);
    }
}
