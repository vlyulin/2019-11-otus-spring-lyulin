package ru.otus.spring.library.actuator.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import ru.otus.spring.library.actuator.config.SecurityConfiguration;
import ru.otus.spring.library.actuator.repositories.BooksRepository;
import ru.otus.spring.library.actuator.repositories.UserRepository;
import ru.otus.spring.library.actuator.services.UserService;

import javax.sql.DataSource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// https://reflectoring.io/spring-boot-web-controller-test/
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = PagesController.class)
@Import(SecurityConfiguration.class)
@DisplayName("Тестирование защиты доступа к различным страницам")
class PagesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DataSource dataSource;

    @Autowired
    private SecurityConfiguration securityConfiguration;

    @MockBean
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private BooksRepository booksRepository;

    @WithAnonymousUser
    @Test
    @DisplayName("Тестирование свободного доступа к корневой странице")
    void indexPage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @WithMockUser(
            username = "Admin",
            authorities = {"ADMIN"}
    )
    @Test
    @DisplayName("Тестирование доступа к старнице users только с правами администратора")
    void usersList() throws Exception {
        mockMvc.perform(get("/users"))
                .andExpect(status().isOk());
    }

    @WithMockUser(
            username = "User01",
            authorities = {"USER"}
    )
    @Test
    @DisplayName("Тестирование доступа к старнице books с правами пользователя")
    void bookList() throws Exception {
        mockMvc.perform(get("/books"))
                .andExpect(status().isOk());
    }

    @WithMockUser(
            username = "User01",
            authorities = {"USER"}
    )
    @Test
    @DisplayName("Тестирование отсутствие доступа к старнице users с правами пользователя")
    void userListByUser() throws Exception {
        mockMvc.perform(get("/users"))
                .andExpect(status().is4xxClientError());
    }
}