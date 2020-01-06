package ru.otus.spring.libraryorm.services;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class LibraryOrmShell {
    private final Library library;

    public LibraryOrmShell(Library library) {
        this.library = library;
    }

    @ShellMethod(key = {"show-books", "books"}, value = "Show all books")
    public void showAllBooks() {
        library.findAll();
    }

    @ShellMethod(key = {"query-books","q"}, value = "Query books by attrs (use % for patterns, for example -author-name '%Артур%'):", prefix="-")
    public void queryBooks(
            @ShellOption(defaultValue="") String bookName,
            @ShellOption(defaultValue="") String genreCode,
            @ShellOption(defaultValue="") String genreMeaning,
            @ShellOption(defaultValue="") String authorName,
            @ShellOption(defaultValue="") String publishingHouseName,
            @ShellOption(defaultValue="0") int publishingYear,
            @ShellOption(defaultValue="0") int pages
    ) {
        library.getBooks(bookName, genreCode, genreMeaning, authorName, publishingHouseName, publishingYear, pages);
    }

    @ShellMethod(key = {"get-book","gb"}, value = "Find book by id")
    public void getBook(long bookId) {
        library.findBookById(bookId);
    }

    @ShellMethod(key = {"print-book-comments","pbc"}, value = "Print book comments")
    public void printBookComments(long bookId) {
        library.showBookComments(bookId);
    }

    @ShellMethod(key = {"add-book-comment","new-comment","nc"}, value = "Add book comment")
    public void addBookComment(long bookId, String comment) {
        library.addBookComment(bookId, comment);
    }

    @ShellMethod(key = {"update-book-comment","update-comment","uc"}, value = "Update comment")
    public void updateBookComment(long commentId, String comment) {
        library.updateBookComment(commentId, comment);
    }

    @ShellMethod(key = {"delete-comment", "dc"}, value = "Delete comment")
    public void deleteComment(long commentId) {
        library.deleteBookComment(commentId);
    }
}
