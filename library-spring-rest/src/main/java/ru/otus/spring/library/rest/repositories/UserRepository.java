package ru.otus.spring.library.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.spring.library.rest.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLoginIgnoreCase(String login);
    User findByLoginAndPasswordIgnoreCase(String login, String password);
}
