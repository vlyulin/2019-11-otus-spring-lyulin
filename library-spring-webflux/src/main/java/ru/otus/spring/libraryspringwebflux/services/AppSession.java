package ru.otus.spring.libraryspringwebflux.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import ru.otus.spring.libraryspringwebflux.config.Settings;
import ru.otus.spring.libraryspringwebflux.models.User;
import ru.otus.spring.libraryspringwebflux.repositories.UserRepository;

import java.util.List;

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

    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    @Autowired
    private MongoTemplate mongoTemplate;

    public AppSession(Settings settings, UserRepository userRepository) {
        this.settings = settings;
        this.userRepository = userRepository;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public void openSession() {

        userRepository.findByLoginIgnoreCase(settings.getLogin())
                .map( user -> {
                    System.out.println("openSession: user -> " + user );
                    this.user = user;
                    this.connected = true;
                    return Mono.just(user);
                }).subscribe();

        User user = userRepository.findById(101L).block();
        System.out.println("openSession: user 2 -> " + user );
        this.user = user;
        this.connected = true;

        this.user = reactiveMongoTemplate.findById(101L, User.class, User.USERS_COLLECTION_NAME).block();
        this.user = mongoTemplate.findById(101L, User.class, User.USERS_COLLECTION_NAME);
        List<User> users = mongoTemplate.find(Query.query(Criteria.where("login").is("User01")), User.class, User.USERS_COLLECTION_NAME);
    }

    public User getUser(){ return user; }
    public boolean isConnected(){ return connected; }
    Settings getSettings(){ return this.settings; }
}
