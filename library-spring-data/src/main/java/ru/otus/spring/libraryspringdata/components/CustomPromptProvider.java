package ru.otus.spring.libraryspringdata.components;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.stereotype.Component;
import ru.otus.spring.libraryspringdata.services.AppSession;

@Component
public class CustomPromptProvider implements PromptProvider {

    private final AppSession appSession;

    public CustomPromptProvider(AppSession appSession) {
        this.appSession = appSession;
    }

    @Override
    public AttributedString getPrompt() {
        if (appSession.isConnected()) {
            return new AttributedString("connected:> ",
                    AttributedStyle.DEFAULT.foreground(AttributedStyle.YELLOW));
        }
        else {
            return new AttributedString("unconnected:> ",
                    AttributedStyle.DEFAULT.foreground(AttributedStyle.RED));
        }
    }
}
