package ru.otus.spring.ocae.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
class OutRequestInterceptor implements RequestInterceptor {

    public static final String REST_FRAMEWORK_VERSION = "7";
    private String token;

    public OutRequestInterceptor(@Value("${oracle.jwt.token}") String token) {
        this.token = "Bearer " + token;
    }

    @Override
    public void apply(RequestTemplate template) {
        template.header("Authorization", token );
        template.header("REST-Framework-Version", REST_FRAMEWORK_VERSION);
    }
}
