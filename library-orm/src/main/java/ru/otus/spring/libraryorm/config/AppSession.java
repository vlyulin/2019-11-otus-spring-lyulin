package ru.otus.spring.libraryorm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.otus.spring.libraryorm.models.User;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/*
* Сессия приложения. Содержит авторизовавшегося пользователя.
* Пока указывается в свойствах.
* */
@Component
public class AppSession {

    @PersistenceContext
    private EntityManager em;
    // TODO: Как бы избавиться от атрибута login? Он нужен только для получения свойства из properties.
    // В @PostConstruct в качестве параметра добавлять нельзя.
    @Value("${appsession.user:User01}")
    String login;
    private User user;

    @PostConstruct
    private void postConstruct() {
        // TODO: Как вывести сообщение об ошибке, что пользователь не найден и еще с учетом языка?
        // Как правильно обрабатывать ошибки возникающие при инициализации Spring контекста?
        TypedQuery<User> query = em.createQuery(
                "select u from User u where UPPER(u.login) = UPPER(:login)", User.class);
        query.setParameter("login",login);
        this.user = query.getSingleResult();
    }

    public User getUser(){ return user; }
}
