import { User } from './user';

export class Comment {
  commentId: number;
  bookId: number;
  comment: string;
  createdBy: User;
  creationDate: Date;
  lastUpdatedBy: User;
  lastUpdateDate: Date;
}
