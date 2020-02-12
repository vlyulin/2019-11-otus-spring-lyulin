package ru.otus.spring.libraryorm.repositories;

import ru.otus.spring.libraryorm.models.User;

public interface UserRepository {
    User getUser( String login );
}
