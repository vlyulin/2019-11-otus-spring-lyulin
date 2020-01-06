package ru.otus.spring.libraryorm.services;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.spring.libraryorm.config.Settings;

@Service
public class ConsoleMessageService implements MessageService {

    private final MessageSource ms;
    private final Settings settings;
    private final IOService ioService;

    public ConsoleMessageService(MessageSource ms, Settings settings, IOService ioService) {
        this.ms = ms;
        this.settings = settings;
        this.ioService = ioService;
    }

    @Override
    public void printMessage(String message) {
        ioService.printLn(message);
    }

    @Override
    public void printMessageByKey(String messageKey) {
        ioService.printLn(ms.getMessage(messageKey,null,settings.getLocale()));
    }

    @Override
    public void printMessageByKey(String messageKey, Object... args) {
        ioService.printLn(ms.getMessage(messageKey,args,settings.getLocale()));
    }

    @Override
    public String readLn() {
        return ioService.readLn();
    }

    @Override
    public String readLn(String promptMessageKey) {
        return ioService.readLn(ms.getMessage(promptMessageKey,null,settings.getLocale()));
    }
}
