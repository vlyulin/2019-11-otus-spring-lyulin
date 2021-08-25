package ru.otus.spring.libraryacl.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.otus.spring.libraryacl.models.User;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тестирование UserService")
@DataJpaTest
@Import(UserServiceImpl.class)
class UserServiceImplTest {

    public static final String EXISTING_USER01_LOGIN = "User01";
    public static final String NON_EXISTING_USER_NAME = "NotExistenceUserName";

    @Autowired
    UserService userService;

    @MockBean
    private SecurityService session;

    @Test
    @DisplayName("Проверка обработки пользователя, которого нет в базе")
    void loadUserByUsernameNotFound() {
        Exception exception = Assertions.assertThrows(UsernameNotFoundException.class, () -> {
            User user = userService.loadUserByLogin(NON_EXISTING_USER_NAME);
        });
        String expectedMessage = NON_EXISTING_USER_NAME + " not found.";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    @Test
    @DisplayName("Проверка обработки пользователя, который есть в базе")
    void loadUserByUsername() {
        User user = userService.loadUserByLogin(EXISTING_USER01_LOGIN);
        assertThat(user).isNotNull().hasFieldOrPropertyWithValue("login", EXISTING_USER01_LOGIN);
    }
}