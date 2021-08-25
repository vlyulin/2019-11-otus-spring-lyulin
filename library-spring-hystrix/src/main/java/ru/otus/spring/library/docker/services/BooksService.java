package ru.otus.spring.library.docker.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import ru.otus.spring.library.docker.models.Author;
import ru.otus.spring.library.docker.models.Book;
import ru.otus.spring.library.docker.models.LookupValue;
import ru.otus.spring.library.docker.models.PublishingHouse;
import ru.otus.spring.library.docker.repositories.BooksRepository;

import java.util.Collections;
import java.util.List;

@Service
public class BooksService {

    private BooksRepository booksRepository;
    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @HystrixCommand(fallbackMethod="reserveBookList", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public List<Book> findAll() {
        return booksRepository.findAll();
    }

    // Резервный список книг
    public List<Book> reserveBookList() {
        Author author = new Author();
        author.setName("Васисуалий Лоханкин");
        PublishingHouse publishingHouse = new PublishingHouse();
        publishingHouse.setName("Самиздат.");
        LookupValue genre = new LookupValue();
        genre.setMeaning("Запрещенная литература");
        Book book = new Book(100L,"Кухонные разговоры или кто виноват.",
                2020,790, genre, author, publishingHouse,"18+");
        return Collections.singletonList(book);
    }
}
