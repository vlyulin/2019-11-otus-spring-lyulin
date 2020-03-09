import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormControl, ReactiveFormsModule } from '@angular/forms';
import { Book } from '../models/book';
import { BookService } from '../services/book-service';
import { BookListSearchInfo } from './book-list-search-info';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {

  books: Book[];
  form: FormGroup;
  private bookListSearchInfo: BookListSearchInfo;

  constructor(
    private bookService: BookService,
    private router: Router
  ) {
  }

  ngOnInit(): void {
     if( this.bookListSearchInfo == null ) {
       this.bookListSearchInfo = new BookListSearchInfo();
     }

     this.form = new FormGroup({
               bookName : new FormControl(),
               genreMeaning : new FormControl(),
               authorName : new FormControl(),
               publishingHouseName : new FormControl(),
               publishingYearFrom : new FormControl(),
               publishingYearTo : new FormControl(),
               pagesFrom : new FormControl(),
               pagesTo : new FormControl()
             });
     // TODO: Повторяемость фильтра при возврате на страницу книг
     // this.form.controls['bookName'].setValue('%ядов%');
  }

  searchForm(searchInfo)
  {
      console.warn('searchForm: enter');

      this.bookListSearchInfo.bookName = this.form.get('bookName').value;
      this.bookListSearchInfo.genreMeaning = this.form.get('genreMeaning').value;
      this.bookListSearchInfo.authorName = this.form.get('authorName').value;
      this.bookListSearchInfo.publishingHouseName = this.form.get('publishingHouseName').value;
      this.bookListSearchInfo.publishingYearFrom = this.form.get('publishingYearFrom').value;
      this.bookListSearchInfo.publishingYearTo = this.form.get('publishingYearTo').value;
      this.bookListSearchInfo.pagesFrom = this.form.get('pagesFrom').value;
      this.bookListSearchInfo.pagesTo = this.form.get('pagesTo').value;

      this.bookService.getBooks(
        this.form.get('bookName').value, // || '%ядов%',
        this.form.get('genreMeaning').value,
        this.form.get('authorName').value,
        this.form.get('publishingHouseName').value,
        this.form.get('publishingYearFrom').value,
        this.form.get('publishingYearTo').value,
        this.form.get('pagesFrom').value,
        this.form.get('pagesTo').value
      ).subscribe( data => {
        this.books = data;
      });
  }

  // clearSearch() {
  //   console.warn('clearSearch: enter');
  //   this.bookListSearchInfo.bookName = null;
  //   this.bookListSearchInfo.genreMeaning = null;
  //   this.bookListSearchInfo.authorName = null;
  //   this.bookListSearchInfo.publishingHouseName = null;
  //   this.bookListSearchInfo.publishingYearFrom = null;
  //   this.bookListSearchInfo.publishingYearTo = null;
  //   this.bookListSearchInfo.pagesFrom = null;
  //   this.bookListSearchInfo.pagesTo = null;
//
  //   this.form.controls['bookName'].setValue(null);
  //   this.form.controls['genreMeaning'].setValue(null);
  //   this.form.controls['authorName'].setValue(null);
  //   this.form.controls['publishingHouseName'].setValue(null);
  //   this.form.controls['publishingYearFrom'].setValue(null);
  //   this.form.controls['publishingYearTo'].setValue(null);
  //   this.form.controls['pagesFrom'].setValue(null);
  //   this.form.controls['pagesTo'].setValue(null);
//
  //   this.books = [];
  //   this.clearFlag = true;
  // }

  deleteBook( bookId : number | string ) {
      console.warn("deleteBook: enter. bookId = " + bookId);
      if( bookId != null ) {
        console.warn("deleteBook: bookId = " + bookId);
        this.bookService.deleteBook( bookId );
        // TODO: Refresh comment list
        this.bookService.getBooks(
                this.bookListSearchInfo.bookName,
                this.bookListSearchInfo.genreMeaning,
                this.bookListSearchInfo.authorName,
                this.bookListSearchInfo.publishingHouseName,
                this.bookListSearchInfo.publishingYearFrom,
                this.bookListSearchInfo.publishingYearTo,
                this.bookListSearchInfo.pagesFrom,
                this.bookListSearchInfo.pagesTo
              ).subscribe( data => {
                this.books = data;
              });
        // TODO: Не обновляет страницу
        this.router.navigate(['advancedBookSearch']);
      }
    }
}
