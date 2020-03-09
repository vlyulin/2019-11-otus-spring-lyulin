import { LookupValue } from './lookup-value';
import { Author } from './author';
import { PublishingHouse } from './publishing-house';

export class Book {
      constructor(props: {
        id?: number,
        name?: string,
        publishingYear?: number,
        pages?: number,
        genre?: LookupValue,
        author?: Author,
        publishingHouse?: PublishingHouse,
      }) {
        this.id = props.id || null;
        this.name = props.name || '';
        this.publishingYear = props.publishingYear || null;
        this.pages = props.publishingYear || null;
        this.genre = props.genre || null; // new LookupValue();
        this.author = props.author || null; // new Author();
        this.publishingHouse = props.publishingHouse || null; // new PublishingHouse()
      }

      id?: number;
      name?: string;
      publishingYear?: number;
      pages?: number;
      genre?: LookupValue;
      author?: Author;
      publishingHouse?: PublishingHouse;
}
