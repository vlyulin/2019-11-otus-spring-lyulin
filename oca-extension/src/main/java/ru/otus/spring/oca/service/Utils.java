package ru.otus.spring.oca.service;

import org.springframework.web.util.UriComponentsBuilder;

public class Utils {
    /*
     * Сервисная функция собирает URL к REST API
     */
    public static String getServiceURL(String BASE_URL, String queryParams, int offset, int limit) {
        String URL = BASE_URL;
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(BASE_URL);
        builder.queryParam("offset", offset).queryParam("limit", limit);
        URL = builder.toUriString();
        if(queryParams != null && !queryParams.isEmpty() && !queryParams.isBlank()) {
            URL += "&q=" + queryParams;
        }
        return URL;
    }
}
