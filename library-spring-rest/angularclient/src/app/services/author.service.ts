import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Author } from '../models/author';

@Injectable({
  providedIn: 'root'
})
export class AuthorService {

  private authorsUrl: string;
  private getAuthorUrl: string;

  constructor(private http: HttpClient) {
    this.authorsUrl = 'http://localhost:8080/authors';
    this.getAuthorUrl = 'http://localhost:8080/author/';
  }

  public getAuthors() : Observable<Author[]>
  {
      return this.http.get<Author[]>(this.authorsUrl);
  }

  public getAuthor( authorId : number | string ) : Observable<Author> {
      const url = this.getAuthorUrl + authorId;
      return this.http.get<Author>(url);
  }
}
