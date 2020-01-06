package ru.otus.spring.libraryorm.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import ru.otus.spring.libraryorm.config.AppSession;
import ru.otus.spring.libraryorm.models.Book;
import ru.otus.spring.libraryorm.models.Comment;
import ru.otus.spring.libraryorm.repositories.exceptions.BookNotFoundException;

@Transactional
@Repository
public class BooksRepositoryJpaImpl implements BooksRepositoryJpa {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private AppSession session;

    @Override
    public List<Book> getAllBooks() {
        TypedQuery<Book> query = em.createQuery(
                "select b from Book b join fetch b.author join fetch b.publishingHouse", Book.class);
        return query.getResultList();
    }

    @Override
    public List<Book> getBooks(String bookName, String genreCode, String genreMeaning, String authorName, String publishingHouseName, int publishingYear, int pages) {
        String _bookName = (bookName == null || bookName.isBlank() || bookName.isEmpty())?null:bookName;
        // TODO: Добавить в поиск genre
        String _genreCode = (genreCode == null || genreCode.isBlank() || genreCode.isEmpty())?null:genreCode;
        String _genreMeaning = (genreMeaning == null || genreMeaning.isBlank() || genreMeaning.isEmpty())?null:genreMeaning;
        String _authorName = (authorName == null || authorName.isBlank() || authorName.isEmpty())?null:authorName;
        String _publishingHouseName = (publishingHouseName == null || publishingHouseName.isBlank() || publishingHouseName.isEmpty())?null:publishingHouseName;
        Integer _publishingYear = (publishingYear == 0)?null:Integer.valueOf(publishingYear);
        Integer _pages = (pages == 0)?null:Integer.valueOf(pages);

        TypedQuery<Book> query = em.createQuery(
                "SELECT b FROM Book b JOIN FETCH b.author a JOIN FETCH b.publishingHouse ph\n" +
                        "WHERE 1 = 1\n" +
                        "AND (:book_name IS NULL OR UPPER(b.name) LIKE UPPER(:book_name))\n" +
                        "AND (:author_name IS NULL OR UPPER(a.name) LIKE UPPER(:author_name))\n" +
                        "AND (:publishing_house_name IS NULL OR UPPER(ph.name) LIKE UPPER(:publishing_house_name))\n" +
                        "AND (:publishing_year IS NULL OR b.publishingYear = :publishing_year)\n" +
                        "AND (:pages IS NULL OR b.pages = :pages)",
                Book.class
        );

        query.setParameter("book_name", _bookName);
        query.setParameter("author_name", _authorName);
        query.setParameter("publishing_house_name", _publishingHouseName);
        query.setParameter("publishing_year", _publishingYear);
        query.setParameter("pages", _pages);
        return query.getResultList();
    }

    @Override
    public Optional<Book> findBookById(long bookId) throws BookNotFoundException {
        Book book = em.find(Book.class, bookId);
        if( book == null ) {
            throw new BookNotFoundException("id = " + bookId);
        }
        return Optional.ofNullable(book);
    }

    /*
    * Фактически получил все данные, а не только комментарии.
    * Есть ли смысл в такого рода методах (получения дочерних объектов),
    * если можно запрашивать только родительский объект, в результате чего получим все данные
    * и для дочерних?
    *
    * Hibernate: select book0_.book_id as book_id1_1_0_, book0_.author_id as author_i5_1_0_,
    * book0_.name as name2_1_0_, book0_.pages as pages3_1_0_, book0_.publishing_house_id as publishi6_1_0_,
    * book0_.publishing_year as publishi4_1_0_, author1_.author_id as author_i1_0_1_,
    * author1_.country as country2_0_1_, author1_.date_of_birth as date_of_3_0_1_, author1_.name as name4_0_1_,
    * author1_.sex as sex5_0_1_, comments2_.book_id as book_id2_2_2_, comments2_.comment_id as comment_1_2_2_,
    * comments2_.comment_id as comment_1_2_3_, comments2_.book_id as book_id2_2_3_,
    * comments2_.comment as comment3_2_3_, comments2_.created_by as created_6_2_3_,
    * comments2_.creation_date as creation4_2_3_, comments2_.last_update_date as last_upd5_2_3_,
    * comments2_.last_updated_by as last_upd7_2_3_, user3_.user_id as user_id1_5_4_,
    * user3_.login as login2_5_4_, user3_.name as name3_5_4_, user3_.password as password4_5_4_,
    * user4_.user_id as user_id1_5_5_, user4_.login as login2_5_5_, user4_.name as name3_5_5_,
    * user4_.password as password4_5_5_, publishing5_.publishing_house_id as publishi1_4_6_,
    * publishing5_.name as name2_4_6_, publishing5_.settlement_year as settleme3_4_6_
    * from books book0_
    * left outer join authors author1_ on book0_.author_id=author1_.author_id
    * left outer join comments comments2_ on book0_.book_id=comments2_.book_id
    * left outer join users user3_ on comments2_.created_by=user3_.user_id
    * left outer join users user4_ on comments2_.last_updated_by=user4_.user_id
    * left outer join publishing_houses publishing5_ on book0_.publishing_house_id=publishing5_.publishing_house_id
    * where book0_.book_id=?
    * */
    @Override
    public List<Comment> getAllBookComments(long bookId) {
         Query query = em.createQuery("select cmt from Comment cmt where bookId = :bookId", Comment.class);
         query.setParameter("bookId", bookId);
         return query.getResultList();
    }

    @Override
    public Comment addBookComment(long bookId, String cmt) throws BookNotFoundException {
        Optional<Book> book = findBookById(bookId);
        if (book.isEmpty()) {
            throw new BookNotFoundException("id = " + bookId);
        }

        Comment comment = new Comment();
        comment.setComment(cmt);
        comment.setBookId(bookId);
        comment.setCreatedBy(session.getUser());
        comment.setCreationDate(LocalDate.now());
        book.get().getComments().add(comment);
        // TODO: Надо ли что-то делать с book в которую добавили новый комментарий?
        em.persist(comment);
        return comment;
    }

    @Override
    public int updateBookComment(long commentId, String cmt) {
        Query query = em.createQuery(
                "update Comment c set c.comment = :newComment, c.lastUpdatedBy = :lastUpdatedBy, c.lastUpdateDate = TODAY\n" +
                        "where c.commentId = :commentId");
        query.setParameter("newComment", cmt);
        query.setParameter("commentId", commentId);
        query.setParameter("lastUpdatedBy", session.getUser());
        return query.executeUpdate();
    }

    @Override
    public int deleteBookComment(long commentId) {
        Query query = em.createQuery("delete Comment c where c.commentId = :commentId");
        query.setParameter("commentId", commentId);
        return query.executeUpdate();
    }
}
