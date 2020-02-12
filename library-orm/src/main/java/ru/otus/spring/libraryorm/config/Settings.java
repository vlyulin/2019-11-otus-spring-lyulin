package ru.otus.spring.libraryorm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class Settings {
    private String language;
    private Locale locale;
    private String login;

    public Settings(@Value("${localization.language:ru}") String language,
                    @Value("${localization.country:RU}") String country,
                    @Value("${appsession.user:User01}") String login ) {
        this.language = language.toUpperCase();
	    this.locale = new Locale(language, country);
	    this.login = login;
    }

    public String getLanguage(){ return language; }
    public Locale getLocale() {
        return locale;
    }
    public String getLogin() {
        return login;
    }
}
