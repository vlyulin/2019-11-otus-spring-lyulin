package ru.otus.spring.libraryacl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import ru.otus.spring.libraryacl.models.Comment;

import java.util.List;

public interface BookCommentsRepository extends JpaRepository<Comment, Long>, BookCommentsRepositoryCustom {

    @PostFilter("hasPermission(filterObject, 'READ')")
    List<Comment> findByBookId(long bookId);

    @PreAuthorize("hasRole(ROLE_ADMIN)")
    void deleteByBookId(long bookId);

    @Query("SELECT c.id FROM Comment c WHERE c.bookId = :bookId")
    List<Long> getCommentsIdByBookId(@Param("bookId") long bookId);
}
