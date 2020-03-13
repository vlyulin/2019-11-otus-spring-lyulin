(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"],{

/***/ "./$$_lazy_route_resource lazy recursive":
/*!******************************************************!*\
  !*** ./$$_lazy_route_resource lazy namespace object ***!
  \******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncaught exception popping up in devtools
	return Promise.resolve().then(function() {
		var e = new Error("Cannot find module '" + req + "'");
		e.code = 'MODULE_NOT_FOUND';
		throw e;
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "./$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "./src/app/app-routing.module.ts":
/*!***************************************!*\
  !*** ./src/app/app-routing.module.ts ***!
  \***************************************/
/*! exports provided: AppRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppRoutingModule", function() { return AppRoutingModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
/* harmony import */ var _services_authguard_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./services/authguard.service */ "./src/app/services/authguard.service.ts");
/* harmony import */ var _user_list_user_list_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./user-list/user-list.component */ "./src/app/user-list/user-list.component.ts");
/* harmony import */ var _book_list_book_list_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./book-list/book-list.component */ "./src/app/book-list/book-list.component.ts");
/* harmony import */ var _book_detail_book_detail_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./book-detail/book-detail.component */ "./src/app/book-detail/book-detail.component.ts");
/* harmony import */ var _page_not_found_page_not_found_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./page-not-found/page-not-found.component */ "./src/app/page-not-found/page-not-found.component.ts");









const routes = [
    { path: 'users', component: _user_list_user_list_component__WEBPACK_IMPORTED_MODULE_3__["UserListComponent"] },
    { path: 'advancedBookSearch', component: _book_list_book_list_component__WEBPACK_IMPORTED_MODULE_4__["BookListComponent"], canActivate: [_services_authguard_service__WEBPACK_IMPORTED_MODULE_2__["AuthGuard"]] },
    { path: 'book/:bookId', component: _book_detail_book_detail_component__WEBPACK_IMPORTED_MODULE_5__["BookDetailComponent"], canActivate: [_services_authguard_service__WEBPACK_IMPORTED_MODULE_2__["AuthGuard"]] },
    { path: 'bookComments/:bookId',
        loadChildren: () => __webpack_require__.e(/*! import() | comment-list-comment-list-module */ "comment-list-comment-list-module").then(__webpack_require__.bind(null, /*! ./comment-list/comment-list.module */ "./src/app/comment-list/comment-list.module.ts")).then(m => m.CommentListModule),
        // https://medium.com/@tomastrajan/why-and-how-to-lazy-load-angular-libraries-a3bf1489fe24
        data: { preload: true }
    },
    { path: '', redirectTo: '/advancedBookSearch', pathMatch: 'full' },
    { path: '**', component: _page_not_found_page_not_found_component__WEBPACK_IMPORTED_MODULE_6__["PageNotFoundComponent"] }
];
class AppRoutingModule {
}
AppRoutingModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({ type: AppRoutingModule });
AppRoutingModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({ factory: function AppRoutingModule_Factory(t) { return new (t || AppRoutingModule)(); }, imports: [[_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forRoot(routes, { enableTracing: true } // <-- debugging purposes only
            )],
        _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]] });
(function () { (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](AppRoutingModule, { imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]], exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]] }); })();
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](AppRoutingModule, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
        args: [{
                imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forRoot(routes, { enableTracing: true } // <-- debugging purposes only
                    )],
                exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
            }]
    }], null, null); })();


/***/ }),

/***/ "./src/app/app.component.ts":
/*!**********************************!*\
  !*** ./src/app/app.component.ts ***!
  \**********************************/
/*! exports provided: AppComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppComponent", function() { return AppComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");



var I18N_0;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_Library$$SRC_APP_APP_COMPONENT_TS_1 = goog.getMsg("Library");
    I18N_0 = MSG_EXTERNAL_Library$$SRC_APP_APP_COMPONENT_TS_1;
}
else {
    I18N_0 = "\u0411\u0438\u0431\u043B\u0438\u043E\u0442\u0435\u043A\u0430";
}
var I18N_2;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_AppName$$SRC_APP_APP_COMPONENT_TS_3 = goog.getMsg("Angular library client");
    I18N_2 = MSG_EXTERNAL_AppName$$SRC_APP_APP_COMPONENT_TS_3;
}
else {
    I18N_2 = "\u041A\u043B\u0438\u0435\u043D\u0442 \u043A \u0431\u0438\u0431\u043B\u0438\u043E\u0442\u0435\u043A\u0435 \u043D\u0430 Angular";
}
var I18N_4;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_List_users$$SRC_APP_APP_COMPONENT_TS_5 = goog.getMsg("List users");
    I18N_4 = MSG_EXTERNAL_List_users$$SRC_APP_APP_COMPONENT_TS_5;
}
else {
    I18N_4 = "\u0421\u043F\u0438\u0441\u043E\u043A \u043F\u043E\u043B\u044C\u0437\u043E\u0432\u0430\u0442\u0435\u043B\u0435\u0439";
}
var I18N_6;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_List_book$$SRC_APP_APP_COMPONENT_TS_7 = goog.getMsg("List books");
    I18N_6 = MSG_EXTERNAL_List_book$$SRC_APP_APP_COMPONENT_TS_7;
}
else {
    I18N_6 = "\u0421\u043F\u0438\u0441\u043E\u043A \u043A\u043D\u0438\u0433";
}
class AppComponent {
    constructor() {
    }
}
AppComponent.ɵfac = function AppComponent_Factory(t) { return new (t || AppComponent)(); };
AppComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: AppComponent, selectors: [["app-root"]], decls: 20, vars: 0, consts: [["role", "banner", 1, "toolbar"], ["width", "40", "alt", "Angular Logo", "src", "data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCAyNTAgMjUwIj4KICAgIDxwYXRoIGZpbGw9IiNERDAwMzEiIGQ9Ik0xMjUgMzBMMzEuOSA2My4ybDE0LjIgMTIzLjFMMTI1IDIzMGw3OC45LTQzLjcgMTQuMi0xMjMuMXoiIC8+CiAgICA8cGF0aCBmaWxsPSIjQzMwMDJGIiBkPSJNMTI1IDMwdjIyLjItLjFWMjMwbDc4LjktNDMuNyAxNC4yLTEyMy4xTDEyNSAzMHoiIC8+CiAgICA8cGF0aCAgZmlsbD0iI0ZGRkZGRiIgZD0iTTEyNSA1Mi4xTDY2LjggMTgyLjZoMjEuN2wxMS43LTI5LjJoNDkuNGwxMS43IDI5LjJIMTgzTDEyNSA1Mi4xem0xNyA4My4zaC0zNGwxNy00MC45IDE3IDQwLjl6IiAvPgogIDwvc3ZnPg=="], [1, "spacer"], [1, "container"], [1, "row"], [1, "col-md-12"], [1, "card", "bg-dark", "my-5"], [1, "card-body"], [1, "card-title", "text-center", "text-white", "py-3"], [1, "text-center", "list-inline", "py-3"], [1, "list-inline-item"], ["routerLink", "/users", 1, "btn", "btn-info"], ["routerLink", "/advancedBookSearch", 1, "btn", "btn-info"]], template: function AppComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](1, "img", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "span");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](3, I18N_0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](4, "div", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "div", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "div", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "div", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](8, "div", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](9, "div", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](10, "h2", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](11, I18N_2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](12, "ul", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](13, "li", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](14, "a", 11);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](15, I18N_4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](16, "li", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](17, "a", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](18, I18N_6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](19, "router-outlet");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } }, directives: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterLinkWithHref"], _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterOutlet"]], styles: ["\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2FwcC5jb21wb25lbnQuY3NzIn0= */", "[_nghost-%COMP%] {\n    font-family: -apple-system, BlinkMacSystemFont, \"Segoe UI\", Roboto, Helvetica, Arial, sans-serif, \"Apple Color Emoji\", \"Segoe UI Emoji\", \"Segoe UI Symbol\";\n    font-size: 14px;\n    color: #333;\n    box-sizing: border-box;\n    -webkit-font-smoothing: antialiased;\n    -moz-osx-font-smoothing: grayscale;\n  }\n\n  h1[_ngcontent-%COMP%], h2[_ngcontent-%COMP%], h3[_ngcontent-%COMP%], h4[_ngcontent-%COMP%], h5[_ngcontent-%COMP%], h6[_ngcontent-%COMP%] {\n    margin: 8px 0;\n  }\n\n  p[_ngcontent-%COMP%] {\n    margin: 0;\n  }\n\n  .spacer[_ngcontent-%COMP%] {\n    flex: 1;\n  }\n\n  .toolbar[_ngcontent-%COMP%] {\n    height: 60px;\n    margin: -8px;\n    display: flex;\n    align-items: center;\n    background-color: #1976d2;\n    color: white;\n    font-weight: 600;\n  }\n\n  .toolbar[_ngcontent-%COMP%]   img[_ngcontent-%COMP%] {\n    margin: 0 16px;\n  }\n\n  .toolbar[_ngcontent-%COMP%]   #twitter-logo[_ngcontent-%COMP%] {\n    height: 40px;\n    margin: 0 16px;\n  }\n\n  .toolbar[_ngcontent-%COMP%]   #twitter-logo[_ngcontent-%COMP%]:hover {\n    opacity: 0.8;\n  }\n\n  .content[_ngcontent-%COMP%] {\n    display: flex;\n    margin: 32px auto;\n    padding: 0 16px;\n    max-width: 960px;\n    flex-direction: column;\n    align-items: center;\n  }\n\n  svg.material-icons[_ngcontent-%COMP%] {\n    height: 24px;\n    width: auto;\n  }\n\n  svg.material-icons[_ngcontent-%COMP%]:not(:last-child) {\n    margin-right: 8px;\n  }"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](AppComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'app-root',
                templateUrl: './app.component.html',
                styleUrls: ['./app.component.css']
            }]
    }], function () { return []; }, null); })();


