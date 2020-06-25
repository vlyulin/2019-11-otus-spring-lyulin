package ru.otus.spring.libraryspringwebflux.controllers;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.thymeleaf.spring5.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.spring.libraryspringwebflux.models.Book;
import ru.otus.spring.libraryspringwebflux.models.LookupValue;
import ru.otus.spring.libraryspringwebflux.repositories.BooksRepository;
import ru.otus.spring.libraryspringwebflux.repositories.LookupsRepository;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
public class BooksHandler {

    public static final int DATA_STREAM_BUFFER_SIZE_ELEMENTS = 1;
    private BooksRepository booksRepository;
    private LookupsRepository lookupsRepository;

    BooksHandler( BooksRepository booksRepository, LookupsRepository lookupsRepository ) {
        this.booksRepository = booksRepository;
        this.lookupsRepository = lookupsRepository;
    }

    public Mono<ServerResponse> books(final ServerRequest request) {
        IReactiveDataDriverContextVariable reactiveDataDrivenMode =
                new ReactiveDataDriverContextVariable(booksRepository.findAll(), 1);
        final Map<String,Object> model  = Collections.singletonMap("books", reactiveDataDrivenMode);
        return ServerResponse.ok().render("books", model);
    }

    public Mono<ServerResponse> search(final ServerRequest request) {

        // https://www.geekmj.org/spring-webflux-functional-html-form
        // Это лучше
        // https://stackoverflow.com/questions/52981183/submit-html-form-data-to-webflux-handlerfunction
        return request.formData()
                .flatMap( formData -> {
                    String bookName = formData.getFirst("bookName");
                    bookName = (bookName.isEmpty() || bookName.isBlank())?"-1":bookName;
                    String genreMeaning = formData.getFirst("genreMeaning");
                    genreMeaning = (genreMeaning.isEmpty() || genreMeaning.isBlank())?"-1":genreMeaning;
                    String authorName = formData.getFirst("authorName");
                    authorName = (authorName.isEmpty() || authorName.isBlank())?"-1":authorName;
                    String publishingHouseName = formData.getFirst("publishingHouseName");
                    publishingHouseName = (publishingHouseName.isEmpty() || publishingHouseName.isBlank())?"-1":publishingHouseName;
                    String publishingYearFrom = formData.getFirst("publishingYearFrom");
                    String publishingYearTo = formData.getFirst("publishingYearTo");
                    String pagesFrom = formData.getFirst("pagesFrom");
                    String pagesTo = formData.getFirst("pagesTo");

                    int pubYearFrom = (publishingYearFrom.isEmpty() || publishingYearFrom.isBlank())
                            ? -1: Integer.parseInt(publishingYearFrom);
                    int pubYearTo = (publishingYearTo.isEmpty() || publishingYearTo.isBlank())
                            ? -1: Integer.parseInt(publishingYearTo);
                    int pgFrom = (pagesFrom.isEmpty() || pagesFrom.isBlank())
                            ? -1: Integer.parseInt(pagesFrom);
                    int pgTo = (pagesTo.isEmpty() || pagesTo.isBlank())
                            ? -1: Integer.parseInt(pagesTo);

                    if( bookName == "-1"
                            && genreMeaning == "-1"
                            && authorName == "-1"
                            && publishingHouseName == "-1"
                            && pubYearFrom == -1
                            && pubYearTo == -1
                            && pgFrom == -1
                            && pgTo == -1
                    ) {
                        bookName = "";
                    }

                    Flux<Book> bookFlux = booksRepository.getBooks(
                            bookName,
                            genreMeaning,
                            authorName,
                            publishingHouseName,
                            pubYearFrom,
                            pubYearTo,
                            pgFrom,
                            pgTo
                    );

                    IReactiveDataDriverContextVariable reactiveDataDrivenMode =
                            new ReactiveDataDriverContextVariable(bookFlux, DATA_STREAM_BUFFER_SIZE_ELEMENTS);
                    final Map<String,Object> model  = Collections.singletonMap("books", reactiveDataDrivenMode);
                    return ServerResponse.ok().render("books", model);
                });
    }

    public Mono<ServerResponse> edit(final ServerRequest request) {
        String bookIdStr = request.pathVariable("bookId");
        long bookId = (bookIdStr.isEmpty() || bookIdStr.isBlank())?-1:Long.parseLong(bookIdStr);

        IReactiveDataDriverContextVariable bookReactiveDataDrivenMode =
                new ReactiveDataDriverContextVariable(booksRepository.findById(bookId).flux(), 1);

        Flux<LookupValue> lookupValues =
                lookupsRepository.findByLookupTypeAndLanguage(LookupValue.GENRES_LOOKUP_TYPE, LookupValue.US);

        IReactiveDataDriverContextVariable lvReactiveDataDrivenMode =
                new ReactiveDataDriverContextVariable(lookupValues);

        final Map<String,Object> model  = new HashMap<>();
        model.put("book", bookReactiveDataDrivenMode);
        model.put("genres", lookupValues);
        return ServerResponse.ok().render("book", model);
    }

    public Mono<ServerResponse> deleteBook(final ServerRequest request) {

        String bookIdStr = request.pathVariable("bookId");
        long bookId = (bookIdStr.isEmpty() || bookIdStr.isBlank())?-1:Long.parseLong(bookIdStr);

        booksRepository.deleteById(bookId).subscribe();
        return books(request);
    }

    public Mono<ServerResponse> save(final ServerRequest request) {
        // TODO: Большой вопрос, как правильно обрабатывать формы
        return  request.formData().flatMap( formData -> {

            if( formData.getFirst("action").equals("update")) {
                String bookIdStr = formData.getFirst("bookId");
                long bookId = (bookIdStr.isEmpty() || bookIdStr.isBlank()) ? -1 : Long.parseLong(bookIdStr);
                booksRepository.findById(bookId).map(book -> {
                    book.setName(formData.getFirst("name"));
                    // проверки пропустил
                    int publishingYear = Integer.parseInt(formData.getFirst("publishingYear"));
                    System.out.println("Save data: publishingYear = " + publishingYear);
                    book.setPublishingYear(publishingYear);
                    int pages = Integer.parseInt(formData.getFirst("pages"));
                    book.setPages(pages);
                    return book;
                }).flatMap(book -> booksRepository.save(book)).subscribe();
            }
            // TODO: не переходит
//            URI uri = UriComponentsBuilder
//                    .fromUriString("/books")
//                    .build()
//                    // .buildAndExpand(bookIdStr)
//                    .encode()
//                    .toUri();
//            return ServerResponse.temporaryRedirect(uri).build();
            // Удалось сделать переход таким образом.
            return books(request);
        });
    }
}
