package ru.otus.spring.libraryacl.services;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.otus.spring.libraryacl.models.User;

public interface UserService {
    User loadUserByUsername(String username) throws UsernameNotFoundException;
    User loadUserByLogin(String login) throws UsernameNotFoundException;
}
