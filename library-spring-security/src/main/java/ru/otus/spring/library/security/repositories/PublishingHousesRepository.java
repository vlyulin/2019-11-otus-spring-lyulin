package ru.otus.spring.library.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.spring.library.security.models.PublishingHouse;

public interface PublishingHousesRepository extends JpaRepository<PublishingHouse, Long> {
}
