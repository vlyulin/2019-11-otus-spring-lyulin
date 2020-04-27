package ru.otus.spring.library.rest.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.otus.spring.library.rest.models.Book;
import ru.otus.spring.library.rest.models.LookupValueId;
import ru.otus.spring.library.rest.repositories.BooksRepository;
import ru.otus.spring.library.rest.repositories.LookupsRepository;

import java.util.List;

// https://spring.io/blog/2015/06/08/cors-support-in-spring-framework
@CrossOrigin
@RestController
public class BooksController {

    private final BooksRepository booksRepository;
    private final LookupsRepository lookupsRepository;

    public BooksController(BooksRepository booksRepository,/*, Logger logger*/LookupsRepository lookupsRepository) {
        this.booksRepository = booksRepository;
        this.lookupsRepository = lookupsRepository;
    }

    // Params: https://www.baeldung.com/spring-requestmapping
    @GetMapping("/books")
    public List<Book> getBooks() {
        return booksRepository.findAll();
    }

    @RequestMapping(value = "/advancedBookSearch", method=RequestMethod.POST)
    @ResponseBody
    public List<Book> getBooks(
            @RequestBody AdvancedBookSeachRequest req
    ) {

        System.out.println("bookName = [" + req.getBookName() + "]");
        System.out.println("genreMeaning = [" + req.getGenreMeaning() + "]");
        System.out.println("authorName = [" + req.getAuthorName() + "]");
        System.out.println("publishingHouseName = [" + req.getPublishingHouseName() + "]");
        System.out.println("publishingYearFrom = " + req.getPublishingYearFrom());
        System.out.println("publishingYearTo = " + req.getPublishingYearTo());
        System.out.println("pagesFrom = " + req.getPagesFrom());
        System.out.println("pagesTo = " + req.getPagesTo());

        return booksRepository.getBooks(
                req.getBookName(),
                req.getGenreMeaning(),
                req.getAuthorName(),
                req.getPublishingHouseName(),
                req.getPublishingYearFrom(),
                req.getPublishingYearTo(),
                req.getPagesFrom(),
                req.getPagesTo()
        );
    }

    @RequestMapping(value = "/book/{bookId}", method={RequestMethod.GET})
    @ResponseBody
    public Book getBook(@PathVariable("bookId") long bookId) {
        // It's because the getOne(), returns a reference.
        // https://stackoverflow.com/questions/52656517/no-serializer-found-for-class-org-hibernate-proxy-pojo-bytebuddy-bytebuddyinterc
        return booksRepository.findById(bookId).get();
    }

    @RequestMapping(value = "/saveBook", method = {RequestMethod.POST,RequestMethod.PUT, RequestMethod.PATCH}, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody void saveBook(@RequestBody Book book) {
        List<LookupValueId> keys = lookupsRepository.findByMeaningAndKeyLanguage(book.getGenre().getMeaning(), "RU");
        book.getGenre().setKey(keys.get(0));
        booksRepository.save(book);
    }

    @RequestMapping(value = "/deleteBook/{bookId}", method={RequestMethod.DELETE})
    @ResponseBody
    public void deleteBook(@PathVariable("bookId") long bookId) {
        booksRepository.deleteById(bookId);
    }
}
