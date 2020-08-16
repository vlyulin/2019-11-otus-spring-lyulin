import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Book } from '../models/book';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  private booksUrl: string;
  private getBookUrl: string;
  private saveBookUrl: string;
  private deleteBookUrl: string;

  constructor(private http: HttpClient) {
    this.booksUrl = 'http://localhost:8080/advancedBookSearch';
    this.getBookUrl = 'http://localhost:8080/book/';
    this.saveBookUrl = 'http://localhost:8080/saveBook';
    this.deleteBookUrl = 'http://localhost:8080/deleteBook/';
  }

  public getBooks(
            bookName : string,
            genreMeaning : string,
            authorName : string,
            publishingHouseName : string,
            publishingYearFrom : number,
            publishingYearTo : number,
            pagesFrom : number,
            pagesTo : number
        ) : Observable<Book[]>
  {
    console.warn("BookService.getBooks: " + bookName);
    return this.http.post<Book[]> (
            this.booksUrl,
            { bookName, genreMeaning, authorName, publishingHouseName,
              publishingYearFrom, publishingYearTo,
              pagesFrom, pagesTo
            }
      );
  }

  public getBook( bookId : number | string ) : Observable<Book> {
    // https://angular.io/tutorial/toh-pt6
    const url = this.getBookUrl + bookId;
    return this.http.get<Book>(url);
  }

  public saveBook(book : Book) : void {
    console.warn("saveBookUrl: " + this.saveBookUrl);
    console.warn("saveBook: book.pages = " + book.pages);
    console.warn("saveBook: book.genre = " + book.genre.meaning);
    this.http.put(this.saveBookUrl, book)
      .subscribe(
        val => {
          console.log("PUT call successful value returned in body", val);
        },
        response => {
            console.log("PUT call in error", response);
        },
        () => {
            console.log("The PUT observable is now completed.");
        }
      );
  }

  public deleteBook( bookId : number | string ) : void {
          const url = this.deleteBookUrl + bookId;
          console.warn("BookService: " + url);
          this.http.delete(url)
          .subscribe(
                    val => {
                      console.log("DELETE call successful value returned in body", val);
                    },
                    response => {
                        console.log("DELETE call in error", response);
                    },
                    () => {
                        console.log("The DELETE observable is now completed.");
                    }
                  );
        }
}
