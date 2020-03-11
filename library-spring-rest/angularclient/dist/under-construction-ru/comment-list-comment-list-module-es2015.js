(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["comment-list-comment-list-module"],{

/***/ "./src/app/comment-list/comment-detail/comment-detail.component.ts":
/*!*************************************************************************!*\
  !*** ./src/app/comment-list/comment-detail/comment-detail.component.ts ***!
  \*************************************************************************/
/*! exports provided: CommentDetailComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CommentDetailComponent", function() { return CommentDetailComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm2015/index.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm2015/operators/index.js");
/* harmony import */ var _models_comment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../models/comment */ "./src/app/models/comment.ts");
/* harmony import */ var _models_user__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../models/user */ "./src/app/models/user.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
/* harmony import */ var _services_comment_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../../services/comment.service */ "./src/app/services/comment.service.ts");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");










var I18N_0;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_EditCmtComment$$SRC_APP_COMMENT_LIST_COMMENT_DETAIL_COMMENT_DETAIL_COMPONENT_TS_1 = goog.getMsg("Comment:");
    I18N_0 = MSG_EXTERNAL_EditCmtComment$$SRC_APP_COMMENT_LIST_COMMENT_DETAIL_COMMENT_DETAIL_COMPONENT_TS_1;
}
else {
    I18N_0 = "\u041A\u043E\u043C\u043C\u0435\u043D\u0442\u0430\u0440\u0438\u0439:";
}
var I18N_2;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_EditCmtHint$$SRC_APP_COMMENT_LIST_COMMENT_DETAIL_COMMENT_DETAIL_COMPONENT_TS_3 = goog.getMsg("Don't hesistate to write trurh");
    I18N_2 = MSG_EXTERNAL_EditCmtHint$$SRC_APP_COMMENT_LIST_COMMENT_DETAIL_COMMENT_DETAIL_COMPONENT_TS_3;
}
else {
    I18N_2 = "\u041D\u0435 \u0441\u0442\u0435\u0441\u043D\u044F\u0439\u0442\u0435\u0441\u044C \u0432 \u0432\u044B\u0440\u0430\u0436\u0435\u043D\u0438\u044F\u0445";
}
var I18N_4;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_EditCmtBtnSave$$SRC_APP_COMMENT_LIST_COMMENT_DETAIL_COMMENT_DETAIL_COMPONENT_TS_5 = goog.getMsg("Save");
    I18N_4 = MSG_EXTERNAL_EditCmtBtnSave$$SRC_APP_COMMENT_LIST_COMMENT_DETAIL_COMMENT_DETAIL_COMPONENT_TS_5;
}
else {
    I18N_4 = "\u0421\u043E\u0445\u0440\u0430\u043D\u0438\u0442\u044C";
}
var I18N_6;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_EditCmtBtnCancel$$SRC_APP_COMMENT_LIST_COMMENT_DETAIL_COMMENT_DETAIL_COMPONENT_TS_7 = goog.getMsg("Cancel");
    I18N_6 = MSG_EXTERNAL_EditCmtBtnCancel$$SRC_APP_COMMENT_LIST_COMMENT_DETAIL_COMMENT_DETAIL_COMPONENT_TS_7;
}
else {
    I18N_6 = "\u041E\u0442\u043C\u0435\u043D\u0438\u0442\u044C";
}
class CommentDetailComponent {
    constructor(route, router, commentService, location) {
        this.route = route;
        this.router = router;
        this.commentService = commentService;
        this.location = location;
    }
    ngOnInit() {
        // Получение параметра
        // https://stackoverflow.com/questions/40275862/how-to-get-parameter-on-angular2-route-in-angular-way
        this.route.paramMap.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["switchMap"])((params) => {
            let commentId = params.get('commentId');
            if (commentId != '-1') {
                return this.commentService.getComment(commentId);
            }
            else {
                return rxjs__WEBPACK_IMPORTED_MODULE_1__["EMPTY"];
            }
        })).subscribe(cmt => {
            console.warn("comment.comment = " + cmt.comment);
            this.comment = cmt;
            this.editCommentText = cmt.comment;
        });
    }
    onSubmit(f) {
        let bookId = this.route.snapshot.paramMap.get('bookId');
        let commentId = this.route.snapshot.paramMap.get('commentId');
        console.warn("On Save commit bookId = " + bookId + " commentId = " + commentId);
        if (commentId == '-1') {
            this.comment = new _models_comment__WEBPACK_IMPORTED_MODULE_3__["Comment"]();
            this.comment.bookId = +bookId;
            this.comment.createdBy = new _models_user__WEBPACK_IMPORTED_MODULE_4__["User"]();
        }
        if (this.comment.comment != this.editCommentText) {
            console.warn("Comment changed. Saving...");
            this.comment.comment = this.editCommentText;
            this.commentService.saveComment(this.comment);
        }
        this.router.navigate(['bookComments', bookId]);
    }
    cancel() {
        let bookId = this.route.snapshot.paramMap.get('bookId');
        this.router.navigate(['bookComments', bookId]);
    }
    deleteComment(commentId) {
        console.warn('deleteComment: commentId = ' + commentId);
        this.commentService.deleteComment(commentId);
    }
}
CommentDetailComponent.ɵfac = function CommentDetailComponent_Factory(t) { return new (t || CommentDetailComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_5__["ActivatedRoute"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_5__["Router"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_comment_service__WEBPACK_IMPORTED_MODULE_6__["CommentService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_common__WEBPACK_IMPORTED_MODULE_7__["Location"])); };
CommentDetailComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: CommentDetailComponent, selectors: [["app-comment-detail"]], decls: 12, vars: 2, consts: [["name", "editComment", 1, "gf-formbox", 3, "ngSubmit"], ["f", "ngForm"], [1, "form-group"], ["rows", "5", "id", "gf-comment", "name", "comment", 1, "form-control", 3, "ngModel", "ngModelChange"], ["id", "commentInfo", 1, "form-text", "text-muted"], ["type", "submit", 1, "btn", "btn-primary", "mr-2", 3, "disabled"], ["type", "cancel", 1, "btn", "btn-primary"]], template: function CommentDetailComponent_Template(rf, ctx) { if (rf & 1) {
        const _r33 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "form", 0, 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("ngSubmit", function CommentDetailComponent_Template_form_ngSubmit_0_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r33); const _r32 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵreference"](1); return ctx.onSubmit(_r32); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "div", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "h2");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](4, I18N_0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "textarea", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("ngModelChange", function CommentDetailComponent_Template_textarea_ngModelChange_5_listener($event) { return ctx.editCommentText = $event; });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "small", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](7, I18N_2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](8, "button", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](9, I18N_4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](10, "button", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](11, I18N_6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } if (rf & 2) {
        const _r32 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵreference"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngModel", ctx.editCommentText);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("disabled", _r32.pristine);
    } }, directives: [_angular_forms__WEBPACK_IMPORTED_MODULE_8__["ɵangular_packages_forms_forms_y"], _angular_forms__WEBPACK_IMPORTED_MODULE_8__["NgControlStatusGroup"], _angular_forms__WEBPACK_IMPORTED_MODULE_8__["NgForm"], _angular_forms__WEBPACK_IMPORTED_MODULE_8__["DefaultValueAccessor"], _angular_forms__WEBPACK_IMPORTED_MODULE_8__["NgControlStatus"], _angular_forms__WEBPACK_IMPORTED_MODULE_8__["NgModel"]], styles: ["\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2NvbW1lbnQtbGlzdC9jb21tZW50LWRldGFpbC9jb21tZW50LWRldGFpbC5jb21wb25lbnQuY3NzIn0= */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](CommentDetailComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'app-comment-detail',
                templateUrl: './comment-detail.component.html',
                styleUrls: ['./comment-detail.component.css']
            }]
    }], function () { return [{ type: _angular_router__WEBPACK_IMPORTED_MODULE_5__["ActivatedRoute"] }, { type: _angular_router__WEBPACK_IMPORTED_MODULE_5__["Router"] }, { type: _services_comment_service__WEBPACK_IMPORTED_MODULE_6__["CommentService"] }, { type: _angular_common__WEBPACK_IMPORTED_MODULE_7__["Location"] }]; }, null); })();


