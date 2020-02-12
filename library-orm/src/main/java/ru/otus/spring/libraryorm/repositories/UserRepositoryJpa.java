package ru.otus.spring.libraryorm.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.libraryorm.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Transactional
@Repository
public class UserRepositoryJpa implements UserRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public User getUser(String login) {
        TypedQuery<User> query = em.createQuery(
                "select u from User u where UPPER(u.login) = UPPER(:login)", User.class);
        query.setParameter("login",login);
        return query.getSingleResult();
    }
}
