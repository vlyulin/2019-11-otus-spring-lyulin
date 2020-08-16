package ru.otus.spring.library.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import ru.otus.spring.library.rest.security.*;

import java.util.Arrays;
import java.util.Collections;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final String FRONTEND_LOCALHOST = "http://localhost:4200";

    private JwtUtil jwtUtil;
    private JwtAuthenticationProvider jwtAuthenticationProvider;

    public SecurityConfiguration(@Autowired JwtUtil jwtUtil,
                                 @Autowired JwtAuthenticationProvider jwtAuthenticationProvider) {
        this.jwtUtil = jwtUtil;
        this.jwtAuthenticationProvider = jwtAuthenticationProvider;
    }

    // https://stackoverflow.com/questions/51986766/spring-security-getauthenticationmanager-returns-null-within-custom-filter
    // Ваще то что надо! Где и объясняется как связаны AuthenticationManager и AuthenticationProvider
    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(Arrays.asList(jwtAuthenticationProvider));
    }

    // https://stackoverflow.com/questions/40418441/spring-security-cors-filter
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Collections.singletonList("*"));
        configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH"));
        // setAllowCredentials(true) is important, otherwise:
        // The value of the 'Access-Control-Allow-Origin' header in the response must not be the wildcard '*'
        // when the request's credentials mode is 'include'.
        configuration.setAllowCredentials(true);
        // setAllowedHeaders is important! Without it, OPTIONS preflight request
        // will fail with 403 Invalid CORS request
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/users/authenticate");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // JWT фильтр
        JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(authenticationManager());
        // Отключение redirect куда-либо для JWT фильтра в случае успеха
        jwtAuthenticationFilter.setAuthenticationSuccessHandler(new JwtAuthenticationSuccessHandler());

        // .antMatchers("/users/authenticate").permitAll()

        // JWT отсюда https://www.toptal.com/java/rest-security-with-jwt-spring-security-and-java
        // Присобачить фильтр отсюда https://stackoverflow.com/questions/23810846/how-to-configure-a-custom-filter-programatically-in-spring-security/28554932
        // Часть классов отсюда https://github.com/BHRother/spring-boot-security-jwt/blob/master/src/main/java/nl/palmapps/myawesomeproject/controller/LoginController.java
        http
           .csrf().disable() // это оказалось надо несмотря на то, что написано по ссылке https://stackoverflow.com/questions/40418441/spring-security-cors-filter
           .cors().and()
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling().authenticationEntryPoint(new RestAuthenticationEntryPoint())
                .and()
                .authorizeRequests().antMatchers("/users").authenticated()
                .and()
                .authorizeRequests().antMatchers("/advancedBookSearch", "/book/*", "/saveBook", "/deleteBook/*",
                    "/bookComments", "/bookComment/*", "/saveBookComment",
                    "/deleteBookComment/*").authenticated()
                .and()
                .authorizeRequests().antMatchers("/dummyService").hasRole("NOT_EXISTING_ROLE")
           ;
    }
}
