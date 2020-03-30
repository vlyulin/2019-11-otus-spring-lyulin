package ru.otus.spring.library.security.services;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.otus.spring.library.security.models.User;

public interface UserService {
    User loadUserByUsername(String username) throws UsernameNotFoundException;
    User loadUserByLogin(String login) throws UsernameNotFoundException;
}
