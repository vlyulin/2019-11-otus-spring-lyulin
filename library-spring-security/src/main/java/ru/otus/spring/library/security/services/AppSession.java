package ru.otus.spring.library.security.services;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import ru.otus.spring.library.security.config.Settings;
import ru.otus.spring.library.security.models.User;
import ru.otus.spring.library.security.repositories.UserRepository;

import static org.springframework.security.core.context.SecurityContextHolder.getContext;

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

    public User getUser() {
        Authentication authentication = getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentLogin = authentication.getName();
            User user = userRepository.findByLoginIgnoreCase(currentLogin);
            return user;
        }
        return null;
    }
}
