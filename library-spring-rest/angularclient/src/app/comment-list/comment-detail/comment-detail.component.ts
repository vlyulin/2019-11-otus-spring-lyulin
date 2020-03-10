import { Component, OnInit } from '@angular/core';
import { HostBinding } from '@angular/core';
import { Router, ActivatedRoute, ParamMap, UrlTree, UrlSegmentGroup, UrlSegment, PRIMARY_OUTLET } from '@angular/router';
import { Observable, EMPTY } from 'rxjs';
import { switchMap } from 'rxjs/operators';
import { Location } from '@angular/common';
import { Comment } from '../../models/comment';
import { User } from '../../models/user';
import { CommentService } from '../../services/comment.service';


@Component({
  selector: 'app-comment-detail',
  templateUrl: './comment-detail.component.html',
  styleUrls: ['./comment-detail.component.css']
})
export class CommentDetailComponent implements OnInit {

  // https://stackblitz.com/angular/oyybmeleexvo?file=src%2Fapp%2Fcrisis-center%2Fcrisis-detail%2Fcrisis-detail.component.ts
  comment: Comment;
  editCommentText: string;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private commentService: CommentService,
    private location: Location
  ) {
  }

  ngOnInit(): void {
    // Получение параметра
    // https://stackoverflow.com/questions/40275862/how-to-get-parameter-on-angular2-route-in-angular-way
    this.route.paramMap.pipe(
                switchMap((params: ParamMap) => {
                      let commentId = params.get('commentId');
                      if (commentId != '-1') {
                        return this.commentService.getComment(commentId);
                      }
                      else {
                        return EMPTY;
                      }
                  }
                )
    ).subscribe( cmt => {
             console.warn("comment.comment = " + cmt.comment);
             this.comment = cmt;
             this.editCommentText = cmt.comment;
    });
  }

  onSubmit(f) : void {
      let bookId = this.route.snapshot.paramMap.get('bookId');
      let commentId = this.route.snapshot.paramMap.get('commentId');
      console.warn("On Save commit bookId = " + bookId + " commentId = " + commentId );

      if (commentId == '-1') {
        this.comment = new Comment();
        this.comment.bookId = +bookId;
        this.comment.createdBy = new User();
      }

      if(this.comment.comment != this.editCommentText) {
        console.warn("Comment changed. Saving...");
        this.comment.comment = this.editCommentText;
        this.commentService.saveComment(this.comment);
      }

      this.router.navigate(['bookComments', bookId])
  }

  cancel() {
      let bookId = this.route.snapshot.paramMap.get('bookId');
      this.router.navigate(['bookComments',bookId]);
  }

  deleteComment( commentId: number ) {
    console.warn('deleteComment: commentId = '+commentId);
    this.commentService.deleteComment(commentId);
  }
}
