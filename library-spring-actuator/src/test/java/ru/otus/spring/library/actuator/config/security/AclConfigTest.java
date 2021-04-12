package ru.otus.spring.library.actuator.config.security;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.otus.spring.library.actuator.models.Book;
import ru.otus.spring.library.actuator.repositories.BooksRepository;
import ru.otus.spring.library.actuator.services.SecurityService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// https://www.baeldung.com/spring-security-acl
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class AclConfigTest {

    @MockBean
    private SecurityService session;

    @Autowired
    private BooksRepository booksRepository;

    @Test
    @WithMockUser(roles = {"USER"})
    public void
    givenRoleUSER_whenFindAllBooks_thenReturn3Book(){
        List<Book> books = booksRepository.findAll();

        assertNotNull(books);
        assertEquals(3,books.size());
    }
}