/***/ }),

/***/ "./src/app/comment-list/comment-list-routing.module.ts":
/*!*************************************************************!*\
  !*** ./src/app/comment-list/comment-list-routing.module.ts ***!
  \*************************************************************/
/*! exports provided: CommentListRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CommentListRoutingModule", function() { return CommentListRoutingModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
/* harmony import */ var _comment_list_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./comment-list.component */ "./src/app/comment-list/comment-list.component.ts");
/* harmony import */ var _comment_detail_comment_detail_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./comment-detail/comment-detail.component */ "./src/app/comment-list/comment-detail/comment-detail.component.ts");






// https://stackblitz.com/angular/oyybmeleexvo?file=src%2Fapp%2Fcrisis-center%2Fcrisis-center-routing.module.ts
// https://angular-2-training-book.rangle.io/routing/child_routes
// С ресолвером для редактирования на одной и той же странице не получилось
// resolve: {
//   comment: CommentDetailResolverService
// }
const commentListRoutes = [
    { path: '', component: _comment_list_component__WEBPACK_IMPORTED_MODULE_2__["CommentListComponent"] },
    { path: 'comment/:commentId', component: _comment_detail_comment_detail_component__WEBPACK_IMPORTED_MODULE_3__["CommentDetailComponent"] }
];
class CommentListRoutingModule {
}
CommentListRoutingModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({ type: CommentListRoutingModule });
CommentListRoutingModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({ factory: function CommentListRoutingModule_Factory(t) { return new (t || CommentListRoutingModule)(); }, imports: [[
            _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(commentListRoutes)
        ],
        _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]] });
