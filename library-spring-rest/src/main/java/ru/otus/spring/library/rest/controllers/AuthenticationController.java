package ru.otus.spring.library.rest.controllers;

import org.springframework.web.bind.annotation.*;
import ru.otus.spring.library.rest.security.JwtUtil;
import ru.otus.spring.library.rest.models.User;
import ru.otus.spring.library.rest.repositories.UserRepository;

@CrossOrigin
@RestController
public class AuthenticationController {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public AuthenticationController(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping(value = "/users/authenticate")
    @ResponseBody
    public User authenticate(@RequestBody AuthData authData) {
        System.out.println("username = "+authData.getUsername());
        System.out.println("password = "+authData.getPassword());
        User user = userRepository.findByLoginAndPasswordIgnoreCase(authData.getUsername(), authData.getPassword());
        if (user == null) {
            System.out.println("authenticate userRepository null");
            // TODO: Что должен возвращать REST service, если что-то пошло не так?
            return new User();
        }
        System.out.println("authenticate userRepository getted user" + user.getId());
        if( user != null) {
            String jwtToken = jwtUtil.generateToken(user);
            System.out.println("authenticate set token: "+jwtToken);
            user.setToken(jwtToken);
        }
        return user;
    }
}
