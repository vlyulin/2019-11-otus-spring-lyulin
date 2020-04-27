package ru.otus.spring.library.rest.security.exceptions;

import org.springframework.security.core.AuthenticationException;

public class JwtTokenMalformedException extends AuthenticationException {
    public JwtTokenMalformedException(String msg) {
        super(msg);
    }
}