(function () { (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](CommentListRoutingModule, { imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]], exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]] }); })();
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](CommentListRoutingModule, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
        args: [{
                imports: [
                    _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(commentListRoutes)
                ],
                exports: [
                    _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]
                ]
            }]
    }], null, null); })();


/***/ }),

/***/ "./src/app/comment-list/comment-list.component.ts":
/*!********************************************************!*\
  !*** ./src/app/comment-list/comment-list.component.ts ***!
  \********************************************************/
/*! exports provided: CommentListComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CommentListComponent", function() { return CommentListComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm2015/index.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm2015/operators/index.js");
/* harmony import */ var _models_user__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../models/user */ "./src/app/models/user.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
/* harmony import */ var _services_comment_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../services/comment.service */ "./src/app/services/comment.service.ts");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");








var I18N_0;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_CmntTblComment$$SRC_APP_COMMENT_LIST_COMMENT_LIST_COMPONENT_TS_1 = goog.getMsg("Comment");
    I18N_0 = MSG_EXTERNAL_CmntTblComment$$SRC_APP_COMMENT_LIST_COMMENT_LIST_COMPONENT_TS_1;
}
else {
    I18N_0 = "\u041A\u043E\u043C\u043C\u0435\u043D\u0442\u0430\u0440\u0438\u0439";
}
var I18N_2;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_CmntTblCreatedBy$$SRC_APP_COMMENT_LIST_COMMENT_LIST_COMPONENT_TS_3 = goog.getMsg("Created by");
    I18N_2 = MSG_EXTERNAL_CmntTblCreatedBy$$SRC_APP_COMMENT_LIST_COMMENT_LIST_COMPONENT_TS_3;
}
else {
    I18N_2 = "\u0421\u043E\u0437\u0434\u0430\u043D";
}
var I18N_4;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_CmntTblCreationDate$$SRC_APP_COMMENT_LIST_COMMENT_LIST_COMPONENT_TS_5 = goog.getMsg("Creation date");
    I18N_4 = MSG_EXTERNAL_CmntTblCreationDate$$SRC_APP_COMMENT_LIST_COMMENT_LIST_COMPONENT_TS_5;
}
else {
    I18N_4 = "\u0414\u0430\u0442\u0430 \u0441\u043E\u043E\u0437\u0434\u0430\u043D\u0438\u044F";
}
var I18N_6;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_CmntTblUpdatedBy$$SRC_APP_COMMENT_LIST_COMMENT_LIST_COMPONENT_TS_7 = goog.getMsg("Updated by");
    I18N_6 = MSG_EXTERNAL_CmntTblUpdatedBy$$SRC_APP_COMMENT_LIST_COMMENT_LIST_COMPONENT_TS_7;
}
else {
    I18N_6 = "\u0418\u0437\u043C\u0435\u043D\u0435\u043D\u043E";
}
var I18N_8;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_CmntTblLastUpdDate$$SRC_APP_COMMENT_LIST_COMMENT_LIST_COMPONENT_TS_9 = goog.getMsg("Last update date");
    I18N_8 = MSG_EXTERNAL_CmntTblLastUpdDate$$SRC_APP_COMMENT_LIST_COMMENT_LIST_COMPONENT_TS_9;
}
else {
    I18N_8 = "\u0414\u0430\u0442\u0430 \u0438\u0437\u043C\u0435\u043D\u0435\u043D\u0438\u044F";
}
var I18N_10;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_CmntTblOpers$$SRC_APP_COMMENT_LIST_COMMENT_LIST_COMPONENT_TS_11 = goog.getMsg("Operations");
    I18N_10 = MSG_EXTERNAL_CmntTblOpers$$SRC_APP_COMMENT_LIST_COMMENT_LIST_COMPONENT_TS_11;
}
else {
    I18N_10 = "\u041E\u043F\u0435\u0440\u0430\u0446\u0438\u0438";
}
var I18N_12;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_CmntBtnComment$$SRC_APP_COMMENT_LIST_COMMENT_LIST_COMPONENT_TS_13 = goog.getMsg("Comment");
    I18N_12 = MSG_EXTERNAL_CmntBtnComment$$SRC_APP_COMMENT_LIST_COMMENT_LIST_COMPONENT_TS_13;
}
else {
    I18N_12 = "\u041A\u043E\u043C\u043C\u0435\u043D\u0442\u0438\u0440\u043E\u0432\u0430\u0442\u044C";
}
var I18N_14;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_CmntBtnBack$$SRC_APP_COMMENT_LIST_COMMENT_LIST_COMPONENT_TS_15 = goog.getMsg("Back");
    I18N_14 = MSG_EXTERNAL_CmntBtnBack$$SRC_APP_COMMENT_LIST_COMMENT_LIST_COMPONENT_TS_15;
}
else {
    I18N_14 = "\u041D\u0430\u0437\u0430\u0434";
}
var I18N_16;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_CmntBtnEdit$$SRC_APP_COMMENT_LIST_COMMENT_LIST_COMPONENT_TS__17 = goog.getMsg("Edit");
    I18N_16 = MSG_EXTERNAL_CmntBtnEdit$$SRC_APP_COMMENT_LIST_COMMENT_LIST_COMPONENT_TS__17;
}
else {
    I18N_16 = "\u0420\u0435\u0434\u0430\u043A\u0442\u0438\u0440\u043E\u0432\u0430\u0442\u044C";
}
var I18N_18;
if (typeof ngI18nClosureMode !== "undefined" && ngI18nClosureMode) {
    const MSG_EXTERNAL_CmntBtnDel$$SRC_APP_COMMENT_LIST_COMMENT_LIST_COMPONENT_TS__19 = goog.getMsg("Delete");
    I18N_18 = MSG_EXTERNAL_CmntBtnDel$$SRC_APP_COMMENT_LIST_COMMENT_LIST_COMPONENT_TS__19;
}
else {
    I18N_18 = "\u0423\u0434\u0430\u043B\u0438\u0442\u044C";
}
const _c20 = function (a0, a1) { return [a0, a1]; };
const _c21 = function (a1) { return ["comment", a1]; };
function CommentListComponent_tr_20_Template(rf, ctx) { if (rf & 1) {
    const _r31 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "tr");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "td");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "td");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "a", 8);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "td");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](7);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](8, "td");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](9);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](10, "td");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](11);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](12, "td");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](13);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](14, "td");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](15, "button", 9);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](16, I18N_16);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](17, "button", 10);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function CommentListComponent_tr_20_Template_button_click_17_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r31); const comment_r29 = ctx.$implicit; const ctx_r30 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r30.deleteComment(comment_r29.commentId); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](18, I18N_18);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const comment_r29 = ctx.$implicit;
    const ctx_r28 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](comment_r29.commentId);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("routerLink", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction2"](8, _c20, ctx_r28.commentPath, comment_r29.commentId));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](comment_r29.comment);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](comment_r29.createdBy.name);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](comment_r29.creationDate);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](comment_r29.lastUpdatedBy.name);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](comment_r29.lastUpdateDate);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("routerLink", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction1"](11, _c21, comment_r29.commentId));
} }
class CommentListComponent {
    // https://www.tektutorialshub.com/angular/angular-pass-url-parameters-query-strings/
    constructor(route, commentService, router) {
        this.route = route;
        this.commentService = commentService;
        this.router = router;
        this.commentPath = 'comment/';
    }
    ngOnInit() {
        // Получение параметра
        // https://stackoverflow.com/questions/40275862/how-to-get-parameter-on-angular2-route-in-angular-way
        this.comments$ = this.route.paramMap.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["switchMap"])((params) => {
            let bookId = +params.get('bookId');
            console.warn('this.bookId = ' + bookId);
            if (bookId != -1) {
                return this.commentService.getBookComments(bookId);
            }
            else {
                return rxjs__WEBPACK_IMPORTED_MODULE_1__["EMPTY"];
            }
        }));
        this.comments$.subscribe(data => {
            this.comments = data;
            // Если comment.lastUpdatedBy пустой, то ломался template (html)
            this.comments.forEach(function (comment) {
                if (comment.lastUpdatedBy == null) {
                    comment.lastUpdatedBy = new _models_user__WEBPACK_IMPORTED_MODULE_3__["User"]();
                }
            });
        });
    }
    goBack() {
        this.router.navigate(['advancedBookSearch']);
    }
    deleteComment(commentId) {
        if (commentId) {
            this.commentService.deleteComment(commentId);
            // TODO: Refresh comment list
            let bookId = this.route.snapshot.paramMap.get('bookId');
            console.warn('deleteComment bookId = ' + bookId);
            this.router.navigate(['bookComments', bookId]);
        }
    }
}
CommentListComponent.ɵfac = function CommentListComponent_Factory(t) { return new (t || CommentListComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_4__["ActivatedRoute"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_comment_service__WEBPACK_IMPORTED_MODULE_5__["CommentService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_4__["Router"])); };
CommentListComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: CommentListComponent, selectors: [["app-comment-list"]], decls: 25, vars: 4, consts: [[1, "card", "my-5"], [1, "card-body"], [1, "table", "table-bordered", "table-striped"], [1, "thead-dark"], ["scope", "col"], [4, "ngFor", "ngForOf"], [1, "btn", "btn-primary", "mr-2", 3, "routerLink"], [1, "btn", "btn-primary", 3, "click"], [3, "routerLink"], [1, "mr-2", 3, "routerLink"], [3, "click"]], template: function CommentListComponent_Template(rf, ctx) { if (rf & 1) {
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
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](15, "th", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](16, I18N_8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](17, "th", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](18, I18N_10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](19, "tbody");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](20, CommentListComponent_tr_20_Template, 19, 13, "tr", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](21, "button", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](22, I18N_12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](23, "button", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function CommentListComponent_Template_button_click_23_listener($event) { return ctx.goBack(); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵi18n"](24, I18N_14);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](20);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngForOf", ctx.comments);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("routerLink", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction1"](2, _c21, 0 - 1));
    } }, directives: [_angular_common__WEBPACK_IMPORTED_MODULE_6__["NgForOf"], _angular_router__WEBPACK_IMPORTED_MODULE_4__["RouterLink"], _angular_router__WEBPACK_IMPORTED_MODULE_4__["RouterLinkWithHref"]], styles: ["\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2NvbW1lbnQtbGlzdC9jb21tZW50LWxpc3QuY29tcG9uZW50LmNzcyJ9 */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](CommentListComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'app-comment-list',
                templateUrl: './comment-list.component.html',
                styleUrls: ['./comment-list.component.css']
            }]
    }], function () { return [{ type: _angular_router__WEBPACK_IMPORTED_MODULE_4__["ActivatedRoute"] }, { type: _services_comment_service__WEBPACK_IMPORTED_MODULE_5__["CommentService"] }, { type: _angular_router__WEBPACK_IMPORTED_MODULE_4__["Router"] }]; }, null); })();


