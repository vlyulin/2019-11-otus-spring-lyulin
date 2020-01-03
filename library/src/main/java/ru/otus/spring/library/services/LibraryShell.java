package ru.otus.spring.library.services;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class LibraryShell {
    private final Library library;

    public LibraryShell(Library library) {
        this.library = library;
    }

    @ShellMethod(key = {"show-books", "books"}, value = "Show all books")
    public void showAllBooks() {
        library.listAllLibraryBooks();
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
        library.listBooksByQuery(bookName, genreCode, genreMeaning, authorName, publishingHouseName, publishingYear, pages);
    }
}
