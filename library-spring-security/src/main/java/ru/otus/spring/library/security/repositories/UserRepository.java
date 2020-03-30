package ru.otus.spring.library.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.spring.library.security.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLoginIgnoreCase(String login);
    User findByNameIgnoreCase(String name);
}