/***/ }),

/***/ "./src/app/app.module.ts":
/*!*******************************!*\
  !*** ./src/app/app.module.ts ***!
  \*******************************/
/*! exports provided: AppModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppModule", function() { return AppModule; });
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/__ivy_ngcc__/fesm2015/platform-browser.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
/* harmony import */ var _app_routing_module__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./app-routing.module */ "./src/app/app-routing.module.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/http.js");
/* harmony import */ var _app_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./app.component */ "./src/app/app.component.ts");
/* harmony import */ var _user_list_user_list_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./user-list/user-list.component */ "./src/app/user-list/user-list.component.ts");
/* harmony import */ var _book_list_book_list_component__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./book-list/book-list.component */ "./src/app/book-list/book-list.component.ts");
/* harmony import */ var _book_detail_book_detail_component__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./book-detail/book-detail.component */ "./src/app/book-detail/book-detail.component.ts");
/* harmony import */ var _services_authguard_service__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./services/authguard.service */ "./src/app/services/authguard.service.ts");
/* harmony import */ var _services_user_service__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ./services/user.service */ "./src/app/services/user.service.ts");
/* harmony import */ var _services_book_service__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ./services/book-service */ "./src/app/services/book-service.ts");
/* harmony import */ var _services_lookupvalue_service__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ./services/lookupvalue.service */ "./src/app/services/lookupvalue.service.ts");
/* harmony import */ var _services_comment_service__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ./services/comment.service */ "./src/app/services/comment.service.ts");
/* harmony import */ var _page_not_found_page_not_found_component__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ./page-not-found/page-not-found.component */ "./src/app/page-not-found/page-not-found.component.ts");

















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
class AppModule {
}
AppModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineNgModule"]({ type: AppModule, bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_6__["AppComponent"]] });
AppModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineInjector"]({ factory: function AppModule_Factory(t) { return new (t || AppModule)(); }, providers: [_services_user_service__WEBPACK_IMPORTED_MODULE_11__["UserService"], _services_book_service__WEBPACK_IMPORTED_MODULE_12__["BookService"], _services_comment_service__WEBPACK_IMPORTED_MODULE_14__["CommentService"], _services_lookupvalue_service__WEBPACK_IMPORTED_MODULE_13__["LookupValueService"], _services_authguard_service__WEBPACK_IMPORTED_MODULE_10__["AuthGuard"]], imports: [[
            _angular_common__WEBPACK_IMPORTED_MODULE_0__["CommonModule"],
            _angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__["BrowserModule"],
            _angular_common_http__WEBPACK_IMPORTED_MODULE_5__["HttpClientModule"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_3__["FormsModule"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_3__["ReactiveFormsModule"],
            _app_routing_module__WEBPACK_IMPORTED_MODULE_4__["AppRoutingModule"]
        ]] });
(function () { (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵsetNgModuleScope"](AppModule, { declarations: [_app_component__WEBPACK_IMPORTED_MODULE_6__["AppComponent"],
        _user_list_user_list_component__WEBPACK_IMPORTED_MODULE_7__["UserListComponent"],
        _book_list_book_list_component__WEBPACK_IMPORTED_MODULE_8__["BookListComponent"],
        _book_detail_book_detail_component__WEBPACK_IMPORTED_MODULE_9__["BookDetailComponent"],
        _page_not_found_page_not_found_component__WEBPACK_IMPORTED_MODULE_15__["PageNotFoundComponent"]], imports: [_angular_common__WEBPACK_IMPORTED_MODULE_0__["CommonModule"],
        _angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__["BrowserModule"],
        _angular_common_http__WEBPACK_IMPORTED_MODULE_5__["HttpClientModule"],
        _angular_forms__WEBPACK_IMPORTED_MODULE_3__["FormsModule"],
        _angular_forms__WEBPACK_IMPORTED_MODULE_3__["ReactiveFormsModule"],
        _app_routing_module__WEBPACK_IMPORTED_MODULE_4__["AppRoutingModule"]] }); })();
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵsetClassMetadata"](AppModule, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_2__["NgModule"],
        args: [{
                declarations: [
                    _app_component__WEBPACK_IMPORTED_MODULE_6__["AppComponent"],
                    _user_list_user_list_component__WEBPACK_IMPORTED_MODULE_7__["UserListComponent"],
                    _book_list_book_list_component__WEBPACK_IMPORTED_MODULE_8__["BookListComponent"],
                    _book_detail_book_detail_component__WEBPACK_IMPORTED_MODULE_9__["BookDetailComponent"],
                    _page_not_found_page_not_found_component__WEBPACK_IMPORTED_MODULE_15__["PageNotFoundComponent"]
                ],
                imports: [
                    _angular_common__WEBPACK_IMPORTED_MODULE_0__["CommonModule"],
                    _angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__["BrowserModule"],
                    _angular_common_http__WEBPACK_IMPORTED_MODULE_5__["HttpClientModule"],
                    _angular_forms__WEBPACK_IMPORTED_MODULE_3__["FormsModule"],
                    _angular_forms__WEBPACK_IMPORTED_MODULE_3__["ReactiveFormsModule"],
                    _app_routing_module__WEBPACK_IMPORTED_MODULE_4__["AppRoutingModule"]
                ],
                providers: [_services_user_service__WEBPACK_IMPORTED_MODULE_11__["UserService"], _services_book_service__WEBPACK_IMPORTED_MODULE_12__["BookService"], _services_comment_service__WEBPACK_IMPORTED_MODULE_14__["CommentService"], _services_lookupvalue_service__WEBPACK_IMPORTED_MODULE_13__["LookupValueService"], _services_authguard_service__WEBPACK_IMPORTED_MODULE_10__["AuthGuard"]],
                bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_6__["AppComponent"]]
            }]
    }], null, null); })();


/***/ }),

/***/ "./src/app/book-detail/book-detail.component.ts":
/*!******************************************************!*\
  !*** ./src/app/book-detail/book-detail.component.ts ***!
  \******************************************************/
/*! exports provided: BookDetailComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "BookDetailComponent", function() { return BookDetailComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm2015/index.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm2015/operators/index.js");
/* harmony import */ var _models_book__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../models/book */ "./src/app/models/book.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
/* harmony import */ var _services_book_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../services/book-service */ "./src/app/services/book-service.ts");
/* harmony import */ var _services_lookupvalue_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../services/lookupvalue.service */ "./src/app/services/lookupvalue.service.ts");
/* harmony import */ var _services_author_service__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../services/author.service */ "./src/app/services/author.service.ts");
/* harmony import */ var _services_publishing_house_service__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ../services/publishing-house.service */ "./src/app/services/publishing-house.service.ts");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");





 // RxJS 6 syntax








