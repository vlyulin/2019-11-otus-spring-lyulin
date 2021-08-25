// Была попытка сохранения фильтра при возврате на страницу
// За неимением достаточности времени отложил данную идею,
// но выбрасывать наработку жалко
export class BookListSearchInfo {
  bookName?: string;
  genreMeaning?: string;
  authorName?: string;
  publishingHouseName?: string;
  publishingYearFrom?: number;
  publishingYearTo?: number;
  pagesFrom?: number;
  pagesTo?: number;
}
