import { __decorate } from "tslib";
import { Injectable } from '@angular/core';
import { of, EMPTY } from 'rxjs';
import { mergeMap, take } from 'rxjs/operators';
// Это была попытка сделать редактирование на одной и той же странице со списком комментариев,
// но не получилось
// Файл выкидывать жалко
let CommentDetailResolverService = class CommentDetailResolverService {
    constructor(cs, router) {
        this.cs = cs;
        this.router = router;
    }
    resolve(route, state) {
        let commentId = route.paramMap.get('commentId');
        console.warn('Resolver commentId = ' + commentId);
        if (commentId == 'null') {
            console.warn('Resolver commentId == null');
            return EMPTY;
        }
        return this.cs.getComment(commentId).pipe(take(1), mergeMap(comment => {
            if (comment) {
                return of(comment);
            }
            else {
                this.router.navigate(['']);
                return EMPTY;
            }
        }));
    }
};
CommentDetailResolverService = __decorate([
    Injectable({
        providedIn: 'root',
    })
], CommentDetailResolverService);
export { CommentDetailResolverService };
//# sourceMappingURL=comment-detail-resolver.service.js.map