/***/ }),

/***/ "./src/app/comment-list/comment-list.module.ts":
/*!*****************************************************!*\
  !*** ./src/app/comment-list/comment-list.module.ts ***!
  \*****************************************************/
/*! exports provided: CommentListModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CommentListModule", function() { return CommentListModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
/* harmony import */ var _comment_list_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./comment-list.component */ "./src/app/comment-list/comment-list.component.ts");
/* harmony import */ var _comment_list_routing_module__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./comment-list-routing.module */ "./src/app/comment-list/comment-list-routing.module.ts");
/* harmony import */ var _comment_detail_comment_detail_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./comment-detail/comment-detail.component */ "./src/app/comment-list/comment-detail/comment-detail.component.ts");
/* harmony import */ var _services_comment_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../services/comment.service */ "./src/app/services/comment.service.ts");








class CommentListModule {
}
CommentListModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({ type: CommentListModule });
CommentListModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({ factory: function CommentListModule_Factory(t) { return new (t || CommentListModule)(); }, providers: [_services_comment_service__WEBPACK_IMPORTED_MODULE_6__["CommentService"]], imports: [[
            _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormsModule"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_2__["ReactiveFormsModule"],
            _comment_list_routing_module__WEBPACK_IMPORTED_MODULE_4__["CommentListRoutingModule"]
        ]] });
