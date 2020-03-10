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
     // Как установить значение в контрол
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
        // TODO: Не обновляет страницу и все тут
        this.router.navigate(['advancedBookSearch']);
      }
    }
}