var I18N_0;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_BTName$$SRC_APP_BOOK_DETAIL_BOOK_DETAIL_COMPONENT_TS__1 = goog.getMsg("Name:");
    I18N_0 = MSG_EXTERNAL_BTName$$SRC_APP_BOOK_DETAIL_BOOK_DETAIL_COMPONENT_TS__1;
}
else {
    I18N_0 = "\u041D\u0430\u0438\u043C\u0435\u043D\u043E\u0432\u0430\u043D\u0438\u0435:";
}
var I18N_2;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_BTPubYear$$SRC_APP_BOOK_DETAIL_BOOK_DETAIL_COMPONENT_TS__3 = goog.getMsg("Publishing year:");
    I18N_2 = MSG_EXTERNAL_BTPubYear$$SRC_APP_BOOK_DETAIL_BOOK_DETAIL_COMPONENT_TS__3;
}
else {
    I18N_2 = "\u0413\u043E\u0434 \u0438\u0437\u0434\u0430\u043D\u0438\u044F:";
}
var I18N_4;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_BTPages$$SRC_APP_BOOK_DETAIL_BOOK_DETAIL_COMPONENT_TS__5 = goog.getMsg("Pages:");
    I18N_4 = MSG_EXTERNAL_BTPages$$SRC_APP_BOOK_DETAIL_BOOK_DETAIL_COMPONENT_TS__5;
}
else {
    I18N_4 = "\u0421\u0442\u0440\u0430\u043D\u0438\u0446:";
}
var I18N_6;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_BTGenre$$SRC_APP_BOOK_DETAIL_BOOK_DETAIL_COMPONENT_TS__7 = goog.getMsg("Genre:");
    I18N_6 = MSG_EXTERNAL_BTGenre$$SRC_APP_BOOK_DETAIL_BOOK_DETAIL_COMPONENT_TS__7;
}
else {
    I18N_6 = "\u0416\u0430\u043D\u0440:";
}
var I18N_8;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_BTAuthor$$SRC_APP_BOOK_DETAIL_BOOK_DETAIL_COMPONENT_TS__9 = goog.getMsg("Author:");
    I18N_8 = MSG_EXTERNAL_BTAuthor$$SRC_APP_BOOK_DETAIL_BOOK_DETAIL_COMPONENT_TS__9;
}
else {
    I18N_8 = "\u0410\u0432\u0442\u043E\u0440:";
}
var I18N_10;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_BTPubHouse$$SRC_APP_BOOK_DETAIL_BOOK_DETAIL_COMPONENT_TS__11 = goog.getMsg("Publishing house:");
    I18N_10 = MSG_EXTERNAL_BTPubHouse$$SRC_APP_BOOK_DETAIL_BOOK_DETAIL_COMPONENT_TS__11;
}
else {
    I18N_10 = "\u0418\u0437\u0434\u0430\u0442\u0435\u043B\u044C\u0441\u0442\u0432\u043E:";
}
var I18N_12;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_BTBtnSave$$SRC_APP_BOOK_DETAIL_BOOK_DETAIL_COMPONENT_TS__13 = goog.getMsg("Save");
    I18N_12 = MSG_EXTERNAL_BTBtnSave$$SRC_APP_BOOK_DETAIL_BOOK_DETAIL_COMPONENT_TS__13;
}
else {
    I18N_12 = "\u0421\u043E\u0445\u0440\u0430\u043D\u0438\u0442\u044C";
}
var I18N_14;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_BTBtnCancel$$SRC_APP_BOOK_DETAIL_BOOK_DETAIL_COMPONENT_TS__15 = goog.getMsg("Cancel");
    I18N_14 = MSG_EXTERNAL_BTBtnCancel$$SRC_APP_BOOK_DETAIL_BOOK_DETAIL_COMPONENT_TS__15;
}
else {
    I18N_14 = "\u041E\u0442\u043C\u0435\u043D\u0438\u0442\u044C";
}
var I18N_16;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_BTNameReq$$SRC_APP_BOOK_DETAIL_BOOK_DETAIL_COMPONENT_TS___17 = goog.getMsg(" Name is required. ");
    I18N_16 = MSG_EXTERNAL_BTNameReq$$SRC_APP_BOOK_DETAIL_BOOK_DETAIL_COMPONENT_TS___17;
}
else {
    I18N_16 = "\u0418\u043C\u044F \u043E\u0431\u044F\u0437\u0430\u0442\u0435\u043B\u044C\u043D\u043E.";
}
function BookDetailComponent_div_0_span_7_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "span", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](1, I18N_16);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} }
var I18N_18;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_BTPubYearReq$$SRC_APP_BOOK_DETAIL_BOOK_DETAIL_COMPONENT_TS___19 = goog.getMsg(" Publishing year is required. ");
    I18N_18 = MSG_EXTERNAL_BTPubYearReq$$SRC_APP_BOOK_DETAIL_BOOK_DETAIL_COMPONENT_TS___19;
}
else {
    I18N_18 = "\u0413\u043E\u0434 \u0438\u0437\u0434\u0430\u043D\u0438\u044F \u043E\u0431\u044F\u0437\u0430\u0442\u0435\u043B\u0435\u043D.";
}
function BookDetailComponent_div_0_span_13_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "span", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](1, I18N_18);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} }
var I18N_20;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_BTPubYearOnlyNumbers$$SRC_APP_BOOK_DETAIL_BOOK_DETAIL_COMPONENT_TS___21 = goog.getMsg(" Only numbers. ");
    I18N_20 = MSG_EXTERNAL_BTPubYearOnlyNumbers$$SRC_APP_BOOK_DETAIL_BOOK_DETAIL_COMPONENT_TS___21;
}
else {
    I18N_20 = "\u0422\u043E\u043B\u044C\u043A\u043E \u0447\u0438\u0441\u043B\u0430.";
}
function BookDetailComponent_div_0_span_14_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "span", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](1, I18N_20);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} }
var I18N_22;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_BTPagesReq$$SRC_APP_BOOK_DETAIL_BOOK_DETAIL_COMPONENT_TS___23 = goog.getMsg(" Pages is required. ");
    I18N_22 = MSG_EXTERNAL_BTPagesReq$$SRC_APP_BOOK_DETAIL_BOOK_DETAIL_COMPONENT_TS___23;
}
else {
    I18N_22 = "\u041A\u043E\u043B\u0438\u0447\u0435\u0441\u0442\u0432\u043E \u0441\u0442\u0440\u0430\u043D\u0438\u0446 \u043E\u0431\u044F\u0437\u0430\u0442\u0435\u043B\u044C\u043D\u043E.";
}
function BookDetailComponent_div_0_span_20_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "span", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](1, I18N_22);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} }
var I18N_24;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_BTPagesOnlyNumbers$$SRC_APP_BOOK_DETAIL_BOOK_DETAIL_COMPONENT_TS___25 = goog.getMsg(" Only numbers. ");
    I18N_24 = MSG_EXTERNAL_BTPagesOnlyNumbers$$SRC_APP_BOOK_DETAIL_BOOK_DETAIL_COMPONENT_TS___25;
}
else {
    I18N_24 = "\u0422\u043E\u043B\u044C\u043A\u043E \u0447\u0438\u0441\u043B\u0430.";
}
function BookDetailComponent_div_0_span_21_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "span", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](1, I18N_24);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} }
function BookDetailComponent_div_0_option_26_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "option", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const genre_r23 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngValue", genre_r23);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", genre_r23.meaning, " ");
} }
var I18N_26;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_BTGenreReq$$SRC_APP_BOOK_DETAIL_BOOK_DETAIL_COMPONENT_TS___27 = goog.getMsg(" Genre is required. ");
    I18N_26 = MSG_EXTERNAL_BTGenreReq$$SRC_APP_BOOK_DETAIL_BOOK_DETAIL_COMPONENT_TS___27;
}
else {
    I18N_26 = "\u0416\u0430\u043D\u0440 \u043E\u0431\u044F\u0437\u0430\u0442\u0435\u043B\u0435\u043D.";
}
function BookDetailComponent_div_0_span_27_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "span", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](1, I18N_26);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} }
function BookDetailComponent_div_0_option_32_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "option", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const author_r24 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngValue", author_r24);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", author_r24.name, " ");
} }
var I18N_28;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_BTAuthorReq$$SRC_APP_BOOK_DETAIL_BOOK_DETAIL_COMPONENT_TS___29 = goog.getMsg(" Author is required. ");
    I18N_28 = MSG_EXTERNAL_BTAuthorReq$$SRC_APP_BOOK_DETAIL_BOOK_DETAIL_COMPONENT_TS___29;
}
else {
    I18N_28 = "\u0410\u0432\u0442\u043E\u0440 \u043E\u0431\u044F\u0437\u0430\u0442\u0435\u043B\u0435\u043D.";
}
function BookDetailComponent_div_0_span_33_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "span", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](1, I18N_28);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} }
function BookDetailComponent_div_0_option_38_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "option", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const publishingHouse_r25 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngValue", publishingHouse_r25);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", publishingHouse_r25.name, " ");
} }
var I18N_30;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_BTPubHouseReq$$SRC_APP_BOOK_DETAIL_BOOK_DETAIL_COMPONENT_TS___31 = goog.getMsg(" Publishing house is required. ");
    I18N_30 = MSG_EXTERNAL_BTPubHouseReq$$SRC_APP_BOOK_DETAIL_BOOK_DETAIL_COMPONENT_TS___31;
}
else {
    I18N_30 = "\u0418\u0437\u0434\u0430\u0442\u0435\u043B\u044C\u0441\u0442\u0432\u043E \u043E\u0431\u044F\u0437\u0430\u0442\u0435\u043B\u044C\u043D\u043E.";
}
function BookDetailComponent_div_0_span_39_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "span", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](1, I18N_30);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} }
function BookDetailComponent_div_0_Template(rf, ctx) { if (rf & 1) {
    const _r27 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "div", 1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "form", 2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("ngSubmit", function BookDetailComponent_div_0_Template_form_ngSubmit_2_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r27); const ctx_r26 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r26.onSubmit(); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "label");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](5, I18N_0);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](6, "input", 3);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](7, BookDetailComponent_div_0_span_7_Template, 2, 0, "span", 4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](8, "br");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](9, "label");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](10);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](11, I18N_2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](12, "input", 5);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](13, BookDetailComponent_div_0_span_13_Template, 2, 0, "span", 4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](14, BookDetailComponent_div_0_span_14_Template, 2, 0, "span", 4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](15, "br");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](16, "label");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](17);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](18, I18N_4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](19, "input", 6);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](20, BookDetailComponent_div_0_span_20_Template, 2, 0, "span", 4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](21, BookDetailComponent_div_0_span_21_Template, 2, 0, "span", 4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](22, "br");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](23, "label");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](24, I18N_6);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](25, "select", 7);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](26, BookDetailComponent_div_0_option_26_Template, 2, 2, "option", 8);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](27, BookDetailComponent_div_0_span_27_Template, 2, 0, "span", 4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](28, "br");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](29, "label");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](30, I18N_8);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](31, "select", 9);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](32, BookDetailComponent_div_0_option_32_Template, 2, 2, "option", 8);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](33, BookDetailComponent_div_0_span_33_Template, 2, 0, "span", 4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](34, "br");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](35, "label");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](36, I18N_10);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](37, "select", 10);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](38, BookDetailComponent_div_0_option_38_Template, 2, 2, "option", 8);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](39, BookDetailComponent_div_0_span_39_Template, 2, 0, "span", 4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](40, "br");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](41, "button", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](42, I18N_12);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](43, "button", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](44, I18N_14);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r10 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("formGroup", ctx_r10.bookForm);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", (ctx_r10.f.name.dirty || ctx_r10.f.name.touched) && ctx_r10.f.name.invalid && ctx_r10.f.name.errors.required);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](6);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", (ctx_r10.f.publishingYear.dirty || ctx_r10.f.publishingYear.touched) && ctx_r10.f.publishingYear.invalid && ctx_r10.f.publishingYear.errors.required);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", (ctx_r10.f.publishingYear.dirty || ctx_r10.f.publishingYear.touched) && ctx_r10.f.publishingYear.invalid);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](6);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", (ctx_r10.f.pages.dirty || ctx_r10.f.pages.touched) && ctx_r10.f.pages.invalid && ctx_r10.f.pages.errors.required);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", (ctx_r10.f.pages.dirty || ctx_r10.f.pages.touched) && ctx_r10.f.pages.invalid);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngForOf", ctx_r10.genres);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", (ctx_r10.f.genre.dirty || ctx_r10.f.genre.touched) && ctx_r10.f.genre.invalid && ctx_r10.f.genre.errors.required);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngForOf", ctx_r10.authors);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", (ctx_r10.f.author.dirty || ctx_r10.f.author.touched) && ctx_r10.f.author.invalid && ctx_r10.f.author.errors.required);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngForOf", ctx_r10.publishingHouses);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", (ctx_r10.f.publishingHouse.dirty || ctx_r10.f.publishingHouse.touched) && ctx_r10.f.publishingHouse.invalid && ctx_r10.f.publishingHouse.errors.required);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("disabled", !ctx_r10.bookForm.valid);
} }
// https://angular.io/guide/reactive-forms
class BookDetailComponent {
    constructor(route, router, bookService, lookupValueService, authorService, publishingHouseService) {
        this.route = route;
        this.router = router;
        this.bookService = bookService;
        this.lookupValueService = lookupValueService;
        this.authorService = authorService;
        this.publishingHouseService = publishingHouseService;
        // Validators:
        // https://malcoded.com/posts/angular-reactive-form-validation/
        // https://angular.io/guide/form-validation
        this.bookForm = new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormGroup"]({
            id: new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"](),
            name: new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"]('', [_angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required]),
            publishingYear: new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"]('', [_angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].pattern("^[0-9]*$")]),
            pages: new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"]('', [_angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].pattern("^[0-9]*$")]),
            genre: new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"]('', [_angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required]),
            author: new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"]('', [_angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required]),
            publishingHouse: new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"]('', [_angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required])
        });
    }
    // convenience getter for easy access to form fields
    get f() { return this.bookForm.controls; }
    // Анимация: https://webformyself.com/glubokoe-pogruzhenie-v-veb-animaciyu-s-angular/
    // https://angular.io/guide/router#activated-route-in-action
    // Не до мультиков.
    ngOnInit() {
        // https://levelup.gitconnected.com/handle-multiple-api-requests-in-angular-using-mergemap-and-forkjoin-to-avoid-nested-subscriptions-a20fb5040d0c
        this.book$ = this.route.paramMap.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["switchMap"])((params) => {
            let bookId = params.get('bookId');
            // Если bookId = -1, то это создание новой книги
            if (bookId != '-1') {
                return this.bookService.getBook(bookId);
            }
            // Возвращаем пустой экземпляр книги при создании новой книги
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["of"])(new _models_book__WEBPACK_IMPORTED_MODULE_4__["Book"]({}));
        }));
        this.book$.subscribe(book => {
            this.book = book;
            console.warn("book.name = " + book.name);
            Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["forkJoin"])([this.lookupValueService.getLookupValues('RU'), this.authorService.getAuthors(), this.publishingHouseService.getPublishingHouses()]).subscribe(result => {
                this.genres = result[0];
                this.authors = result[1];
                this.publishingHouses = result[2];
                if (book.id) {
                    // Редктирование книги. Заполнение полей web формы
                    this.bookForm.setValue({
                        id: this.book.id,
                        name: this.book.name,
                        publishingYear: this.book.publishingYear,
                        pages: this.book.pages,
                        genre: this.genres.find(x => x.key.lookupCode === book.genre.key.lookupCode),
                        author: this.authors.find(x => x.id === book.author.id),
                        publishingHouse: this.publishingHouses.find(x => x.id == book.publishingHouse.id)
                    });
                }
            });
        });
    }
    onSubmit() {
        this.book.id = this.bookForm.value.id;
        this.book.name = this.bookForm.value.name;
        this.book.publishingYear = this.bookForm.value.publishingYear;
        this.book.pages = this.bookForm.value.pages;
        this.book.genre = this.bookForm.value.genre;
        this.book.author = this.bookForm.value.author;
        this.book.publishingHouse = this.bookForm.value.publishingHouse;
        this.bookService.saveBook(this.book);
        this.router.navigate(['advancedBookSearch']);
    }
    cancel() {
        this.router.navigate(['advancedBookSearch']);
    }
}
BookDetailComponent.ɵfac = function BookDetailComponent_Factory(t) { return new (t || BookDetailComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_5__["ActivatedRoute"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_5__["Router"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_book_service__WEBPACK_IMPORTED_MODULE_6__["BookService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_lookupvalue_service__WEBPACK_IMPORTED_MODULE_7__["LookupValueService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_author_service__WEBPACK_IMPORTED_MODULE_8__["AuthorService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_publishing_house_service__WEBPACK_IMPORTED_MODULE_9__["PublishingHouseService"])); };
BookDetailComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: BookDetailComponent, selectors: [["app-book-detail"]], decls: 2, vars: 3, consts: [[4, "ngIf"], [1, "form-group"], [3, "formGroup", "ngSubmit"], ["type", "text", "formControlName", "name", 1, "form-control"], ["class", "text-danger", 4, "ngIf"], ["type", "text", "formControlName", "publishingYear", 1, "form-control"], ["type", "text", "formControlName", "pages", 1, "form-control"], ["formControlName", "genre", 1, "form-control"], [3, "ngValue", 4, "ngFor", "ngForOf"], ["formControlName", "author", 1, "form-control"], ["formControlName", "publishingHouse", 1, "form-control"], ["type", "submit", 1, "btn", "btn-primary", "mr-2", 3, "disabled"], ["type", "cancel", 1, "btn", "btn-primary"], [1, "text-danger"], [3, "ngValue"]], template: function BookDetailComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](0, BookDetailComponent_div_0_Template, 45, 13, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](1, "async");
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](1, 1, ctx.book$));
    } }, directives: [_angular_common__WEBPACK_IMPORTED_MODULE_10__["NgIf"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["ɵangular_packages_forms_forms_y"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["NgControlStatusGroup"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormGroupDirective"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["DefaultValueAccessor"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["NgControlStatus"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControlName"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["SelectControlValueAccessor"], _angular_common__WEBPACK_IMPORTED_MODULE_10__["NgForOf"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["NgSelectOption"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["ɵangular_packages_forms_forms_x"]], pipes: [_angular_common__WEBPACK_IMPORTED_MODULE_10__["AsyncPipe"]], styles: ["\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2Jvb2stZGV0YWlsL2Jvb2stZGV0YWlsLmNvbXBvbmVudC5jc3MifQ== */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](BookDetailComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'app-book-detail',
                templateUrl: './book-detail.component.html',
                styleUrls: ['./book-detail.component.css']
            }]
    }], function () { return [{ type: _angular_router__WEBPACK_IMPORTED_MODULE_5__["ActivatedRoute"] }, { type: _angular_router__WEBPACK_IMPORTED_MODULE_5__["Router"] }, { type: _services_book_service__WEBPACK_IMPORTED_MODULE_6__["BookService"] }, { type: _services_lookupvalue_service__WEBPACK_IMPORTED_MODULE_7__["LookupValueService"] }, { type: _services_author_service__WEBPACK_IMPORTED_MODULE_8__["AuthorService"] }, { type: _services_publishing_house_service__WEBPACK_IMPORTED_MODULE_9__["PublishingHouseService"] }]; }, null); })();


