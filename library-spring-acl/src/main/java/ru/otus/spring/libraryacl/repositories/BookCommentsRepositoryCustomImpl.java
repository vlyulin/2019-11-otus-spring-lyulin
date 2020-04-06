package ru.otus.spring.libraryacl.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import ru.otus.spring.libraryacl.models.Comment;
import ru.otus.spring.libraryacl.services.SecurityService;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public class BookCommentsRepositoryCustomImpl implements BookCommentsRepositoryCustom {

    @Autowired
    @Lazy
    BookCommentsRepository bookCommentsRepository;

    @Autowired
    private SecurityService securityService;

    @Override
    public Comment addBookComment(long bookId, String cmt) {
        Comment comment = new Comment();
        comment.setBookId(bookId);
        comment.setComment(cmt);
        comment.setCreatedBy(securityService.getUser());
        comment.setCreationDate(LocalDate.now());

        bookCommentsRepository.save(comment);
        securityService.createCommentAcl(comment);
        return comment;
    }

    // https://stackoverflow.com/questions/52757368/spring-security-allow-each-user-to-see-their-own-profile-but-none-else
    @Override
    public void updateBookComment(long commentId, String cmt) {
        Optional<Comment> optComment = bookCommentsRepository.findById(commentId);
        if(optComment.isEmpty()) return;
        Comment comment = optComment.get();
        comment.setComment(cmt);
        comment.setLastUpdatedBy(securityService.getUser());
        comment.setLastUpdateDate(LocalDate.now());
        bookCommentsRepository.save(comment);
    }

    // TODO: delete comment, delete ACL: mutableAclService.deleteAcl(ObjectIdentityImpl(Comment.class, comment.getId());
}
