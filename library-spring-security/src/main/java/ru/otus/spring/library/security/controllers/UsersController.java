package ru.otus.spring.library.security.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.spring.library.security.models.User;
import ru.otus.spring.library.security.repositories.UserRepository;

import java.util.List;

@CrossOrigin
@RestController
public class UsersController {

    private final UserRepository userRepository;

    public UsersController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
