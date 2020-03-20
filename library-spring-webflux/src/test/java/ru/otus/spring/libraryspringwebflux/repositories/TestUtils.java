package ru.otus.spring.libraryspringwebflux.repositories;

import org.springframework.data.mongodb.core.MongoTemplate;

public class TestUtils {
    public static void cleanUp(MongoTemplate mongoTemplate, String databaseName) {
        for (String collectionName : mongoTemplate.getCollectionNames()) {
            if (!collectionName.startsWith("system.")) {
                System.out.println("TestUtils.cleanUp drop collection: " + collectionName);
                mongoTemplate.dropCollection(collectionName);
            }
        }
    }
}
