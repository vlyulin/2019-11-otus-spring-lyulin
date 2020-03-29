package ru.otus.spring.libraryspringwebflux.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

// https://www.baeldung.com/spring-data-mongodb-reactive
@EnableReactiveMongoRepositories
public class MongoReactiveApplication extends AbstractReactiveMongoConfiguration {

    @Value("${spring.data.mongodb.database:host}")
    private int dbHost;
    @Value("${spring.data.mongodb.database:port}")
    private int dbPort;
    @Value("${spring.data.mongodb.database:library}")
    private String dbName;

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create();
    }

    @Override
    protected String getDatabaseName() {
        return dbName;
    }

    @Override
    public com.mongodb.reactivestreams.client.MongoClient reactiveMongoClient() {
        return com.mongodb.reactivestreams.client.MongoClients.create(
                String.format("mongodb://%s:%d/%s", dbHost, dbPort, dbName));
    }
}