/***/ }),

/***/ "./src/app/book-list/book-list-search-info.ts":
/*!****************************************************!*\
  !*** ./src/app/book-list/book-list-search-info.ts ***!
  \****************************************************/
/*! exports provided: BookListSearchInfo */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "BookListSearchInfo", function() { return BookListSearchInfo; });
// Была попытка сохранения фильтра при возврате на страницу
// За неимением достаточности времени отложил данную идею,
// но выбрасывать наработку жалко
class BookListSearchInfo {
}


/***/ }),

/***/ "./src/app/book-list/book-list.component.ts":
/*!**************************************************!*\
  !*** ./src/app/book-list/book-list.component.ts ***!
  \**************************************************/
/*! exports provided: BookListComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "BookListComponent", function() { return BookListComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
/* harmony import */ var _book_list_search_info__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./book-list-search-info */ "./src/app/book-list/book-list-search-info.ts");
/* harmony import */ var _services_book_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../services/book-service */ "./src/app/services/book-service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");








var I18N_0;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_BSBookName$$SRC_APP_BOOK_LIST_BOOK_LIST_COMPONENT_TS_1 = goog.getMsg("Book name:");
    I18N_0 = MSG_EXTERNAL_BSBookName$$SRC_APP_BOOK_LIST_BOOK_LIST_COMPONENT_TS_1;
}
else {
    I18N_0 = "\u041D\u0430\u0438\u043C\u0435\u043D\u043E\u0432\u0430\u043D\u0438\u0435:";
}
var I18N_2;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_BSAuthorName$$SRC_APP_BOOK_LIST_BOOK_LIST_COMPONENT_TS_3 = goog.getMsg("Author name:");
    I18N_2 = MSG_EXTERNAL_BSAuthorName$$SRC_APP_BOOK_LIST_BOOK_LIST_COMPONENT_TS_3;
}
else {
    I18N_2 = "\u0410\u0432\u0442\u043E\u0440:";
}
var I18N_4;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_BSGenreName$$SRC_APP_BOOK_LIST_BOOK_LIST_COMPONENT_TS_5 = goog.getMsg("Genre name:");
    I18N_4 = MSG_EXTERNAL_BSGenreName$$SRC_APP_BOOK_LIST_BOOK_LIST_COMPONENT_TS_5;
}
else {
    I18N_4 = "\u0416\u0430\u043D\u0440:";
}
var I18N_6;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_BSPagesFrom$$SRC_APP_BOOK_LIST_BOOK_LIST_COMPONENT_TS_7 = goog.getMsg("Pages from:");
    I18N_6 = MSG_EXTERNAL_BSPagesFrom$$SRC_APP_BOOK_LIST_BOOK_LIST_COMPONENT_TS_7;
}
else {
    I18N_6 = "\u0421\u0442\u0440\u0430\u043D\u0438\u0446 \u0441:";
}
var I18N_8;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_BSPagesTo$$SRC_APP_BOOK_LIST_BOOK_LIST_COMPONENT_TS_9 = goog.getMsg("Pages to:");
    I18N_8 = MSG_EXTERNAL_BSPagesTo$$SRC_APP_BOOK_LIST_BOOK_LIST_COMPONENT_TS_9;
}
else {
    I18N_8 = "\u0421\u0442\u0440\u0430\u043D\u0438\u0446 \u043F\u043E:";
}
var I18N_10;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_BSPubHouse$$SRC_APP_BOOK_LIST_BOOK_LIST_COMPONENT_TS_11 = goog.getMsg("Publishing House:");
    I18N_10 = MSG_EXTERNAL_BSPubHouse$$SRC_APP_BOOK_LIST_BOOK_LIST_COMPONENT_TS_11;
}
else {
    I18N_10 = "\u0418\u0437\u0434\u0430\u0442\u0435\u043B\u044C\u0441\u0442\u0432\u043E:";
}
var I18N_12;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_BSPubYearFrom$$SRC_APP_BOOK_LIST_BOOK_LIST_COMPONENT_TS_13 = goog.getMsg("Publishing Year from:");
    I18N_12 = MSG_EXTERNAL_BSPubYearFrom$$SRC_APP_BOOK_LIST_BOOK_LIST_COMPONENT_TS_13;
}
else {
    I18N_12 = "\u0413\u043E\u0434 \u0438\u0437\u0434\u0430\u043D\u0438\u044F \u0441:";
}
var I18N_14;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_BSPubYearTo$$SRC_APP_BOOK_LIST_BOOK_LIST_COMPONENT_TS_15 = goog.getMsg("Publishing Year to:");
    I18N_14 = MSG_EXTERNAL_BSPubYearTo$$SRC_APP_BOOK_LIST_BOOK_LIST_COMPONENT_TS_15;
}
else {
    I18N_14 = "\u0413\u043E\u0434 \u0438\u0437\u0434\u0430\u043D\u0438\u044F \u043F\u043E:";
}
var I18N_16;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_BSBtnSearch$$SRC_APP_BOOK_LIST_BOOK_LIST_COMPONENT_TS_17 = goog.getMsg("Search");
    I18N_16 = MSG_EXTERNAL_BSBtnSearch$$SRC_APP_BOOK_LIST_BOOK_LIST_COMPONENT_TS_17;
}
else {
    I18N_16 = "\u041F\u043E\u0438\u0441\u043A";
}
var I18N_18;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_BookTblName$$SRC_APP_BOOK_LIST_BOOK_LIST_COMPONENT_TS_19 = goog.getMsg("Name");
    I18N_18 = MSG_EXTERNAL_BookTblName$$SRC_APP_BOOK_LIST_BOOK_LIST_COMPONENT_TS_19;
}
else {
    I18N_18 = "\u0418\u043C\u044F";
}
var I18N_20;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_BookTblAuthor$$SRC_APP_BOOK_LIST_BOOK_LIST_COMPONENT_TS_21 = goog.getMsg("Author");
    I18N_20 = MSG_EXTERNAL_BookTblAuthor$$SRC_APP_BOOK_LIST_BOOK_LIST_COMPONENT_TS_21;
}
else {
    I18N_20 = "\u0410\u0432\u0442\u043E\u0440";
}
var I18N_22;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_BookTblPages$$SRC_APP_BOOK_LIST_BOOK_LIST_COMPONENT_TS_23 = goog.getMsg("Pages");
    I18N_22 = MSG_EXTERNAL_BookTblPages$$SRC_APP_BOOK_LIST_BOOK_LIST_COMPONENT_TS_23;
}
else {
    I18N_22 = "\u0421\u0442\u0440\u0430\u043D\u0438\u0446";
}
var I18N_24;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_BookTblGenre$$SRC_APP_BOOK_LIST_BOOK_LIST_COMPONENT_TS_25 = goog.getMsg("Genre");
    I18N_24 = MSG_EXTERNAL_BookTblGenre$$SRC_APP_BOOK_LIST_BOOK_LIST_COMPONENT_TS_25;
}
else {
    I18N_24 = "\u0416\u0430\u043D\u0440";
}
var I18N_26;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_BookTblPubHouse$$SRC_APP_BOOK_LIST_BOOK_LIST_COMPONENT_TS_27 = goog.getMsg("Publishing house");
    I18N_26 = MSG_EXTERNAL_BookTblPubHouse$$SRC_APP_BOOK_LIST_BOOK_LIST_COMPONENT_TS_27;
}
else {
    I18N_26 = "\u0418\u0437\u0434\u0430\u0442\u0435\u043B\u044C\u0441\u0442\u0432\u043E";
}
var I18N_28;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_BookTblPubYear$$SRC_APP_BOOK_LIST_BOOK_LIST_COMPONENT_TS_29 = goog.getMsg("Publishing year");
    I18N_28 = MSG_EXTERNAL_BookTblPubYear$$SRC_APP_BOOK_LIST_BOOK_LIST_COMPONENT_TS_29;
}
else {
    I18N_28 = "\u0413\u043E\u0434 \u0438\u0437\u0434\u0430\u043D\u0438\u044F";
}
var I18N_30;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_BookTblOpers$$SRC_APP_BOOK_LIST_BOOK_LIST_COMPONENT_TS_31 = goog.getMsg("Operations");
    I18N_30 = MSG_EXTERNAL_BookTblOpers$$SRC_APP_BOOK_LIST_BOOK_LIST_COMPONENT_TS_31;
}
else {
    I18N_30 = "\u041E\u043F\u0435\u0440\u0430\u0446\u0438\u0438";
}
var I18N_32;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_BookBtnNewBook$$SRC_APP_BOOK_LIST_BOOK_LIST_COMPONENT_TS_33 = goog.getMsg("New book");
    I18N_32 = MSG_EXTERNAL_BookBtnNewBook$$SRC_APP_BOOK_LIST_BOOK_LIST_COMPONENT_TS_33;
}
else {
    I18N_32 = "\u041D\u043E\u0432\u0430\u044F \u043A\u043D\u0438\u0433\u0430";
}
var I18N_34;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_BookTblBtnComments$$SRC_APP_BOOK_LIST_BOOK_LIST_COMPONENT_TS__35 = goog.getMsg("Comments");
    I18N_34 = MSG_EXTERNAL_BookTblBtnComments$$SRC_APP_BOOK_LIST_BOOK_LIST_COMPONENT_TS__35;
}
else {
    I18N_34 = "\u041A\u043E\u043C\u043C\u0435\u043D\u0442\u0430\u0440\u0438\u0438";
}
var I18N_36;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_BookTblBtnEdit$$SRC_APP_BOOK_LIST_BOOK_LIST_COMPONENT_TS__37 = goog.getMsg("Edit");
    I18N_36 = MSG_EXTERNAL_BookTblBtnEdit$$SRC_APP_BOOK_LIST_BOOK_LIST_COMPONENT_TS__37;
}
else {
    I18N_36 = "\u0420\u0435\u0434\u0430\u043A\u0442\u0438\u0440\u043E\u0432\u0430\u0442\u044C";
}
var I18N_38;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_BookTblDel$$SRC_APP_BOOK_LIST_BOOK_LIST_COMPONENT_TS__39 = goog.getMsg("Delete");
    I18N_38 = MSG_EXTERNAL_BookTblDel$$SRC_APP_BOOK_LIST_BOOK_LIST_COMPONENT_TS__39;
}
else {
    I18N_38 = "\u0423\u0434\u0430\u043B\u0438\u0442\u044C";
}
const _c40 = function (a1) { return ["/book", a1]; };
const _c41 = function (a1) { return ["/bookComments", a1]; };
function BookListComponent_tr_77_Template(rf, ctx) { if (rf & 1) {
    const _r8 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "tr");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "td");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "a", 20);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "span", 21);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "td", 22);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](6);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "td", 22);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](8);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](9, "td", 22);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](10);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](11, "td", 22);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](12);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](13, "td", 22);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](14);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](15, "td", 22);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](16);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](17, "td", 22);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](18, "button", 20);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](19, I18N_34);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](20, "button", 20);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](21, I18N_36);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](22, "button", 23);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function BookListComponent_tr_77_Template_button_click_22_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r8); const book_r6 = ctx.$implicit; const ctx_r7 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r7.deleteBook(book_r6.id); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](23, I18N_38);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const book_r6 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("routerLink", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction1"](10, _c40, book_r6.id));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](book_r6.id);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](book_r6.name);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](book_r6.author.name);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](book_r6.pages);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](book_r6.genre.meaning);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](book_r6.publishingHouse.name);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](book_r6.publishingYear);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("routerLink", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction1"](12, _c41, book_r6.id));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("routerLink", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction1"](14, _c40, book_r6.id));
} }
class BookListComponent {
    constructor(bookService, router) {
        this.bookService = bookService;
        this.router = router;
    }
    ngOnInit() {
        if (this.bookListSearchInfo == null) {
            this.bookListSearchInfo = new _book_list_search_info__WEBPACK_IMPORTED_MODULE_2__["BookListSearchInfo"]();
        }
        this.form = new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormGroup"]({
            bookName: new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"](),
            genreMeaning: new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"](),
            authorName: new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"](),
            publishingHouseName: new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"](),
            publishingYearFrom: new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"](),
            publishingYearTo: new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"](),
            pagesFrom: new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"](),
            pagesTo: new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"]()
        });
        // Как установить значение в контрол
        // this.form.controls['bookName'].setValue('%ядов%');
    }
    searchForm(searchInfo) {
        console.warn('searchForm: enter');
        this.bookListSearchInfo.bookName = this.form.get('bookName').value;
        this.bookListSearchInfo.genreMeaning = this.form.get('genreMeaning').value;
        this.bookListSearchInfo.authorName = this.form.get('authorName').value;
        this.bookListSearchInfo.publishingHouseName = this.form.get('publishingHouseName').value;
        this.bookListSearchInfo.publishingYearFrom = this.form.get('publishingYearFrom').value;
        this.bookListSearchInfo.publishingYearTo = this.form.get('publishingYearTo').value;
        this.bookListSearchInfo.pagesFrom = this.form.get('pagesFrom').value;
        this.bookListSearchInfo.pagesTo = this.form.get('pagesTo').value;
        this.bookService.getBooks(this.form.get('bookName').value, // || '%ядов%',
        this.form.get('genreMeaning').value, this.form.get('authorName').value, this.form.get('publishingHouseName').value, this.form.get('publishingYearFrom').value, this.form.get('publishingYearTo').value, this.form.get('pagesFrom').value, this.form.get('pagesTo').value).subscribe(data => {
            this.books = data;
        });
    }
    deleteBook(bookId) {
        console.warn("deleteBook: enter. bookId = " + bookId);
        if (bookId != null) {
            console.warn("deleteBook: bookId = " + bookId);
            this.bookService.deleteBook(bookId);
            // TODO: Refresh comment list
            this.bookService.getBooks(this.bookListSearchInfo.bookName, this.bookListSearchInfo.genreMeaning, this.bookListSearchInfo.authorName, this.bookListSearchInfo.publishingHouseName, this.bookListSearchInfo.publishingYearFrom, this.bookListSearchInfo.publishingYearTo, this.bookListSearchInfo.pagesFrom, this.bookListSearchInfo.pagesTo).subscribe(data => {
                this.books = data;
            });
            // TODO: Не обновляет страницу и все тут
            this.router.navigate(['advancedBookSearch']);
        }
    }
}
BookListComponent.ɵfac = function BookListComponent_Factory(t) { return new (t || BookListComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_book_service__WEBPACK_IMPORTED_MODULE_3__["BookService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_4__["Router"])); };
BookListComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: BookListComponent, selectors: [["app-book-list"]], decls: 80, vars: 5, consts: [[1, "row"], [1, "col-md-offset-4", "col-md-6"], [3, "formGroup", "ngSubmit"], ["searchInfo", ""], ["type", "text", "formControlName", "bookName", "placeholder", "Enter book name", 1, "form-control"], ["type", "text", "formControlName", "authorName", "placeholder", "Enter author name", 1, "form-control"], ["type", "text", "formControlName", "genreMeaning", "placeholder", "Enter genre", 1, "form-control"], ["type", "number", "formControlName", "pagesFrom", "placeholder", "Enter pages from", 1, "form-control"], ["type", "number", "formControlName", "pagesTo", "placeholder", "Enter pages to", 1, "form-control"], ["type", "text", "formControlName", "publishingHouseName", "placeholder", "Enter publishing house", 1, "form-control"], ["type", "number", "formControlName", "publishingYearFrom", "placeholder", "Enter publishing year from", 1, "form-control"], ["type", "number", "formControlName", "publishingYearTo", "placeholder", "Enter publishing year to", 1, "form-control"], [1, "btn", "btn-primary", "hidden-xs"], [1, "card", "my-5"], [1, "card-body"], [1, "table", "table-bordered", "table-striped"], [1, "thead-dark"], ["scope", "col"], [4, "ngFor", "ngForOf"], [1, "btn", "btn-primary", "mr-2", 3, "routerLink"], [3, "routerLink"], [1, "badge"], [1, "field"], [3, "click"]], template: function BookListComponent_Template(rf, ctx) { if (rf & 1) {
        const _r9 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "div", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "form", 2, 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("ngSubmit", function BookListComponent_Template_form_ngSubmit_2_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r9); const _r4 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵreference"](3); return ctx.searchForm(_r4); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "table");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "tr");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "td");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "label");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](9, I18N_0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](10, "input", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](11, "td");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](12, "label");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](13);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](14, I18N_2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](15, "input", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](16, "td");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](17, "label");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](18);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](19, I18N_4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](20, "input", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](21, "tr");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](22, "td");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](23, "label");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](24);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](25, I18N_6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](26, "input", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](27, "td");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](28, "label");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](29);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](30, I18N_8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](31, "input", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](32, "td");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](33, "tr");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](34, "td");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](35, "label");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](36);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](37, I18N_10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](38, "input", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](39, "td");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](40, "label");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](41);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](42, I18N_12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](43, "input", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](44, "td");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](45, "label");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](46);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](47, I18N_14);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](48, "input", 11);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](49, "tr");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](50, "td");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](51, "button", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](52, I18N_16);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](53, "td");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](54, "td");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](55, "div", 13);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](56, "div", 14);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](57, "table", 15);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](58, "thead", 16);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](59, "tr");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](60, "th", 17);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](61, "#");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](62, "th", 17);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](63, I18N_18);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](64, "th", 17);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](65, I18N_20);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](66, "th", 17);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](67, I18N_22);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](68, "th", 17);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](69, I18N_24);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](70, "th", 17);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](71, I18N_26);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](72, "th", 17);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](73, I18N_28);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](74, "th", 17);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](75, I18N_30);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](76, "tbody");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](77, BookListComponent_tr_77_Template, 24, 16, "tr", 18);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](78, "button", 19);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](79, I18N_32);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("formGroup", ctx.form);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](75);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngForOf", ctx.books);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("routerLink", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction1"](3, _c40, 0 - 1));
    } }, directives: [_angular_forms__WEBPACK_IMPORTED_MODULE_1__["ɵangular_packages_forms_forms_y"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["NgControlStatusGroup"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormGroupDirective"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["DefaultValueAccessor"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["NgControlStatus"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControlName"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["NumberValueAccessor"], _angular_common__WEBPACK_IMPORTED_MODULE_5__["NgForOf"], _angular_router__WEBPACK_IMPORTED_MODULE_4__["RouterLink"], _angular_router__WEBPACK_IMPORTED_MODULE_4__["RouterLinkWithHref"]], styles: [".field[_ngcontent-%COMP%] {\r\n  color: #888;\r\n  text-decoration: none;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvYm9vay1saXN0L2Jvb2stbGlzdC5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0UsV0FBVztFQUNYLHFCQUFxQjtBQUN2QiIsImZpbGUiOiJzcmMvYXBwL2Jvb2stbGlzdC9ib29rLWxpc3QuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIi5maWVsZCB7XHJcbiAgY29sb3I6ICM4ODg7XHJcbiAgdGV4dC1kZWNvcmF0aW9uOiBub25lO1xyXG59XHJcblxyXG4iXX0= */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](BookListComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'app-book-list',
                templateUrl: './book-list.component.html',
                styleUrls: ['./book-list.component.css']
            }]
    }], function () { return [{ type: _services_book_service__WEBPACK_IMPORTED_MODULE_3__["BookService"] }, { type: _angular_router__WEBPACK_IMPORTED_MODULE_4__["Router"] }]; }, null); })();


