package ru.otus.spring.libraryacl.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private DataSource dataSource;

    public SecurityConfiguration(@Autowired  DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/")
                .antMatchers("/swagger-ui.html")
                .antMatchers("/webjars/springfox-swagger-ui/**")
                .antMatchers("/swagger-resources/**")
                .antMatchers("/v2/api-docs")
                .antMatchers("/h2-console/**")
                .antMatchers("/h2/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests().antMatchers("/book").hasRole("ADMIN")
                .and()
                .authorizeRequests().antMatchers("/books").hasAnyRole("ADMIN", "USER", "USER18+")
                .and()
                .authorizeRequests().antMatchers("/books/edit/**").hasAnyRole("ADMIN")
                .and()
                .authorizeRequests().antMatchers("/books/save").hasAnyRole("ADMIN")
                .and()
                .authorizeRequests().antMatchers("/books/delete/*").hasAnyRole("ADMIN")
                .and()
                .authorizeRequests().antMatchers("/books/*/comments").hasAnyRole("ADMIN", "USER", "USER18+")
                .and()
                .authorizeRequests().antMatchers("/books/*/comment**").hasAnyRole("ADMIN", "USER", "USER18+")
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
         // https://www.baeldung.com/spring-security-jdbc-authentication
         // https://stackoverflow.com/questions/18104809/using-spring-security-websecurityconfigureradapter-auth-jdbcauthentication-u
         auth.jdbcAuthentication()
                 .dataSource(dataSource)
                 .usersByUsernameQuery("select login as principal, password as credentials, true from users where login = ?")
                 .authoritiesByUsernameQuery("select login as principal, authority as role from authorities where login = ?");
     }
}
