import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { Observable, EMPTY } from 'rxjs';
import { switchMap } from 'rxjs/operators';
import { Comment } from '../models/comment';
import { CommentService } from '../services/comment.service';
import { User } from '../models/user';

@Component({
  selector: 'app-comment-list',
  templateUrl: './comment-list.component.html',
  styleUrls: ['./comment-list.component.css']
})
export class CommentListComponent implements OnInit {

  bookId : string;
  // https://stackoverflow.com/questions/49619943/angular-rxjs-switchmap-producing-error/49620211
  // https://stackoverflow.com/questions/49619943/angular-rxjs-switchmap-producing-error/49620211
  comments$: Observable<Comment[]>;
  comments : Comment[];
  selectedBookId: number;
  selectedCommentId: number;
  commentPath: string = 'comment/';

  // https://www.tektutorialshub.com/angular/angular-pass-url-parameters-query-strings/
  constructor( private route: ActivatedRoute,
               private commentService : CommentService,
               private router: Router
  ) {
  }

  ngOnInit() {
    // Получение параметра
    // https://stackoverflow.com/questions/40275862/how-to-get-parameter-on-angular2-route-in-angular-way
    this.comments$ = this.route.paramMap.pipe(
            switchMap((params: ParamMap) => {
                let bookId = +params.get('bookId');
                console.warn('this.bookId = '+bookId);
                if (bookId != -1) {
                  return this.commentService.getBookComments(bookId);
                }
                else {
                  return EMPTY;
                }
            })
        );

    this.comments$.subscribe( data => {
      this.comments = data;
      // Если comment.lastUpdatedBy пустой, то ломался template (html)
      this.comments.forEach(
      function(comment) {
        if( comment.lastUpdatedBy == null ) {
            comment.lastUpdatedBy = new User();
        }
      });
    });
  }

  goBack() {
    this.router.navigate(['advancedBookSearch']);
  }

  deleteComment( commentId : number | string ) {
    if( commentId ) {
      this.commentService.deleteComment( commentId );
      // TODO: Refresh comment list
      let bookId = this.route.snapshot.paramMap.get('bookId');
      console.warn('deleteComment bookId = '+bookId);
      location.reload(true); // Проверил, так лучше. Страница рефрешится.
      // this.router.navigate(['bookComments',bookId]);
    }
  }
}
