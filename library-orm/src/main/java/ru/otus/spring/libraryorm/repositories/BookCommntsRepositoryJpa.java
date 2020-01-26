package ru.otus.spring.libraryorm.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.libraryorm.models.Comment;
import ru.otus.spring.libraryorm.repositories.exceptions.BookNotFoundException;
import ru.otus.spring.libraryorm.services.AppSession;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

@Transactional
@Repository
public class BookCommntsRepositoryJpa implements BookCommntsRepository {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private AppSession session;
    @Autowired
    private BooksRepository booksRepository;

    @Override
    public List<Comment> getAllBookComments(long bookId) {
        Query query = em.createQuery(
                "select cmt from Comment cmt where cmt.bookId = :bookId", Comment.class);
        query.setParameter("bookId", bookId);
        return query.getResultList();
    }

    @Override
    public Comment addBookComment(long bookId, String cmt) throws BookNotFoundException {

        Comment comment = new Comment();
        comment.setBookId(bookId);
        comment.setComment(cmt);
        comment.setCreatedBy(session.getUser());
        comment.setCreationDate(LocalDate.now());
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
