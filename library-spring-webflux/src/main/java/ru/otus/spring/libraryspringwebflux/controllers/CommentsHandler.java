package ru.otus.spring.libraryspringwebflux.controllers;

import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.util.UriComponentsBuilder;
import org.thymeleaf.spring5.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Mono;
import ru.otus.spring.libraryspringwebflux.models.Comment;
import ru.otus.spring.libraryspringwebflux.repositories.BookCommentsRepository;
import ru.otus.spring.libraryspringwebflux.services.AppSession;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Component
public class CommentsHandler {

    public static final int DATA_STREAM_BUFFER_SIZE_ELEMENTS = 1;
    private BookCommentsRepository bookCommentsRepository;
    private AppSession appSession;
    private ReactiveMongoTemplate reactiveMongoTemplate;

    CommentsHandler( ReactiveMongoTemplate reactiveMongoTemplate, AppSession appSession, BookCommentsRepository bookCommentsRepository ) {
        this.reactiveMongoTemplate = reactiveMongoTemplate;
        this.appSession = appSession;
        this.bookCommentsRepository = bookCommentsRepository;
    }

    public Mono<ServerResponse> comments(final ServerRequest request) {

        String bookIdStr = request.pathVariable("bookId");
        long bookId = (bookIdStr.isEmpty() || bookIdStr.isBlank())?-1:Long.parseLong(bookIdStr);

        IReactiveDataDriverContextVariable reactiveDataDrivenMode =
                new ReactiveDataDriverContextVariable(bookCommentsRepository.findCommentsByBookId(bookId), 1);

        Map<String,Object> model = new HashMap<>();
        model.put("comments", reactiveDataDrivenMode);
        model.put("bookId", bookId);
        return ServerResponse.ok().render("comments", model);
    }

    public Mono<ServerResponse> deleteComment(final ServerRequest request) {

        String bookIdStr = request.pathVariable("bookId");

        String commentIdStr = request.pathVariable("commentId");
        long commentId = (bookIdStr.isEmpty() || bookIdStr.isBlank()) ? -1 : Long.parseLong(commentIdStr);

        if (commentId == -1) {
            // Пока не умею обрабатывать ошибки
            return ServerResponse.badRequest().build();
        }

        reactiveMongoTemplate.remove(
                Query.query(Criteria.where("_id").is(commentId)),
                Comment.class,
                Comment.COMMENT_COLLECTION_NAME
        ).subscribe();
        // Это не работает.
        // bookCommentsRepository.deleteById(commentId).subscribe();

        // С переадресацией ничего не получилось
        URI uri = UriComponentsBuilder
                .fromUriString("/books/{bookId}/comments")
                .buildAndExpand(bookIdStr)
                .encode()
                .toUri();
        return ServerResponse.temporaryRedirect(uri).build();
    }

    public Mono<ServerResponse> editComment(final ServerRequest request) {

        String bookIdStr = request.pathVariable("bookId");
        String commentIdStr = request.pathVariable("commentId");
        long commentId = (commentIdStr.isEmpty() || commentIdStr.isBlank()) ? -1 : Long.parseLong(commentIdStr);

        // TODO: Через репозиторий искать не желает
        Mono<Comment> foundedComment = bookCommentsRepository.findById(commentId);

        // А вот так ищет
//        Mono<Comment> foundedComment = reactiveMongoTemplate.findOne(
//                Query.query(Criteria.where("_id").is(commentId)),
//                Comment.class,
//                Comment.COMMENT_COLLECTION_NAME
//        );

        // https://stackoverflow.com/questions/59555315/when-trying-to-use-reactive-data-i-am-getting-invalid-property-id-of-bean-clas
        IReactiveDataDriverContextVariable reactiveDataDrivenMode =
                new ReactiveDataDriverContextVariable(foundedComment.flux());
        Map<String,Object> model = new HashMap<>();
        model.put("action", "Edit");
        model.put("bookId", bookIdStr);
        model.put("comments", reactiveDataDrivenMode);

        return ServerResponse.ok().render("comment", model);
    }

    public Mono<ServerResponse> saveComment(final ServerRequest request) {

        return  request.formData().flatMap( formData -> {
                    String bookIdStr = request.pathVariable("bookId");
                    String commentIdStr = request.pathVariable("commentId");
                    long commentId = (commentIdStr.isEmpty() || commentIdStr.isBlank()) ? -1 : Long.parseLong(commentIdStr);
                    String text = formData.getFirst("commentText");

                    if (commentId == -1) {
                        bookCommentsRepository.addBookComment(Long.parseLong(bookIdStr), text).subscribe();
                    } else {
                        bookCommentsRepository.updateBookComment(commentId, text).subscribe();
                    }

                    URI uri = UriComponentsBuilder
                                    .fromUriString("/books/{bookId}/comments")
                                    .buildAndExpand(bookIdStr)
                                    .encode()
                                    .toUri();
                    return ServerResponse.temporaryRedirect(uri).build();
                });
    }

    public Mono<ServerResponse> newComment(final ServerRequest request) {
        return request.formData()
                .flatMap( formData -> {
                    String bookIdStr = formData.getFirst("bookId");

                    Comment comment = new Comment();
                    comment.setId(-1);

                    IReactiveDataDriverContextVariable reactiveDataDrivenMode =
                            new ReactiveDataDriverContextVariable(Mono.just(comment).flux());

                    Map<String, Object> model = new HashMap<>();
                    model.put("action", "New");
                    model.put("bookId", bookIdStr);
                    model.put("comments", reactiveDataDrivenMode);
                    return ServerResponse.ok().render("comment", model);
                });
    }
}
