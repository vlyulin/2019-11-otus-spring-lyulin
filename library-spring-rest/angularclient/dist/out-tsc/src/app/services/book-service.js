import { __decorate } from "tslib";
import { Injectable } from '@angular/core';
let BookService = class BookService {
    constructor(http) {
        this.http = http;
        this.booksUrl = 'http://localhost:8080/advancedBookSearch';
        this.getBookUrl = 'http://localhost:8080/book/';
        this.saveBookUrl = 'http://localhost:8080/saveBook';
        this.deleteBookUrl = 'http://localhost:8080/deleteBook/';
    }
    getBooks(bookName, genreMeaning, authorName, publishingHouseName, publishingYearFrom, publishingYearTo, pagesFrom, pagesTo) {
        console.warn("BookService.getBooks: " + bookName);
        return this.http.post(this.booksUrl, { bookName, genreMeaning, authorName, publishingHouseName,
            publishingYearFrom, publishingYearTo,
            pagesFrom, pagesTo
        });
    }
    getBook(bookId) {
        // https://angular.io/tutorial/toh-pt6
        const url = this.getBookUrl + bookId;
        return this.http.get(url);
    }
    saveBook(book) {
        console.warn("saveBookUrl: " + this.saveBookUrl);
        console.warn("saveBook: book.pages = " + book.pages);
        console.warn("saveBook: book.genre = " + book.genre.meaning);
        this.http.put(this.saveBookUrl, book)
            .subscribe(val => {
            console.log("PUT call successful value returned in body", val);
        }, response => {
            console.log("PUT call in error", response);
        }, () => {
            console.log("The PUT observable is now completed.");
        });
    }
    deleteBook(bookId) {
        const url = this.deleteBookUrl + bookId;
        console.warn("BookService: " + url);
        this.http.delete(url)
            .subscribe(val => {
            console.log("DELETE call successful value returned in body", val);
        }, response => {
            console.log("DELETE call in error", response);
        }, () => {
            console.log("The DELETE observable is now completed.");
        });
    }
};
BookService = __decorate([
    Injectable({
        providedIn: 'root'
    })
], BookService);
export { BookService };
//# sourceMappingURL=book-service.js.map