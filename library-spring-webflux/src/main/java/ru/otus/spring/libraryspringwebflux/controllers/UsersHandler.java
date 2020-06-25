package ru.otus.spring.libraryspringwebflux.controllers;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.thymeleaf.spring5.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Mono;
import ru.otus.spring.libraryspringwebflux.repositories.UserRepository;

import java.util.Collections;
import java.util.Map;

@Component
public class UsersHandler {

    private UserRepository userRepository;

    UsersHandler( UserRepository userRepository ) {
        this.userRepository = userRepository;
    }

    public Mono<ServerResponse> users(final ServerRequest request) {
        IReactiveDataDriverContextVariable reactiveDataDrivenMode =
                new ReactiveDataDriverContextVariable(userRepository.findAll(), 1);
        final Map<String,Object> model  = Collections.singletonMap("users", reactiveDataDrivenMode);
        return ServerResponse.ok().render("users", model); // .contentType(MediaType.TEXT_HTML)
    }
}
