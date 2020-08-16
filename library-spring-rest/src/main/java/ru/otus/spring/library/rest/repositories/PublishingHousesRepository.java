package ru.otus.spring.library.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.spring.library.rest.models.PublishingHouse;

public interface PublishingHousesRepository extends JpaRepository<PublishingHouse, Long> {
}
