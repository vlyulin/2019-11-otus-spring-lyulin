package ru.otus.spring.library.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.otus.spring.library.security.services.UserDetailsServiceImpl;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private DataSource dataSource;
    private UserDetailsServiceImpl userService;

    public SecurityConfiguration(@Autowired DataSource dataSource,
                                 @Autowired UserDetailsServiceImpl userService
    ) {
        this.dataSource = dataSource;
        this.userService = userService;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests().antMatchers("/books").hasAnyRole("ADMIN", "USER")
                .and()
                .authorizeRequests().antMatchers("/books/edit*").hasAnyRole("ADMIN", "USER")
                .and()
                .authorizeRequests().antMatchers("/books/delete*").hasAnyRole("ADMIN", "USER")
                .and()
                .authorizeRequests().antMatchers("/books/*/comments").hasAnyRole("ADMIN", "USER")
                .and()
                .authorizeRequests().antMatchers("/user**").hasRole("ADMIN")
                .and()
                .authorizeRequests().antMatchers("/users").hasRole("ADMIN")
                .and()
                .formLogin()
                .and()
                .logout()
                .logoutUrl("/logout");
    }


     // Кодировка паролей
     // https://bcrypt-generator.com/
     @Bean
     public PasswordEncoder passwordEncoder() {
         return new BCryptPasswordEncoder();
     }

     @Autowired
     public void configure(AuthenticationManagerBuilder auth) throws Exception {
        // https://www.boraji.com/spring-security-5-custom-userdetailsservice-example
        auth.userDetailsService(userService);
     }
}
