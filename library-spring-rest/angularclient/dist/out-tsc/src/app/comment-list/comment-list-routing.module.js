import { __decorate } from "tslib";
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommentListComponent } from './comment-list.component';
import { CommentDetailComponent } from './comment-detail/comment-detail.component';
// https://stackblitz.com/angular/oyybmeleexvo?file=src%2Fapp%2Fcrisis-center%2Fcrisis-center-routing.module.ts
// https://angular-2-training-book.rangle.io/routing/child_routes
// С ресолвером для редактирования на одной и той же странице не получилось
// resolve: {
//   comment: CommentDetailResolverService
// }
const commentListRoutes = [
    { path: '', component: CommentListComponent },
    { path: 'comment/:commentId', component: CommentDetailComponent }
];
let CommentListRoutingModule = class CommentListRoutingModule {
};
CommentListRoutingModule = __decorate([
    NgModule({
        imports: [
            RouterModule.forChild(commentListRoutes)
        ],
        exports: [
            RouterModule
        ]
    })
], CommentListRoutingModule);
export { CommentListRoutingModule };
//# sourceMappingURL=comment-list-routing.module.js.map