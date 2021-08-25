package ru.otus.spring.library.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.otus.spring.library.security.models.Book;
import ru.otus.spring.library.security.models.User;
import ru.otus.spring.library.security.repositories.BooksRepository;
import ru.otus.spring.library.security.repositories.UserRepository;
import ru.otus.spring.library.security.services.UserDetailsServiceImpl;

import java.util.List;

@Controller
public class PagesController {

    private final UserRepository userRepository;
    private final UserDetailsServiceImpl userService;
    private final BooksRepository booksRepository;

    @Autowired
    public PagesController(UserDetailsServiceImpl userService, BooksRepository booksRepository, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.userService = userService;
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

    @GetMapping("/user/{userName}")
    public String user(@PathVariable(value="userName") String userName, Model model) {
        try {
            // TODO: Есть вопрос как это будет работать?
            UserDetails user = userService.loadUserByUsername(userName);
            model.addAttribute("users", user);
        } catch (UsernameNotFoundException e) {
            // Обработка ошибки
        }
        return "user";
    }

    @GetMapping("/books")
    public String bookList(Model model) {
        List<Book> books = booksRepository.findAll();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/books/edit/{id}")
    public String editBook(@PathVariable(value="id") long bookId, Model model) {
        return "under_construction";
    }

    @GetMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable(value="id") long bookId, Model model) {
        return "under_construction";
    }

    @GetMapping("/books/{id}/comments")
    public String bookComments(@PathVariable(value="id") long bookId, Model model) {
        return "under_construction";
    }
}
