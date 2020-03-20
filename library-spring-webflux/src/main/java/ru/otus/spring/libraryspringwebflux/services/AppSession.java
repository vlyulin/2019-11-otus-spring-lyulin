package ru.otus.spring.libraryspringwebflux.services;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import ru.otus.spring.libraryspringwebflux.config.Settings;
import ru.otus.spring.libraryspringwebflux.models.User;
import ru.otus.spring.libraryspringwebflux.repositories.UserRepository;

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
        Mono<User> monoUser = userRepository.findByLoginIgnoreCase(settings.getLogin());
        monoUser.map( user1 -> this.user );
        connected = true;
    }

    public User getUser(){ return user; }
    public boolean isConnected(){ return connected; }
    Settings getSettings(){ return this.settings; }
}
