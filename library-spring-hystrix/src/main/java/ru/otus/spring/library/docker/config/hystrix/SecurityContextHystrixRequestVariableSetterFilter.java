package ru.otus.spring.library.docker.config.hystrix;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.*;
import java.io.IOException;

import static org.springframework.security.core.context.SecurityContextHolder.getContext;

public class SecurityContextHystrixRequestVariableSetterFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // Не помогло
        // 2020-04-18 19:39:22.932 DEBUG 2184 --- [-BooksService-1] com.netflix.hystrix.AbstractCommand      : Error executing HystrixCommand.run(). Proceeding to fallback logic ...
        // org.springframework.security.authentication.AuthenticationCredentialsNotFoundException: An Authentication object was not found in the SecurityContext
        SecurityContextHystrixRequestVariable.getInstance().set(SecurityContextHolder.getContext());
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}
}