(function () { (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](CommentListModule, { declarations: [_comment_list_component__WEBPACK_IMPORTED_MODULE_3__["CommentListComponent"],
        _comment_detail_comment_detail_component__WEBPACK_IMPORTED_MODULE_5__["CommentDetailComponent"]], imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
        _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormsModule"],
        _angular_forms__WEBPACK_IMPORTED_MODULE_2__["ReactiveFormsModule"],
        _comment_list_routing_module__WEBPACK_IMPORTED_MODULE_4__["CommentListRoutingModule"]] }); })();
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](CommentListModule, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
        args: [{
                imports: [
                    _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                    _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormsModule"],
                    _angular_forms__WEBPACK_IMPORTED_MODULE_2__["ReactiveFormsModule"],
                    _comment_list_routing_module__WEBPACK_IMPORTED_MODULE_4__["CommentListRoutingModule"]
                ],
                declarations: [
                    _comment_list_component__WEBPACK_IMPORTED_MODULE_3__["CommentListComponent"],
                    _comment_detail_comment_detail_component__WEBPACK_IMPORTED_MODULE_5__["CommentDetailComponent"]
                ],
                providers: [_services_comment_service__WEBPACK_IMPORTED_MODULE_6__["CommentService"]]
            }]
    }], null, null); })();


/***/ }),

/***/ "./src/app/models/comment.ts":
/*!***********************************!*\
  !*** ./src/app/models/comment.ts ***!
  \***********************************/
/*! exports provided: Comment */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Comment", function() { return Comment; });
class Comment {
}


/***/ }),

/***/ "./src/app/models/user.ts":
/*!********************************!*\
  !*** ./src/app/models/user.ts ***!
  \********************************/
/*! exports provided: User */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "User", function() { return User; });
class User {
}


/***/ })

}]);
//# sourceMappingURL=comment-list-comment-list-module-es2015.js.map