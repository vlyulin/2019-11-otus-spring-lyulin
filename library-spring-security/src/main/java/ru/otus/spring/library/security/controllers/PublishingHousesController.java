package ru.otus.spring.library.security.controllers;

import org.springframework.web.bind.annotation.*;
import ru.otus.spring.library.security.models.Author;
import ru.otus.spring.library.security.models.PublishingHouse;
import ru.otus.spring.library.security.repositories.PublishingHousesRepository;

import java.util.List;

@CrossOrigin
@RestController
public class PublishingHousesController {
    private final PublishingHousesRepository publishingHousesRepository;

    public PublishingHousesController(PublishingHousesRepository publishingHousesRepository) {
        this.publishingHousesRepository = publishingHousesRepository;
    }

    @RequestMapping(value = "/publishingHouses", method={RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    List<PublishingHouse> getPublishingHouses() {
        return publishingHousesRepository.findAll();
    }

    @RequestMapping(value = "/publishingHouse/{publishingHouseId}", method={RequestMethod.GET})
    @ResponseBody
    public PublishingHouse getPublishingHouse(@PathVariable("publishingHouseId") long publishingHouseId) {
        return publishingHousesRepository.findById(publishingHouseId).get();
    }
}
