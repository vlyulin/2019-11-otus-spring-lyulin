package ru.otus.spring.library.security.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
// С @WebMvcTest получаю ошибку "java.lang.IllegalStateException: Failed to load ApplicationContext"
// @WebMvcTest(PagesController.class)
// С этими анотациями работает
@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Тестирование защиты доступа к различным страницам")
class PagesControllerTest {

    @Autowired
    private MockMvc mockMvc;

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