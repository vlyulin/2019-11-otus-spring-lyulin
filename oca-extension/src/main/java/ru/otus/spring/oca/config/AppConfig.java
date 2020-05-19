package ru.otus.spring.oca.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.mediatype.hal.Jackson2HalModule;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// VL
@Configuration
public class AppConfig {

    private LoggingRequestInterceptor loggingRequestInterceptor;

    public AppConfig(LoggingRequestInterceptor loggingRequestInterceptor) {
        this.loggingRequestInterceptor = loggingRequestInterceptor;
    }

    @Bean
    ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json()
                .modules(new Jackson2HalModule())
                .build();
        return objectMapper;
    }

    @Bean
    RestTemplate getRestTemplate() {

        ObjectMapper objectMapper = getObjectMapper();

        RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
        restTemplate.setMessageConverters(Arrays.asList(
                new MappingJackson2HttpMessageConverter(objectMapper)));
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(loggingRequestInterceptor);
        restTemplate.setInterceptors(interceptors);
        // TODO: Обработка ошибок. Переделать
        // restTemplate.setErrorHandler(new RestTemplateResponseErrorHandler());

        return restTemplate;
    }
}
