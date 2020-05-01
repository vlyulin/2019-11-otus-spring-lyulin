import { __decorate } from "tslib";
import { Component } from '@angular/core';
import { EMPTY } from 'rxjs';
import { switchMap } from 'rxjs/operators';
import { User } from '../models/user';
let CommentListComponent = class CommentListComponent {
    // https://www.tektutorialshub.com/angular/angular-pass-url-parameters-query-strings/
    constructor(route, commentService, router) {
        this.route = route;
        this.commentService = commentService;
        this.router = router;
        this.commentPath = 'comment/';
    }
    ngOnInit() {
        // Получение параметра
        // https://stackoverflow.com/questions/40275862/how-to-get-parameter-on-angular2-route-in-angular-way
        this.comments$ = this.route.paramMap.pipe(switchMap((params) => {
            let bookId = +params.get('bookId');
            console.warn('this.bookId = ' + bookId);
            if (bookId != -1) {
                return this.commentService.getBookComments(bookId);
            }
            else {
                return EMPTY;
            }
        }));
        this.comments$.subscribe(data => {
            this.comments = data;
            // Если comment.lastUpdatedBy пустой, то ломался template (html)
            this.comments.forEach(function (comment) {
                if (comment.lastUpdatedBy == null) {
                    comment.lastUpdatedBy = new User();
                }
            });
        });
    }
    goBack() {
        this.router.navigate(['advancedBookSearch']);
    }
    deleteComment(commentId) {
        if (commentId) {
            this.commentService.deleteComment(commentId);
            // TODO: Refresh comment list
            let bookId = this.route.snapshot.paramMap.get('bookId');
            console.warn('deleteComment bookId = ' + bookId);
            this.router.navigate(['bookComments', bookId]);
        }
    }
};
CommentListComponent = __decorate([
    Component({
        selector: 'app-comment-list',
        templateUrl: './comment-list.component.html',
        styleUrls: ['./comment-list.component.css']
    })
], CommentListComponent);
export { CommentListComponent };
//# sourceMappingURL=comment-list.component.js.map