/***/ }),

/***/ "./src/app/models/book.ts":
/*!********************************!*\
  !*** ./src/app/models/book.ts ***!
  \********************************/
/*! exports provided: Book */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Book", function() { return Book; });
class Book {
    constructor(props) {
        this.id = props.id || null;
        this.name = props.name || '';
        this.publishingYear = props.publishingYear || null;
        this.pages = props.publishingYear || null;
        this.genre = props.genre || null; // new LookupValue();
        this.author = props.author || null; // new Author();
        this.publishingHouse = props.publishingHouse || null; // new PublishingHouse()
    }
}


/***/ }),

/***/ "./src/app/page-not-found/page-not-found.component.ts":
/*!************************************************************!*\
  !*** ./src/app/page-not-found/page-not-found.component.ts ***!
  \************************************************************/
/*! exports provided: PageNotFoundComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "PageNotFoundComponent", function() { return PageNotFoundComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");


var I18N_0;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_PageNotFound$$SRC_APP_PAGE_NOT_FOUND_PAGE_NOT_FOUND_COMPONENT_TS_1 = goog.getMsg("Page not found");
    I18N_0 = MSG_EXTERNAL_PageNotFound$$SRC_APP_PAGE_NOT_FOUND_PAGE_NOT_FOUND_COMPONENT_TS_1;
}
else {
    I18N_0 = "\u0421\u0442\u0440\u0430\u043D\u0438\u0446\u0430 \u043D\u0435 \u043D\u0430\u0439\u0434\u0435\u043D\u0430";
}
class PageNotFoundComponent {
    constructor() {
    }
    ngOnInit() {
    }
}
PageNotFoundComponent.ɵfac = function PageNotFoundComponent_Factory(t) { return new (t || PageNotFoundComponent)(); };
PageNotFoundComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: PageNotFoundComponent, selectors: [["app-page-not-found"]], decls: 2, vars: 0, template: function PageNotFoundComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h2");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](1, I18N_0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } }, styles: ["\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3BhZ2Utbm90LWZvdW5kL3BhZ2Utbm90LWZvdW5kLmNvbXBvbmVudC5jc3MifQ== */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](PageNotFoundComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'app-page-not-found',
                templateUrl: './page-not-found.component.html',
                styleUrls: ['./page-not-found.component.css']
            }]
    }], function () { return []; }, null); })();


