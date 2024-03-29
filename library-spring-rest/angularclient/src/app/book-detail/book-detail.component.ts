import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { Observable, EMPTY } from 'rxjs';
import { of } from 'rxjs';
import { switchMap } from 'rxjs/operators';
import { FormsModule } from '@angular/forms';
import { LookupValue } from '../models/lookup-value';
import { Book } from '../models/book';
import { BookService }  from '../services/book-service';
import { Author } from '../models/author';
import { LookupValueService } from '../services/lookupvalue.service';
import { AuthorService } from '../services/author.service';
import { PublishingHouse } from '../models/publishing-house';
import { PublishingHouseService } from '../services/publishing-house.service';
import { forkJoin } from 'rxjs';  // RxJS 6 syntax

// https://angular.io/guide/reactive-forms
@Component({
  selector: 'app-book-detail',
  templateUrl: './book-detail.component.html',
  styleUrls: ['./book-detail.component.css']
})
export class BookDetailComponent implements OnInit {

  book$: Observable<Book>;
  book: Book;
  genres: LookupValue[];
  authors: Author[];
  publishingHouses: PublishingHouse[];

  public authorForm: FormGroup;
  public publishingHouseForm: FormGroup;
  public bookForm: FormGroup;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private bookService: BookService,
    private lookupValueService: LookupValueService,
    private authorService: AuthorService,
    private publishingHouseService: PublishingHouseService
  ) {
    // Validators:
    // https://malcoded.com/posts/angular-reactive-form-validation/
    // https://angular.io/guide/form-validation
    this.bookForm = new FormGroup({
         id : new FormControl(),
         name : new FormControl('', [Validators.required]),
         publishingYear : new FormControl('', [Validators.required, Validators.pattern("^[0-9]*$")]),
         pages : new FormControl('', [Validators.required, Validators.pattern("^[0-9]*$")]),
         genre : new FormControl('', [Validators.required]),
         author : new FormControl('', [Validators.required]),
         publishingHouse : new FormControl('', [Validators.required])
       });
  }

  // convenience getter for easy access to form fields
  get f() { return this.bookForm.controls; }

  // Анимация: https://webformyself.com/glubokoe-pogruzhenie-v-veb-animaciyu-s-angular/
  // https://angular.io/guide/router#activated-route-in-action
  // Не до мультиков.
  ngOnInit(): void {

    // https://levelup.gitconnected.com/handle-multiple-api-requests-in-angular-using-mergemap-and-forkjoin-to-avoid-nested-subscriptions-a20fb5040d0c
    this.book$ = this.route.paramMap.pipe(
        switchMap((params: ParamMap) => {
          let bookId = params.get('bookId');
          // Если bookId = -1, то это создание новой книги
          if(bookId != '-1') {
            return this.bookService.getBook(bookId);
          }

          // Возвращаем пустой экземпляр книги при создании новой книги
          return of(new Book({}));
        })
    );

    this.book$.subscribe( book => {
         this.book = book;
         console.warn("book.name = " + book.name);
         forkJoin(
            [this.lookupValueService.getLookupValues('RU'), this.authorService.getAuthors(), this.publishingHouseService.getPublishingHouses()]
         ).subscribe( result => {
                    this.genres = result[0];
                    this.authors = result[1];
                    this.publishingHouses = result[2];

                    if (book.id) {
                        // Редктирование книги. Заполнение полей web формы
                        this.bookForm.setValue({
                              id : this.book.id,
                              name : this.book.name,
                              publishingYear : this.book.publishingYear,
                              pages : this.book.pages,
                              genre : this.genres.find(x => x.key.lookupCode === book.genre.key.lookupCode),
                              author : this.authors.find(x => x.id === book.author.id),
                              publishingHouse : this.publishingHouses.find(x => x.id == book.publishingHouse.id)
                            });
                    }
               });
    });
  }

  onSubmit() : void {
    this.book.id = this.bookForm.value.id;
    this.book.name = this.bookForm.value.name;
    this.book.publishingYear = this.bookForm.value.publishingYear;
    this.book.pages = this.bookForm.value.pages;
    this.book.genre = this.bookForm.value.genre;
    this.book.author = this.bookForm.value.author;
    this.book.publishingHouse = this.bookForm.value.publishingHouse;
    this.bookService.saveBook(this.book);
    this.router.navigate(['advancedBookSearch'])
  }

  cancel() {
    this.router.navigate(['advancedBookSearch']);
  }
}
