package ru.otus.spring.integration.services;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.handler.AbstractMessageHandler;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.io.File;

// https://stackoverflow.com/questions/49672999/mongodb-outbound-channel-overrides-document-in-db
@Service
public class CustomMongoMessageHandler extends AbstractMessageHandler {

    @Autowired
    PhotoService photoService;

    @SneakyThrows
    @Override
    protected void handleMessageInternal(Message<?> message) {
        File file = (File) message.getPayload();
        photoService.addPhoto(file.getName(), file);
    }
}
