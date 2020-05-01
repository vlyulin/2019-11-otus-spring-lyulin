export class Book {
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
//# sourceMappingURL=book.js.map