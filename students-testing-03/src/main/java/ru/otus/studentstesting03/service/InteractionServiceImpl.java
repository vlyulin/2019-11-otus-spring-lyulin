package ru.otus.studentstesting03.service;

import org.springframework.context.MessageSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class InteractionServiceImpl implements InteractionService {

    private final Locale locale;
    private final MessageSource messageSource;
    private final java.io.BufferedReader in;

    public InteractionServiceImpl(MessageSource messageSource, Locale locale) {
        this.locale = locale;
        this.messageSource = messageSource;
        this.in = new BufferedReader(new InputStreamReader(System.in));
    }

    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public void printTag(String messageTag) {
        System.out.println(
                messageSource.getMessage(messageTag, null, locale )
        );
    }

    @Override
    public void printTag(String messageTag, String message) {
        System.out.println(
                messageSource.getMessage(messageTag, new String[] {message}, locale )
        );
    }

    @Override
    public String readLine() throws IOException {
        return in.readLine();
    }
}
