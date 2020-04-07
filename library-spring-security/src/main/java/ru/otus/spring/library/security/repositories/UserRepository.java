package ru.otus.spring.library.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.otus.spring.library.security.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLoginIgnoreCase(String login);
    User findByNameIgnoreCase(String name);

    @Query(value = "select authority as role from authorities where login = :login", nativeQuery = true)
    String[] findAuthoritiesByLogin(@Param("login") String login);
}
