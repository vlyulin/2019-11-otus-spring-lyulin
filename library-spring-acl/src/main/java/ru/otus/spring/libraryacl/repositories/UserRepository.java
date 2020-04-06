package ru.otus.spring.libraryacl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.spring.libraryacl.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLoginIgnoreCase(String login);
    User findByNameIgnoreCase(String name);
}
