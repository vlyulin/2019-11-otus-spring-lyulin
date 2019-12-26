package ru.otus.spring.library.dao;

import ru.otus.spring.library.domain.PublishingHouse;

import java.util.List;

public interface PublishingHouseDao {

    int count();

    void insert(PublishingHouse author);

    PublishingHouse getById(long id);

    List<PublishingHouse> getAll();

    void deleteById(long id);
}
