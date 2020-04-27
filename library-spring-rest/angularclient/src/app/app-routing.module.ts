import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuard } from './services/authguard.service';
import { UserListComponent } from './user-list/user-list.component';
import { BookListComponent } from './book-list/book-list.component';
import { BookDetailComponent } from './book-detail/book-detail.component'
import { PageNotFoundComponent }    from './page-not-found/page-not-found.component';
import { LoginComponent } from './login/login.component';
import { DummyComponent } from './dummy/dummy.component';

// 
const routes: Routes = [
  { path: 'users', component: UserListComponent, canActivate: [AuthGuard] },
  { path: 'advancedBookSearch', component: BookListComponent, canActivate: [AuthGuard] },
  { path: 'book/:bookId', component: BookDetailComponent, canActivate: [AuthGuard] },
  { path: 'bookComments/:bookId',
    loadChildren: () => import('./comment-list/comment-list.module').then(m => m.CommentListModule) //,
    // https://medium.com/@tomastrajan/why-and-how-to-lazy-load-angular-libraries-a3bf1489fe24
    // data: { preload: true } // ��� ��-�� ����� �� ���������� ������ ������������
  },
  { path: 'dummyService', component: DummyComponent, canActivate: [AuthGuard] },
  { path: 'login', component: LoginComponent },
  { path: '**',  redirectTo: '/login' }
];
// { path: '',   redirectTo: '/'},
// { path: '**', component: PageNotFoundComponent }

@NgModule({
  imports: [RouterModule.forRoot(
    routes,
    { enableTracing: true } // <-- debugging purposes only
  )],
  exports: [RouterModule]
})
export class AppRoutingModule { }
