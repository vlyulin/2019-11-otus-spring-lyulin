package ru.otus.spring.library.security.services;

import org.springframework.stereotype.Component;
import ru.otus.spring.library.security.config.Settings;
import ru.otus.spring.library.security.models.User;
import ru.otus.spring.library.security.repositories.UserRepository;

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

    public void openSession(String login) {
        if (login.isBlank() || login.isEmpty() ) return;
        this.user = userRepository.findByLoginIgnoreCase(login);
        System.out.println("openSession: user " + user.getId());
        this.connected = true;
    }

    public void closeSession() {
        this.connected = false;
        this.user = null;
    }

    public User getUser(){ return user; }
    public boolean isConnected(){ return connected; }
    Settings getSettings(){ return this.settings; }
}
