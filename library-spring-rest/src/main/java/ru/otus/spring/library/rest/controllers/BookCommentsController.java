package ru.otus.spring.library.rest.controllers;

import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import ru.otus.spring.library.rest.models.Comment;
import ru.otus.spring.library.rest.models.User;
import ru.otus.spring.library.rest.repositories.BookCommentsRepository;
import ru.otus.spring.library.rest.repositories.UserRepository;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RestController
public class BookCommentsController {

    private final BookCommentsRepository bookCommentsRepository;
    private final UserRepository userRepository;

    public BookCommentsController(BookCommentsRepository bookCommentsRepository, UserRepository userRepository) {
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

        User currentUser = null;

        // Получаем текущего залогининого пользователя
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails ) {
            String login = ((UserDetails)principal).getUsername();
            currentUser = userRepository.findByLoginIgnoreCase(login);
        }

        if( comment.getCreatedBy() == null || comment.getCreatedBy().getId() == 0 ) {
            // Указываем кто создал запись
            if(currentUser != null) { comment.setCreatedBy(currentUser); }
            comment.setCreationDate(LocalDate.now());
            // HHH000437: Attempting to save one or more entities that have a non-nullable association ...
            userRepository.save(comment.getCreatedBy());
        } else {
            // Указываем кто изменил запись
            if(currentUser != null) { comment.setLastUpdatedBy(currentUser); }
            comment.setLastUpdateDate(LocalDate.now());
            // HHH000437: Attempting to save one or more entities that have a non-nullable association ...
            userRepository.save(comment.getCreatedBy());
            userRepository.save(comment.getLastUpdatedBy());
        }
        bookCommentsRepository.save(comment);
    }

    @RequestMapping(value = "/deleteBookComment/{commentId}", method = {RequestMethod.DELETE})
    public @ResponseBody void deleteBookComment(@PathVariable("commentId") long commentId) {
        bookCommentsRepository.deleteById(commentId);
    }
}
