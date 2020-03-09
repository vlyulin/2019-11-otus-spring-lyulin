export class Book {
      id: long;
      name: string;
      publishingYear: int;
      pages: int;
      genre: LookupValue;
      author: Author;
      publishingHouse: PublishingHouse;
}
