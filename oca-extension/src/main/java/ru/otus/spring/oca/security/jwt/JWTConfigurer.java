package ru.otus.spring.oca.security.jwt;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JWTConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final TokenProvider tokenProvider;
    private final OracleTokenProvider oracleTokenProvider;

    public JWTConfigurer(TokenProvider tokenProvider, OracleTokenProvider oracleTokenProvider) {
        this.tokenProvider = tokenProvider;
        this.oracleTokenProvider = oracleTokenProvider;
    }

    @Override
    public void configure(HttpSecurity http) {
        JWTFilter customFilter = new JWTFilter(tokenProvider);
        http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
        // VL JInjection
        OracleJWTFilter oracleJWTFilter = new OracleJWTFilter(oracleTokenProvider);
        http.addFilterBefore(oracleJWTFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
