package ru.otus.spring.library.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class Settings {
    private String language;
    private Locale locale;

    public Settings(@Value("${locale.language:ru}") String language,
                        @Value("${locale.country:RU}") String country) {
        this.language = language.toUpperCase();
	    this.locale = new Locale(language, country);
    }

    public String getLanguage(){ return language; }
    public Locale getLocale() {
        return locale;
    }
}
