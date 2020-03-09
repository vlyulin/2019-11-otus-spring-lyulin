import { Injectable }             from '@angular/core';
import {
  Router, Resolve,
  RouterStateSnapshot,
  ActivatedRouteSnapshot
}                                 from '@angular/router';
import { Observable, of, EMPTY }  from 'rxjs';
import { mergeMap, take }         from 'rxjs/operators';

import { CommentService }  from '../services/comment.service';
import { Comment } from '../models/comment';

@Injectable({
  providedIn: 'root',
})
export class CommentDetailResolverService implements Resolve<Comment> {
  constructor(private cs: CommentService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Comment> | Observable<never> {
    // let bookId = route.paramMap.get('bookId');
    let commentId = route.paramMap.get('commentId');
    // console.warn('Resolver bookId = ' + bookId + ' commentId = ' + commentId);
    console.warn('Resolver commentId = ' + commentId);
    if(commentId == 'null') {
       console.warn('Resolver commentId == null');
       return EMPTY;
    }

    return this.cs.getComment(commentId).pipe(
      take(1),
      mergeMap(comment => {
        if (comment) {
          return of(comment);
        } else { // id not found
          this.router.navigate(['']);
          return EMPTY;
        }
      })
    );
  }
}
