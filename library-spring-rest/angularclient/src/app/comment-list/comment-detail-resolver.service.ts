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

// Это была попытка сделать редактирование на одной и той же странице со списком комментариев,
// но не получилось
// Файл выкидывать жалко
@Injectable({
  providedIn: 'root',
})
export class CommentDetailResolverService implements Resolve<Comment> {
  constructor(private cs: CommentService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Comment> | Observable<never> {
    let commentId = route.paramMap.get('commentId');
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
        } else {
          this.router.navigate(['']);
          return EMPTY;
        }
      })
    );
  }
}