/***/ }),

/***/ "./src/app/services/authguard.service.ts":
/*!***********************************************!*\
  !*** ./src/app/services/authguard.service.ts ***!
  \***********************************************/
/*! exports provided: AuthGuard */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AuthGuard", function() { return AuthGuard; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/http.js");




// https://stackoverflow.com/questions/34331478/angular-redirect-to-login-page
class AuthGuard {
    constructor(router, http) {
        this.router = router;
        this.http = http;
        this.connected = false;
        this.isConnectedUrl = 'http://localhost:8080/isConnected';
        this.loginUrl = 'http://localhost:8080/login/';
        this.logoffUrl = 'http://localhost:8080/logoff';
    }
    canActivate(route, state) {
        if (this.connected)
            return true;
        // not logged in so redirect to login page with the return url
        this.router.navigate(['/users'], { queryParams: { returnUrl: state.url } });
        return false;
    }
    login(userLogin) {
        this.http.get(this.loginUrl + userLogin).subscribe();
        this.http.get(this.isConnectedUrl).subscribe(val => {
            if (val == true) {
                console.log("Login: connected", val);
                this.connected = true;
                this.router.navigate(['advancedBookSearch']);
            }
            else {
                console.log("Login: Not connected", val);
                this.connected = false;
            }
        });
    }
    logoff() {
        this.http.get(this.logoffUrl).subscribe();
        this.connected = false;
    }
}
AuthGuard.ɵfac = function AuthGuard_Factory(t) { return new (t || AuthGuard)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"])); };
AuthGuard.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjectable"]({ token: AuthGuard, factory: AuthGuard.ɵfac, providedIn: 'root' });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](AuthGuard, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"],
        args: [{
                providedIn: 'root'
            }]
    }], function () { return [{ type: _angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"] }, { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"] }]; }, null); })();


