package ru.otus.spring.libraryorm.services;

import org.springframework.stereotype.Service;
import ru.otus.spring.libraryorm.config.Settings;
import ru.otus.spring.libraryorm.models.LookupValue;
import ru.otus.spring.libraryorm.models.User;
import ru.otus.spring.libraryorm.repositories.UserRepository;

/*
* Сессия приложения. Содержит авторизовавшегося пользователя.
* Пока указывается в свойствах.
* */
@Service
public class AppSession {

    private Settings settings;
    private UserRepository userRepository;
    private User user;
    private boolean connected = false;

    public AppSession(Settings settings, UserRepository userRepository) {
        this.settings = settings;
        this.userRepository = userRepository;
    }

    public void openSession() {
        this.user = userRepository.getUser(settings.getLogin());
        connected = true;
    }

    public User getUser(){ return user; }
    public boolean isConnected(){ return connected; }
}
