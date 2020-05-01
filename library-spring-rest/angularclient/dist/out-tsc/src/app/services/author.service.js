import { __decorate } from "tslib";
import { Injectable } from '@angular/core';
let AuthorService = class AuthorService {
    constructor(http) {
        this.http = http;
        this.authorsUrl = 'http://localhost:8080/authors';
        this.getAuthorUrl = 'http://localhost:8080/author/';
    }
    getAuthors() {
        return this.http.get(this.authorsUrl);
    }
    getAuthor(authorId) {
        const url = this.getAuthorUrl + authorId;
        return this.http.get(url);
    }
};
AuthorService = __decorate([
    Injectable({
        providedIn: 'root'
    })
], AuthorService);
export { AuthorService };
//# sourceMappingURL=author.service.js.map