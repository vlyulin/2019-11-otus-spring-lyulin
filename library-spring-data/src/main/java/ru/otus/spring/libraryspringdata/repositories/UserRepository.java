package ru.otus.spring.libraryspringdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.spring.libraryspringdata.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLoginIgnoreCase(String login);
}
