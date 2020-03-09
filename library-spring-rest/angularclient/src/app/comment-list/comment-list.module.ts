import { NgModule }       from '@angular/core';
import { CommonModule }   from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { CommentListComponent } from './comment-list.component';
import { CommentListRoutingModule } from './comment-list-routing.module';
import { CommentDetailComponent }  from './comment-detail/comment-detail.component';
import { CommentService } from '../services/comment.service';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    CommentListRoutingModule
  ],
  declarations: [
    CommentListComponent,
    CommentDetailComponent
  ],
  providers: [ CommentService ]
})
export class CommentListModule {}

