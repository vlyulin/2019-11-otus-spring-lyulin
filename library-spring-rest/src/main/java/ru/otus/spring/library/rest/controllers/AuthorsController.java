package ru.otus.spring.library.rest.controllers;

import org.springframework.web.bind.annotation.*;
import ru.otus.spring.library.rest.models.Author;
import ru.otus.spring.library.rest.models.Book;
import ru.otus.spring.library.rest.repositories.AuthorsReporitory;

import java.util.List;

@CrossOrigin
@RestController
public class AuthorsController {
    private final AuthorsReporitory authorsReporitory;

    public AuthorsController(AuthorsReporitory authorsReporitory) {
        this.authorsReporitory = authorsReporitory;
    }

    @RequestMapping(value = "/authors", method={RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    List<Author> getAuthors() {
        return authorsReporitory.findAll();
    }

    @RequestMapping(value = "/author/{authorId}", method={RequestMethod.GET})
    @ResponseBody
    public Author getAuthor(@PathVariable("authorId") long authorId) {
        return authorsReporitory.findById(authorId).get();
    }
}
