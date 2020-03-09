package ru.otus.spring.library.rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.spring.library.rest.models.Book;
import ru.otus.spring.library.rest.repositories.BooksRepository;

import java.util.List;

@RestController
public class BooksController {

    private final BooksRepository booksRepository;

    public BooksController(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return booksRepository.findAll();
    }
}