/***/ }),

/***/ "./src/app/services/author.service.ts":
/*!********************************************!*\
  !*** ./src/app/services/author.service.ts ***!
  \********************************************/
/*! exports provided: AuthorService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AuthorService", function() { return AuthorService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/http.js");



class AuthorService {
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
}
AuthorService.ɵfac = function AuthorService_Factory(t) { return new (t || AuthorService)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"])); };
AuthorService.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjectable"]({ token: AuthorService, factory: AuthorService.ɵfac, providedIn: 'root' });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](AuthorService, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"],
        args: [{
                providedIn: 'root'
            }]
    }], function () { return [{ type: _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"] }]; }, null); })();


/***/ }),

/***/ "./src/app/services/book-service.ts":
/*!******************************************!*\
  !*** ./src/app/services/book-service.ts ***!
  \******************************************/
/*! exports provided: BookService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "BookService", function() { return BookService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/http.js");



class BookService {
    constructor(http) {
        this.http = http;
        this.booksUrl = 'http://localhost:8080/advancedBookSearch';
        this.getBookUrl = 'http://localhost:8080/book/';
        this.saveBookUrl = 'http://localhost:8080/saveBook';
        this.deleteBookUrl = 'http://localhost:8080/deleteBook/';
    }
    getBooks(bookName, genreMeaning, authorName, publishingHouseName, publishingYearFrom, publishingYearTo, pagesFrom, pagesTo) {
        console.warn("BookService.getBooks: " + bookName);
        return this.http.post(this.booksUrl, { bookName, genreMeaning, authorName, publishingHouseName,
            publishingYearFrom, publishingYearTo,
            pagesFrom, pagesTo
        });
    }
    getBook(bookId) {
        // https://angular.io/tutorial/toh-pt6
        const url = this.getBookUrl + bookId;
        return this.http.get(url);
    }
    saveBook(book) {
        console.warn("saveBookUrl: " + this.saveBookUrl);
        console.warn("saveBook: book.pages = " + book.pages);
        console.warn("saveBook: book.genre = " + book.genre.meaning);
        this.http.put(this.saveBookUrl, book)
            .subscribe(val => {
            console.log("PUT call successful value returned in body", val);
        }, response => {
            console.log("PUT call in error", response);
        }, () => {
            console.log("The PUT observable is now completed.");
        });
    }
    deleteBook(bookId) {
        const url = this.deleteBookUrl + bookId;
        console.warn("BookService: " + url);
        this.http.delete(url)
            .subscribe(val => {
            console.log("DELETE call successful value returned in body", val);
        }, response => {
            console.log("DELETE call in error", response);
        }, () => {
            console.log("The DELETE observable is now completed.");
        });
    }
}
BookService.ɵfac = function BookService_Factory(t) { return new (t || BookService)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"])); };
BookService.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjectable"]({ token: BookService, factory: BookService.ɵfac, providedIn: 'root' });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](BookService, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"],
        args: [{
                providedIn: 'root'
            }]
    }], function () { return [{ type: _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"] }]; }, null); })();


/***/ }),

/***/ "./src/app/services/comment.service.ts":
/*!*********************************************!*\
  !*** ./src/app/services/comment.service.ts ***!
  \*********************************************/
/*! exports provided: CommentService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CommentService", function() { return CommentService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/http.js");




class CommentService {
    constructor(http) {
        this.http = http;
        this.commentsUrl = 'http://localhost:8080/bookComments';
        this.getCommentUrl = 'http://localhost:8080/bookComment/';
        this.saveCommentUrl = 'http://localhost:8080/saveBookComment';
        this.deleteCommentUrl = 'http://localhost:8080/deleteBookComment/';
    }
    getBookComments(bookId) {
        let params = new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpParams"]()
            .set('bookId', bookId.toString());
        console.log(params.toString());
        return this.http.get(this.commentsUrl, { params });
    }
    getComment(commentId) {
        const url = this.getCommentUrl + commentId;
        return this.http.get(url);
    }
    saveComment(comment) {
        console.warn("saveCommentUrl: " + this.saveCommentUrl);
        this.http.put(this.saveCommentUrl, comment)
            .subscribe(val => {
            console.log("PUT call successful value returned in body", val);
        }, response => {
            console.log("PUT call in error", response);
        }, () => {
            console.log("The PUT observable is now completed.");
        });
    }
    deleteComment(commentId) {
        const url = this.deleteCommentUrl + commentId;
        this.http.delete(url)
            .subscribe(val => {
            console.log("DELETE call successful value returned in body", val);
        }, response => {
            console.log("DELETE call in error", response);
        }, () => {
            console.log("The DELETE observable is now completed.");
        });
    }
}
CommentService.ɵfac = function CommentService_Factory(t) { return new (t || CommentService)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"])); };
CommentService.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjectable"]({ token: CommentService, factory: CommentService.ɵfac, providedIn: 'root' });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](CommentService, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"],
        args: [{
                providedIn: 'root'
            }]
    }], function () { return [{ type: _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"] }]; }, null); })();


/***/ }),

