package ru.otus.spring.library.rest.controllers;

import org.springframework.web.bind.annotation.*;
import ru.otus.spring.library.rest.models.LookupValue;
import ru.otus.spring.library.rest.repositories.LookupsRepository;

import java.util.List;

@CrossOrigin
@RestController
public class LookupsController {
    private final LookupsRepository lookupsRepository;

    public LookupsController(LookupsRepository lookupsRepository) {
        this.lookupsRepository = lookupsRepository;
    }

    @RequestMapping(value = "/lookupValues/{language}", method={RequestMethod.GET})
    @ResponseBody
    List<LookupValue> getLookupValues(@PathVariable("language") String language) {
        return lookupsRepository.findByKeyLanguage(language);
    }
}
