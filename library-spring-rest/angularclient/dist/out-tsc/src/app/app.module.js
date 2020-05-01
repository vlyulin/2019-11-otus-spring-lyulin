import { __decorate } from "tslib";
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppComponent } from './app.component';
import { UserListComponent } from './user-list/user-list.component';
import { BookListComponent } from './book-list/book-list.component';
import { BookDetailComponent } from './book-detail/book-detail.component';
import { AuthGuard } from './services/authguard.service';
import { UserService } from './services/user.service';
import { BookService } from './services/book-service';
import { LookupValueService } from './services/lookupvalue.service';
import { CommentService } from './services/comment.service';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { AuthenticationService } from './services/authentication.service';
import { LoginComponent } from './login/login.component';
import { JwtInterceptor } from './helpers/jwt.interceptor';
// Запустить в developer's mode
// ng serve --open
// Локализация: https://angular.io/guide/i18n
// Первый шаг: ng add @angular/localize
// Добавить метки i18n
// Выгрузить строки для локализации ng xi18n --output-path src/locale
// Скопировать src/locale/messages.xlf в src/locale/messages.ru.xlf
// Каждому элементу <source>Library</source> сделать перевод в элементе <target>Библиотека</target>
// Собрать приложение с помощью команды ng build --prod --localize
// Запустить под российской локализацией ng serve --configuration=ru
// Тестирование ng test, но там много ошибок
let AppModule = class AppModule {
};
AppModule = __decorate([
    NgModule({
        declarations: [
            AppComponent,
            UserListComponent,
            BookListComponent,
            BookDetailComponent,
            PageNotFoundComponent,
            LoginComponent
        ],
        imports: [
            CommonModule,
            BrowserModule,
            HttpClientModule,
            FormsModule,
            ReactiveFormsModule,
            AppRoutingModule
        ],
        providers: [
            UserService,
            BookService,
            CommentService,
            LookupValueService,
            AuthGuard,
            AuthenticationService,
            { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true }
        ],
        bootstrap: [AppComponent]
    })
], AppModule);
export { AppModule };
//# sourceMappingURL=app.module.js.map