/***/ "./src/app/services/lookupvalue.service.ts":
/*!*************************************************!*\
  !*** ./src/app/services/lookupvalue.service.ts ***!
  \*************************************************/
/*! exports provided: LookupValueService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LookupValueService", function() { return LookupValueService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/http.js");



class LookupValueService {
    constructor(http) {
        this.http = http;
        this.lookupValuesUrl = 'http://localhost:8080/lookupValues/';
    }
    getLookupValues(language) {
        return this.http.get(this.lookupValuesUrl + language);
    }
}
LookupValueService.ɵfac = function LookupValueService_Factory(t) { return new (t || LookupValueService)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"])); };
LookupValueService.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjectable"]({ token: LookupValueService, factory: LookupValueService.ɵfac, providedIn: 'root' });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](LookupValueService, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"],
        args: [{
                providedIn: 'root'
            }]
    }], function () { return [{ type: _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"] }]; }, null); })();


/***/ }),

/***/ "./src/app/services/publishing-house.service.ts":
/*!******************************************************!*\
  !*** ./src/app/services/publishing-house.service.ts ***!
  \******************************************************/
/*! exports provided: PublishingHouseService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "PublishingHouseService", function() { return PublishingHouseService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/http.js");



class PublishingHouseService {
    constructor(http) {
        this.http = http;
        this.publishingHousesUrl = 'http://localhost:8080/publishingHouses';
        this.getPublishingHouseUrl = 'http://localhost:8080/publishingHouse/';
    }
    getPublishingHouses() {
        return this.http.get(this.publishingHousesUrl);
    }
    getAuthor(publishingHouseId) {
        const url = this.getPublishingHouseUrl + publishingHouseId;
        return this.http.get(url);
    }
}
PublishingHouseService.ɵfac = function PublishingHouseService_Factory(t) { return new (t || PublishingHouseService)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"])); };
PublishingHouseService.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjectable"]({ token: PublishingHouseService, factory: PublishingHouseService.ɵfac, providedIn: 'root' });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](PublishingHouseService, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"],
        args: [{
                providedIn: 'root'
            }]
    }], function () { return [{ type: _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"] }]; }, null); })();


/***/ }),

/***/ "./src/app/services/user.service.ts":
/*!******************************************!*\
  !*** ./src/app/services/user.service.ts ***!
  \******************************************/
/*! exports provided: UserService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "UserService", function() { return UserService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/http.js");



class UserService {
    constructor(http) {
        this.http = http;
        this.usersUrl = 'http://localhost:8080/users';
    }
    findAll() {
        return this.http.get(this.usersUrl);
    }
}
UserService.ɵfac = function UserService_Factory(t) { return new (t || UserService)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"])); };
UserService.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjectable"]({ token: UserService, factory: UserService.ɵfac, providedIn: 'root' });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](UserService, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"],
        args: [{
                providedIn: 'root'
            }]
    }], function () { return [{ type: _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"] }]; }, null); })();


/***/ }),

/***/ "./src/app/user-list/user-list.component.ts":
/*!**************************************************!*\
  !*** ./src/app/user-list/user-list.component.ts ***!
  \**************************************************/
/*! exports provided: UserListComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "UserListComponent", function() { return UserListComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _services_user_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../services/user.service */ "./src/app/services/user.service.ts");
/* harmony import */ var _services_authguard_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../services/authguard.service */ "./src/app/services/authguard.service.ts");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");





var I18N_0;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_UserTblLogin$$SRC_APP_USER_LIST_USER_LIST_COMPONENT_TS_1 = goog.getMsg("Login");
    I18N_0 = MSG_EXTERNAL_UserTblLogin$$SRC_APP_USER_LIST_USER_LIST_COMPONENT_TS_1;
}
else {
    I18N_0 = "\u0410\u0432\u0442\u043E\u0440\u0438\u0437\u0430\u0446\u0438\u044F";
}
var I18N_2;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_UserTblName$$SRC_APP_USER_LIST_USER_LIST_COMPONENT_TS_3 = goog.getMsg("Name");
    I18N_2 = MSG_EXTERNAL_UserTblName$$SRC_APP_USER_LIST_USER_LIST_COMPONENT_TS_3;
}
else {
    I18N_2 = "\u0418\u043C\u044F";
}
var I18N_4;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_UserTblPswd$$SRC_APP_USER_LIST_USER_LIST_COMPONENT_TS_5 = goog.getMsg("Password");
    I18N_4 = MSG_EXTERNAL_UserTblPswd$$SRC_APP_USER_LIST_USER_LIST_COMPONENT_TS_5;
}
else {
    I18N_4 = "\u041F\u0430\u0440\u043E\u043B\u044C";
}
var I18N_6;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_UserTblOper$$SRC_APP_USER_LIST_USER_LIST_COMPONENT_TS_7 = goog.getMsg("Operations");
    I18N_6 = MSG_EXTERNAL_UserTblOper$$SRC_APP_USER_LIST_USER_LIST_COMPONENT_TS_7;
}
else {
    I18N_6 = "\u041E\u043F\u0435\u0440\u0430\u0446\u0438\u0438";
}
var I18N_8;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_UserTblBtnLogin$$SRC_APP_USER_LIST_USER_LIST_COMPONENT_TS__9 = goog.getMsg("Login");
    I18N_8 = MSG_EXTERNAL_UserTblBtnLogin$$SRC_APP_USER_LIST_USER_LIST_COMPONENT_TS__9;
}
else {
    I18N_8 = "\u0410\u0432\u0442\u043E\u0440\u0438\u0437\u0430\u0446\u0438\u044F";
}
function UserListComponent_tr_16_Template(rf, ctx) { if (rf & 1) {
    const _r3 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "tr");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "td");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "td");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "td");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](6);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "td");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](8);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](9, "td");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](10, "button", 6);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function UserListComponent_tr_16_Template_button_click_10_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r3); const user_r1 = ctx.$implicit; const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r2.login(user_r1.login); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](11, I18N_8);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const user_r1 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](user_r1.id);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](user_r1.login);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](user_r1.name);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](user_r1.password);
} }
class UserListComponent {
    constructor(userService, authGuard) {
        this.userService = userService;
        this.authGuard = authGuard;
    }
    ngOnInit() {
        this.userService.findAll().subscribe(data => {
            this.users = data;
        });
    }
    login(userLogin) {
        this.authGuard.login(userLogin);
    }
}
UserListComponent.ɵfac = function UserListComponent_Factory(t) { return new (t || UserListComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_user_service__WEBPACK_IMPORTED_MODULE_1__["UserService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_authguard_service__WEBPACK_IMPORTED_MODULE_2__["AuthGuard"])); };
UserListComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: UserListComponent, selectors: [["app-user-list"]], decls: 17, vars: 1, consts: [[1, "card", "my-5"], [1, "card-body"], [1, "table", "table-bordered", "table-striped"], [1, "thead-dark"], ["scope", "col"], [4, "ngFor", "ngForOf"], [3, "click"]], template: function UserListComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "div", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "table", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "thead", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "tr");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "th", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](6, "#");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "th", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](8, I18N_0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](9, "th", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](10, I18N_2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](11, "th", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](12, I18N_4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](13, "th", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](14, I18N_6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](15, "tbody");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](16, UserListComponent_tr_16_Template, 12, 4, "tr", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](16);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngForOf", ctx.users);
    } }, directives: [_angular_common__WEBPACK_IMPORTED_MODULE_3__["NgForOf"]], styles: ["\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3VzZXItbGlzdC91c2VyLWxpc3QuY29tcG9uZW50LmNzcyJ9 */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](UserListComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'app-user-list',
                templateUrl: './user-list.component.html',
                styleUrls: ['./user-list.component.css']
            }]
    }], function () { return [{ type: _services_user_service__WEBPACK_IMPORTED_MODULE_1__["UserService"] }, { type: _services_authguard_service__WEBPACK_IMPORTED_MODULE_2__["AuthGuard"] }]; }, null); })();


/***/ }),

/***/ "./src/environments/environment.ts":
/*!*****************************************!*\
  !*** ./src/environments/environment.ts ***!
  \*****************************************/
/*! exports provided: environment */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "environment", function() { return environment; });
// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.
const environment = {
    production: false
};
/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.


/***/ }),

/***/ "./src/main.ts":
/*!*********************!*\
  !*** ./src/main.ts ***!
  \*********************/
/*! no exports provided */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./environments/environment */ "./src/environments/environment.ts");
/* harmony import */ var _app_app_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app/app.module */ "./src/app/app.module.ts");
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/__ivy_ngcc__/fesm2015/platform-browser.js");




if (_environments_environment__WEBPACK_IMPORTED_MODULE_1__["environment"].production) {
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["enableProdMode"])();
}
_angular_platform_browser__WEBPACK_IMPORTED_MODULE_3__["platformBrowser"]().bootstrapModule(_app_app_module__WEBPACK_IMPORTED_MODULE_2__["AppModule"])
    .catch(err => console.error(err));


/***/ }),

/***/ 0:
/*!***************************!*\
  !*** multi ./src/main.ts ***!
  \***************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(/*! C:\_P\OTUSSpring\2019-11-otus-spring-lyulin\library-spring-rest\angularclient\src\main.ts */"./src/main.ts");


/***/ })

},[[0,"runtime","vendor"]]]);
//# sourceMappingURL=main-es2015.js.map