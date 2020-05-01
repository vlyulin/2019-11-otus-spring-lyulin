import { __decorate } from "tslib";
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from './services/authguard.service';
import { UserListComponent } from './user-list/user-list.component';
import { BookListComponent } from './book-list/book-list.component';
import { BookDetailComponent } from './book-detail/book-detail.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { LoginComponent } from './login/login.component';
const routes = [
    { path: 'login', component: LoginComponent },
    { path: 'users', component: UserListComponent, canActivate: [AuthGuard] },
    { path: 'advancedBookSearch', component: BookListComponent, canActivate: [AuthGuard] },
    { path: 'book/:bookId', component: BookDetailComponent, canActivate: [AuthGuard] },
    { path: 'bookComments/:bookId',
        loadChildren: () => import('./comment-list/comment-list.module').then(m => m.CommentListModule),
        // https://medium.com/@tomastrajan/why-and-how-to-lazy-load-angular-libraries-a3bf1489fe24
        data: { preload: true }
    },
    { path: '', redirectTo: '/advancedBookSearch', pathMatch: 'full' },
    { path: '**', component: PageNotFoundComponent }
];
let AppRoutingModule = class AppRoutingModule {
};
AppRoutingModule = __decorate([
    NgModule({
        imports: [RouterModule.forRoot(routes, { enableTracing: true } // <-- debugging purposes only
            )],
        exports: [RouterModule]
    })
], AppRoutingModule);
export { AppRoutingModule };
//# sourceMappingURL=app-routing.module.js.map