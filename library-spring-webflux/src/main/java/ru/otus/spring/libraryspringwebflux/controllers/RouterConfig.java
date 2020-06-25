package ru.otus.spring.libraryspringwebflux.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import ru.otus.spring.libraryspringwebflux.repositories.BookCommentsRepository;
import ru.otus.spring.libraryspringwebflux.repositories.BooksRepository;
import ru.otus.spring.libraryspringwebflux.repositories.LookupsRepository;
import ru.otus.spring.libraryspringwebflux.repositories.UserRepository;
import ru.otus.spring.libraryspringwebflux.services.AppSession;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class RouterConfig {

    private final AppSession appSession;
    private final UserRepository userRepository;
    private final BooksRepository booksRepository;
    private final BookCommentsRepository bookCommentsRepository;
    private final LookupsRepository lookupsRepository;
    private final ReactiveMongoTemplate reactiveMongoTemplate; // TODO: Пока без этого обойти не получилось

    public RouterConfig(AppSession appSession, UserRepository userRepository, BooksRepository booksRepository, BookCommentsRepository bookCommentsRepository, LookupsRepository lookupsRepository, ReactiveMongoTemplate reactiveMongoTemplate) {
        this.appSession = appSession;
        this.userRepository = userRepository;
        this.booksRepository = booksRepository;
        this.bookCommentsRepository = bookCommentsRepository;
        this.lookupsRepository = lookupsRepository;
        this.reactiveMongoTemplate = reactiveMongoTemplate;
    }

    @Bean
    public RouterFunction<ServerResponse> composedRoutes() {

        UsersHandler usersHandler = new UsersHandler(userRepository);
        BooksHandler booksHandler = new BooksHandler(booksRepository, lookupsRepository);
        CommentsHandler commentsHandler = new CommentsHandler(reactiveMongoTemplate, appSession, bookCommentsRepository);

        return RouterFunctions
                .route(GET("/users"), usersHandler::users)
                .and(route(GET("/books"), booksHandler::books))
                .and(route(GET("/"), request -> ok().render("index")))
                .and(route(POST("/books/search"), booksHandler::search))
                .and(route(GET("/books/{bookId}/comments"), commentsHandler::comments))
                .and(route(GET("/deleteBook/{bookId}"), booksHandler::deleteBook))
                .and(route(GET("/books/{bookId}/comment/{commentId}/delete"), commentsHandler::deleteComment))
                .and(route(GET("/books/{bookId}/comment/{commentId}/edit"), commentsHandler::editComment))
                .and(route(POST("/books/{bookId}/comment/{commentId}/save"), commentsHandler::saveComment))
                .and(route(GET("/books/{bookId}/comment/new"), commentsHandler::newComment))
                .and(route(GET("/books/edit/{bookId}"), booksHandler::edit))
                .and(route(POST("/books/save"), booksHandler::save));
    }
}
