package ru.otus.spring.libraryspringwebflux.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.spring5.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;
import ru.otus.spring.libraryspringwebflux.repositories.BooksRepository;
import ru.otus.spring.libraryspringwebflux.repositories.UserRepository;

// https://mkyong.com/spring-boot/spring-boot-webflux-thymeleaf-reactive-example/
public class PagesController {

    private final UserRepository userRepository;
    private final BooksRepository booksRepository;

    @Autowired
    public PagesController(UserRepository userRepository, BooksRepository booksRepository) {
        this.userRepository = userRepository;
        this.booksRepository = booksRepository;
    }

    @GetMapping("/")
    public String indexPage() {
        return "index";
    }

    @GetMapping("/users")
    public String usersList(Model model) {

       IReactiveDataDriverContextVariable reactiveDataDrivenMode =
                new ReactiveDataDriverContextVariable(userRepository.findAll(), 1);
       model.addAttribute("users", reactiveDataDrivenMode);

       return "users";
    }

    @GetMapping("/books")
    public String bookList(Model model) {
        IReactiveDataDriverContextVariable reactiveDataDrivenMode =
                new ReactiveDataDriverContextVariable(booksRepository.findAll(), 1);
        model.addAttribute("books", reactiveDataDrivenMode);
        return "books";
    }
}
