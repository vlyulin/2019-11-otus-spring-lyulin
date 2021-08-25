package ru.otus.spring.library.actuator.services;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.otus.spring.library.actuator.models.User;

public interface UserService {
    User loadUserByUsername(String username) throws UsernameNotFoundException;
    User loadUserByLogin(String login) throws UsernameNotFoundException;
}
