import { __decorate } from "tslib";
import { Component } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { BookListSearchInfo } from './book-list-search-info';
let BookListComponent = class BookListComponent {
    constructor(bookService, router) {
        this.bookService = bookService;
        this.router = router;
    }
    ngOnInit() {
        console.warn("XXX BookListComponent Enter ngOnInit");
        if (this.bookListSearchInfo == null) {
            this.bookListSearchInfo = new BookListSearchInfo();
        }
        this.form = new FormGroup({
            bookName: new FormControl(),
            genreMeaning: new FormControl(),
            authorName: new FormControl(),
            publishingHouseName: new FormControl(),
            publishingYearFrom: new FormControl(),
            publishingYearTo: new FormControl(),
            pagesFrom: new FormControl(),
            pagesTo: new FormControl()
        });
        // Как установить значение в контрол
        // this.form.controls['bookName'].setValue('%ядов%');
        console.warn("XXX BookListComponent Exit ngOnInit");
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
};
BookListComponent = __decorate([
    Component({
        selector: 'app-book-list',
        templateUrl: './book-list.component.html',
        styleUrls: ['./book-list.component.css']
    })
], BookListComponent);
export { BookListComponent };
//# sourceMappingURL=book-list.component.js.map