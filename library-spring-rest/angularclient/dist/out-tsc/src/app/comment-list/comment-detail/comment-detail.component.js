import { __decorate } from "tslib";
import { Component } from '@angular/core';
import { EMPTY } from 'rxjs';
import { switchMap } from 'rxjs/operators';
import { Comment } from '../../models/comment';
import { User } from '../../models/user';
let CommentDetailComponent = class CommentDetailComponent {
    constructor(route, router, commentService, location) {
        this.route = route;
        this.router = router;
        this.commentService = commentService;
        this.location = location;
    }
    ngOnInit() {
        // Получение параметра
        // https://stackoverflow.com/questions/40275862/how-to-get-parameter-on-angular2-route-in-angular-way
        this.route.paramMap.pipe(switchMap((params) => {
            let commentId = params.get('commentId');
            if (commentId != '-1') {
                return this.commentService.getComment(commentId);
            }
            else {
                return EMPTY;
            }
        })).subscribe(cmt => {
            console.warn("comment.comment = " + cmt.comment);
            this.comment = cmt;
            this.editCommentText = cmt.comment;
        });
    }
    onSubmit(f) {
        let bookId = this.route.snapshot.paramMap.get('bookId');
        let commentId = this.route.snapshot.paramMap.get('commentId');
        console.warn("On Save commit bookId = " + bookId + " commentId = " + commentId);
        if (commentId == '-1') {
            this.comment = new Comment();
            this.comment.bookId = +bookId;
            this.comment.createdBy = new User();
        }
        if (this.comment.comment != this.editCommentText) {
            console.warn("Comment changed. Saving...");
            this.comment.comment = this.editCommentText;
            this.commentService.saveComment(this.comment);
        }
        this.router.navigate(['bookComments', bookId]);
    }
    cancel() {
        let bookId = this.route.snapshot.paramMap.get('bookId');
        this.router.navigate(['bookComments', bookId]);
    }
    deleteComment(commentId) {
        console.warn('deleteComment: commentId = ' + commentId);
        this.commentService.deleteComment(commentId);
    }
};
CommentDetailComponent = __decorate([
    Component({
        selector: 'app-comment-detail',
        templateUrl: './comment-detail.component.html',
        styleUrls: ['./comment-detail.component.css']
    })
], CommentDetailComponent);
export { CommentDetailComponent };
//# sourceMappingURL=comment-detail.component.js.map