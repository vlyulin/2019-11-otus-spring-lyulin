import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Comment } from '../models/comment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  private commentsUrl: string;
  private getCommentUrl: string;
  private saveCommentUrl: string;
  private deleteCommentUrl: string;

  constructor(private http: HttpClient) {
    this.commentsUrl = 'http://localhost:8080/bookComments';
    this.getCommentUrl = 'http://localhost:8080/bookComment/';
    this.saveCommentUrl = 'http://localhost:8080/saveBookComment';
    this.deleteCommentUrl = 'http://localhost:8080/deleteBookComment/';
  }

  public getBookComments( bookId : number | string ) : Observable<Comment[]> {

    let params = new HttpParams()
              .set('bookId', bookId.toString());

    console.log(params.toString());

    return this.http.get<Comment[]> (
                this.commentsUrl,
                {params}
           );
  }

  public getComment( commentId : number | string ) : Observable<Comment> {
    const url = this.getCommentUrl + commentId;
    return this.http.get<Comment>(url);
  }

  public saveComment(comment : Comment) : void {
      console.warn("saveCommentUrl: " + this.saveCommentUrl);
      this.http.put(this.saveCommentUrl, comment)
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

    public deleteComment( commentId : number | string ) : void {
        const url = this.deleteCommentUrl + commentId;
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
