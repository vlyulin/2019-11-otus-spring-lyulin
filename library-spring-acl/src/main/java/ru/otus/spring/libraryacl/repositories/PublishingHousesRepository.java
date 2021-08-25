package ru.otus.spring.libraryacl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.spring.libraryacl.models.PublishingHouse;

public interface PublishingHousesRepository extends JpaRepository<PublishingHouse, Long> {
}
