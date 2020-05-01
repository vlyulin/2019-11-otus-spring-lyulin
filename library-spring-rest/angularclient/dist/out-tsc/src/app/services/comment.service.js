import { __decorate } from "tslib";
import { Injectable } from '@angular/core';
import { HttpParams } from '@angular/common/http';
let CommentService = class CommentService {
    constructor(http) {
        this.http = http;
        this.commentsUrl = 'http://localhost:8080/bookComments';
        this.getCommentUrl = 'http://localhost:8080/bookComment/';
        this.saveCommentUrl = 'http://localhost:8080/saveBookComment';
        this.deleteCommentUrl = 'http://localhost:8080/deleteBookComment/';
    }
    getBookComments(bookId) {
        let params = new HttpParams()
            .set('bookId', bookId.toString());
        console.log(params.toString());
        return this.http.get(this.commentsUrl, { params });
    }
    getComment(commentId) {
        const url = this.getCommentUrl + commentId;
        return this.http.get(url);
    }
    saveComment(comment) {
        console.warn("saveCommentUrl: " + this.saveCommentUrl);
        this.http.put(this.saveCommentUrl, comment)
            .subscribe(val => {
            console.log("PUT call successful value returned in body", val);
        }, response => {
            console.log("PUT call in error", response);
        }, () => {
            console.log("The PUT observable is now completed.");
        });
    }
    deleteComment(commentId) {
        const url = this.deleteCommentUrl + commentId;
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
CommentService = __decorate([
    Injectable({
        providedIn: 'root'
    })
], CommentService);
export { CommentService };
//# sourceMappingURL=comment.service.js.map