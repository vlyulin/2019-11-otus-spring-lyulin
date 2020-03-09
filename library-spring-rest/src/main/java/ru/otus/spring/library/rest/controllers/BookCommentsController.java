package ru.otus.spring.library.rest.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.otus.spring.library.rest.models.Comment;
import ru.otus.spring.library.rest.repositories.BookCommentsRepository;
import ru.otus.spring.library.rest.repositories.UserRepository;
import ru.otus.spring.library.rest.services.AppSession;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RestController
public class BookCommentsController {

    private final AppSession appSession;
    private final BookCommentsRepository bookCommentsRepository;
    private final UserRepository userRepository;

    public BookCommentsController(AppSession appSession, BookCommentsRepository bookCommentsRepository, UserRepository userRepository) {
        this.appSession = appSession;
        this.bookCommentsRepository = bookCommentsRepository;
        this.userRepository = userRepository;
    }

    // @CrossOrigin
    @RequestMapping(value = "/bookComments", method={RequestMethod.GET})
    @ResponseBody
    public List<Comment> getBookComments(
            @RequestParam(name = "bookId") long bookId
    ) {
        return bookCommentsRepository.findByBookId(bookId);
    }

    @RequestMapping(value = "/bookComment/{commentId}", method={RequestMethod.GET})
    @ResponseBody
    public Comment getComment(@PathVariable("commentId") long commentId) {
        return bookCommentsRepository.findById(commentId).get();
    }

    @RequestMapping(value = "/saveBookComment", method = {RequestMethod.POST,RequestMethod.PUT, RequestMethod.PATCH}, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody void saveBookComment(@RequestBody Comment comment) {
        System.out.println("saveBookComment: comment.comment = " + comment.getComment());
        System.out.println("saveBookComment: appSession.getUser() = " + appSession.getUser());

        // User user = new User(hashCode(), "User 003", "1234566", "User 003");
        // comment.setCreatedBy(appSession.getUser());
        // comment.setCreationDate(LocalDate.now());
        // System.out.println("saveBookComment: comment.getCreatedBy().getName() = " + comment.getCreatedBy().getName());

        // TODO: Очистить
        if( comment.getCreatedBy() == null || comment.getCreatedBy().getId() == 0 ) {
            // Указываем кто создал запись
            System.out.println("Указываем кто создал запись");
            comment.setCreatedBy(appSession.getUser());
            comment.setCreationDate(LocalDate.now());
            // TODO: HHH000437: Attempting to save one or more entities that have a non-nullable association ...
            userRepository.save(comment.getCreatedBy());
        } else {
            // Указываем кто изменил запись
            System.out.println("comment.getCreatedBy().getId() = " + comment.getCreatedBy().getId());
            System.out.println("Указываем кто изменил запись");
            comment.setCreatedBy(appSession.getUser());
            comment.setCreationDate(LocalDate.now());
            comment.setLastUpdatedBy(appSession.getUser());
            comment.setLastUpdateDate(LocalDate.now());
            // TODO: HHH000437: Attempting to save one or more entities that have a non-nullable association ...
            System.out.println("saveBookComment:comment.getCreatedBy: " + comment.getCreatedBy());
            System.out.println("saveBookComment:comment.getLastUpdatedBy: " + comment.getLastUpdatedBy());
            // 
            userRepository.save(comment.getCreatedBy());
            userRepository.save(comment.getLastUpdatedBy());
        }
        System.out.println("saveBookComment:comment.getCreatedBy: " + comment.getCreatedBy());
        System.out.println("saveBookComment:comment.getLastUpdatedBy: " + comment.getLastUpdatedBy());
        bookCommentsRepository.save(comment);
    }

    @RequestMapping(value = "/deleteBookComment/{commentId}", method = {RequestMethod.DELETE})
    public @ResponseBody void deleteBookComment(@PathVariable("commentId") long commentId) {
        bookCommentsRepository.deleteById(commentId);
    }
}
