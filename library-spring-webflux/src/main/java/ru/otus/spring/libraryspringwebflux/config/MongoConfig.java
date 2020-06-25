package ru.otus.spring.libraryspringwebflux.config;

// https://www.codeflow.site/ru/article/cascading-with-dbref-and-lifecycle-events-in-spring-data-mongodb
// https://github.com/eugenp/tutorials/blob/master/persistence-modules/spring-data-mongodb/src/main/java/com/baeldung/config/MongoConfig.java

import com.github.cloudyrock.mongock.Mongock;
import com.github.cloudyrock.mongock.SpringMongockBuilder;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.spring.libraryspringwebflux.bee.changelog.InitMongoDBDataChangeLog;

@Configuration
public class MongoConfig {

    @Value("${spring.data.mongodb.database:library}")
    private String databaseName;

    @Bean
    public Mongock mongock(MongoClient mongoClient) {
        return new SpringMongockBuilder(mongoClient, databaseName,
                InitMongoDBDataChangeLog.class.getPackageName())
                .build();
    }
}
