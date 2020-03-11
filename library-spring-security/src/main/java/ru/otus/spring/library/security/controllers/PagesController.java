package ru.otus.spring.library.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.otus.spring.library.security.models.Book;
import ru.otus.spring.library.security.models.User;
import ru.otus.spring.library.security.repositories.BooksRepository;
import ru.otus.spring.library.security.repositories.UserRepository;

import java.util.List;

@Controller
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

       // Доступ только для администратора
       List<User> users = userRepository.findAll();
       model.addAttribute("users", users);
       return "users";
    }

    @GetMapping("/books")
    public String bookList(Model model) {
        List<Book> books = booksRepository.findAll();
        model.addAttribute("books", books);
        return "books";
    }

//    @GetMapping("/authenticated")
//    public String authenticatedPage() {
//        SecurityContext securityContext = SecurityContextHolder.getContext();
//        Authentication authentication = securityContext.getAuthentication();
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//        System.out.println(userDetails.getUsername());
//        return "authenticated";
//    }
}
