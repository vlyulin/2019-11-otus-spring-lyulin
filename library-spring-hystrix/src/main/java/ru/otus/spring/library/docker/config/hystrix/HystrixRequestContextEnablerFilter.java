package ru.otus.spring.library.docker.config.hystrix;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

import javax.servlet.*;
import java.io.IOException;

/**
 * ServletFilter for initializing HystrixRequestContext at the beginning of an HTTP request and shutting down at the end:
 *
 * The filter shuts down the HystrixRequestContext at the end of the request to avoid
 * leakage into subsequent requests.
 */
public class HystrixRequestContextEnablerFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        try {
            chain.doFilter(request, response);
        } finally {
            context.shutdown();
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}
}
