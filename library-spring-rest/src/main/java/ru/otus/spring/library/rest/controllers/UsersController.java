package ru.otus.spring.library.rest.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.spring.library.rest.models.User;
import ru.otus.spring.library.rest.repositories.UserRepository;

import java.util.List;

@CrossOrigin
@RestController
public class UsersController {

    private final UserRepository userRepository;

    public UsersController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @GetMapping("/users")
//    public List<User> getAll(@RequestHeader("Authorization") String auth) {
//        System.out.println("UsersController Authorization: " + auth);
//        return userRepository.findAll();
//    }

    @GetMapping("/users")
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @GetMapping("/dummyService")
    public String dummyService() {
        return "Как вы сюда попали?";
    }

}
