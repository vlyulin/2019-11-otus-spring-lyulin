package ru.otus.spring.library.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
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
        web.ignoring().antMatchers("/");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests().antMatchers("/books").hasAnyAuthority("ADMIN", "USER")
                .and()
                .authorizeRequests().antMatchers("/users").hasAuthority("ADMIN")
                .and()
                .formLogin()
                .and()
                .logout()
                .logoutUrl("/logout");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return charSequence.toString().equals(s);
            }
        };
    }

     @Autowired
     public void configure(AuthenticationManagerBuilder auth) throws Exception {
         // https://www.baeldung.com/spring-security-jdbc-authentication
         // https://stackoverflow.com/questions/18104809/using-spring-security-websecurityconfigureradapter-auth-jdbcauthentication-u
         auth.jdbcAuthentication()
                 .dataSource(dataSource)
                 .usersByUsernameQuery("select login as principal, password as credentials, true from users where login = ?")
                 .authoritiesByUsernameQuery("select login as principal, authority as role from authorities where login = ?");
                 // .rolePrefix("ROLE_");
     }
}
