package ru.otus.spring.library.rest.controllers;

// import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.otus.spring.library.rest.models.Book;
import ru.otus.spring.library.rest.models.LookupValue;
import ru.otus.spring.library.rest.models.LookupValueId;
import ru.otus.spring.library.rest.repositories.BooksRepository;
import ru.otus.spring.library.rest.repositories.LookupsRepository;

import java.util.List;
//import java.util.logging.Logger;

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

    // https://avaldes.com/implementing-basic-and-advanced-search-using-angular-material-design-grid-ui-spring-mvc-rest-api-and-mongodb-example/
//    @RequestMapping(value = "/advancedBookSearch", method={RequestMethod.GET, RequestMethod.POST})
//    @ResponseBody
//    public List<Book> getBooks(
//            @RequestParam(name = "bookName") String bookName,
//            @RequestParam(name = "genreMeaning") String genreMeaning,
//            @RequestParam(name = "authorName") String authorName,
//            @RequestParam(name = "publishingHouseName") String publishingHouseName,
//            @RequestParam(name = "publishingYearFrom", defaultValue = "-1") int publishingYearFrom,
//            @RequestParam(name = "publishingYearTo", defaultValue = "-1") int publishingYearTo,
//            @RequestParam(name = "pagesFrom", defaultValue = "-1") int pagesFrom,
//            @RequestParam(name = "pagesTo", defaultValue = "-1") int pagesTo
//    ) {
//
//        logger.info("bookName = [" + bookName + "]");
//        logger.info("genreMeaning = [" + genreMeaning + "]");
//        logger.info("authorName = [" + authorName + "]");
//        logger.info("publishingHouseName = [" + publishingHouseName + "]");
//        logger.info("publishingYearFrom = " + publishingYearFrom);
//        logger.info("publishingYearTo = " + publishingYearTo);
//        logger.info("pagesFrom = " + pagesFrom);
//        logger.info("pagesTo = " + pagesTo);
//
//        return booksRepository.getBooks(
//                bookName,
//                genreMeaning,
//                authorName,
//                publishingHouseName,
//                publishingYearFrom,
//                publishingYearTo,
//                pagesFrom,
//                pagesTo
//        );
//    }

    @RequestMapping(value = "/advancedBookSearch", method={RequestMethod.GET, RequestMethod.POST})
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
        System.out.println("saveBook: book.pages = " + book.getPages());
        System.out.println("saveBook: book.genre = " + book.getGenre().getMeaning());

        // Восстановление EmbededId,
        // который на возвращается при запросе книги
        //    {
        //        "id": 1,
        //            "name": "В ядовитом поясе",
        //            "publishingYear": 2010,
        //            "pages": 320,
        //            "genre": {
        //        "key": {}, <-- Пусто !!!
        //        "enabledFlag": "Y",
        //                "startDateActive": "+169108099-07-05",
        //                "endDateActive": "+169104628-12-09",
        //                "meaning": "Твердая научная фантастика",
        //                "description": "Твердая научная фантастика"
        //    ...
        List<LookupValueId> keys = lookupsRepository.findByMeaningAndKeyLanguage(book.getGenre().getMeaning(), "RU");
        // List<LookupValue> lookupValues = lookupsRepository.findByKeyLookupTypeAndKeyLookupCodeAndKeyLanguage(
        //         "GENRES", book.getGenre().getKey().getLookupCode(), "RU");
        for (LookupValueId k: keys) {
            System.out.println("keys: " + k.toString());
        }
        System.out.println("LookupValueId: " + keys.get(0).toString());
        book.getGenre().setKey(keys.get(0));
        booksRepository.save(book);
    }

    @RequestMapping(value = "/deleteBook/{bookId}", method={RequestMethod.DELETE})
    @ResponseBody
    public void deleteBook(@PathVariable("bookId") long bookId) {
        booksRepository.deleteById(bookId);
    }
}
