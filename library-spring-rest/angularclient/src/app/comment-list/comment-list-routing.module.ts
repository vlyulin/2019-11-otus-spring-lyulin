import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { CommentListComponent } from './comment-list.component';
import { CommentDetailComponent } from './comment-detail/comment-detail.component';
import { CommentDetailResolverService } from './comment-detail-resolver.service';

// https://stackblitz.com/angular/oyybmeleexvo?file=src%2Fapp%2Fcrisis-center%2Fcrisis-center-routing.module.ts
// https://angular-2-training-book.rangle.io/routing/child_routes

// С ресолвером не получилось
// resolve: {
//   comment: CommentDetailResolverService
// }
const commentListRoutes: Routes = [
  { path: '', component: CommentListComponent },
  { path: 'comment/:commentId', component: CommentDetailComponent }
];

@NgModule({
  imports: [
    RouterModule.forChild(commentListRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class CommentListRoutingModule { }
