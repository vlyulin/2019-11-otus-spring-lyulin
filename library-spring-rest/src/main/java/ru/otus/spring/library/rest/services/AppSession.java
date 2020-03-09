package ru.otus.spring.library.rest.services;

import org.springframework.stereotype.Component;
import ru.otus.spring.library.rest.config.Settings;
import ru.otus.spring.library.rest.models.User;
import ru.otus.spring.library.rest.repositories.UserRepository;

/*
* Сессия приложения. Содержит авторизовавшегося пользователя.
* Пока указывается в свойствах.
* */
@Component
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
        this.user = userRepository.findByLoginIgnoreCase(settings.getLogin());
        connected = true;
    }

    public User getUser(){ return user; }
    public boolean isConnected(){ return connected; }
    Settings getSettings(){ return this.settings; }
}
