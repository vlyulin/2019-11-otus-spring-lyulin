package ru.otus.spring.integration.services;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.spring.integration.models.Photo;
import ru.otus.spring.integration.repositories.PhotoRepository;

import java.io.File;
import java.nio.file.Files;
import java.io.IOException;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository photoRepo;

    public String addPhoto(String title, File file) throws IOException {
        Photo photo = new Photo(title);
        photo.setImage(
                new Binary(
                        BsonBinarySubType.BINARY,
                        Files.readAllBytes(file.toPath())
                )
        );
        photo = photoRepo.insert(photo);
        return photo.getId();
    }

    public Photo getPhoto(String id) {
        return photoRepo.findById(id).get();
    }
}
