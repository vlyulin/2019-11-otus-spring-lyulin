package ru.otus.spring.library.docker.config.hystrix;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

import javax.servlet.ServletContext;

// https://jfconavarrete.wordpress.com/tag/authenticationcredentialsnotfoundexception/
@Configuration
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

    /**
     * Add the HystrixRequestContextEnablerFilter and the SecurityContextHystrixRequestVariableSetterFilter after the SpringSecurityFilter
     */
    @Override
    protected void afterSpringSecurityFilterChain(ServletContext servletContext) {
        servletContext.addFilter("hystrixRequestContextEnablerFilter", new HystrixRequestContextEnablerFilter())
                .addMappingForUrlPatterns(null, true, "/*");

        servletContext.addFilter("hystrixSecurityContextEnablerFilter", new SecurityContextHystrixRequestVariableSetterFilter())
                .addMappingForUrlPatterns(null, true, "/*");
    }

}
