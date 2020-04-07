package ru.otus.spring.library.security.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тестирование UserServiceImpl")
@DataJpaTest
@Import(UserDetailsServiceImpl.class)
class UserDetailsServiceImplTest {

    public static final String EXISTING_USER01_NAME = "User 01";
    public static final String EXISTING_USER01_LOGIN = "User01";
    public static final String NON_EXISTING_USER_NAME = "NotExistenceUserName";
    public static final String ROLE_USER = "ROLE_USER";

    @Autowired
    UserDetailsServiceImpl userService;

    @MockBean
    private AppSession session;

    @Test
    @DisplayName("Проверка обработки пользователя, которого нет в базе")
    void loadUserByUsernameNotFound() {
        Exception exception = Assertions.assertThrows(UsernameNotFoundException.class, () -> {
            UserDetails user = userService.loadUserByUsername(NON_EXISTING_USER_NAME);
        });
        String expectedMessage = NON_EXISTING_USER_NAME + " not found.";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    @Test
    @DisplayName("Проверка обработки пользователя, который есть в базе")
    void loadUserByUsername() {
        UserDetails user = userService.loadUserByUsername(EXISTING_USER01_LOGIN);
        assertThat(user).isNotNull(); // . .hasFieldOrPropertyWithValue("login", EXISTING_USER01_LOGIN);
        assertThat(user.getUsername()).isEqualTo(EXISTING_USER01_LOGIN);

        // TODO: Не справился с синтаксисом assertThat(user.getAuthorities()).containsExactly
        // GrantedAuthority ga = new SimpleGrantedAuthority(ROLE_USER);
        // assertThat(user.getAuthorities()).containsExactly(ga);
        // Выкрутился так
        for(GrantedAuthority ga: user.getAuthorities()){
            if(ga.getAuthority().equals(ROLE_USER)){
                return;
            }
        }
        fail(ROLE_USER + " doesn't exists.");
    }
}