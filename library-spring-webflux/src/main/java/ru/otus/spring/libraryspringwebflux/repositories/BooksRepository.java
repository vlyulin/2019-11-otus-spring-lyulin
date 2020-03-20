package ru.otus.spring.libraryspringwebflux.repositories;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.Param;
import reactor.core.publisher.Flux;
import ru.otus.spring.libraryspringwebflux.models.Book;

public interface BooksRepository extends ReactiveMongoRepository<Book, Long> {
    @Query("{ $or: [" +
                "{'name': {'$regex': :#{#bookName}, $options: 'i'} } " +
                "{'genre.meaning': {'$regex': :#{#genreMeaning}, $options: 'i'} }" +
                "{'author.name': {'$regex': :#{#authorName}, $options: 'i'} }" +
                "{'publishingHouse.name': {'$regex': :#{#publishingHouseName}, $options: 'i'} }" +
                "{'publishingYear': {$gte: :#{#publishingYearFrom}, $lte: :#{#publishingYearTo}}} " +
                "{'pages': {$gte: :#{#pagesFrom}, $lte: :#{#pagesTo}}}" +
            "] }"
    )
    Flux<Book> getBooks(
            @Param("bookName") String bookName,
            @Param("genreMeaning") String genreMeaning,
            @Param("authorName") String authorName,
            @Param("publishingHouseName") String publishingHouseName,
            @Param("publishingYearFrom") int publishingYearFrom,
            @Param("publishingYearTo") int publishingYearTo,
            @Param("pagesFrom") int pagesFrom,
            @Param("pagesTo") int pagesTo
    );
}
