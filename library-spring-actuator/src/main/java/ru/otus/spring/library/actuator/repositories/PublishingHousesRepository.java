package ru.otus.spring.library.actuator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.spring.library.actuator.models.PublishingHouse;

public interface PublishingHousesRepository extends JpaRepository<PublishingHouse, Long> {
}
