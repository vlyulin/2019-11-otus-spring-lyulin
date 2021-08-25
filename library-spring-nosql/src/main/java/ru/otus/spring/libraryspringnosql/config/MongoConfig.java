package ru.otus.spring.libraryspringnosql.config;

// https://www.codeflow.site/ru/article/cascading-with-dbref-and-lifecycle-events-in-spring-data-mongodb
// https://github.com/eugenp/tutorials/blob/master/persistence-modules/spring-data-mongodb/src/main/java/com/baeldung/config/MongoConfig.java

import com.github.cloudyrock.mongock.Mongock;
import com.github.cloudyrock.mongock.SpringMongockBuilder;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.spring.libraryspringnosql.bee.changelog.InitMongoDBDataChangeLog;
import ru.otus.spring.libraryspringnosql.event.CommentEventListener;

// https://stackoverflow.com/questions/36448921/how-can-we-create-auto-generated-field-for-mongodb-using-spring-boot
// Нашел альтернативу для MongoDBEvents для автоматического назначения инкрементальных идентификаторов из последовательности
// Подход с MongoDBEvents у меня не заработал
// Класс оставил, так как жалко было удалять
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

    public @Bean CommentEventListener cascadeMongoEventListener() {
        return new CommentEventListener();
    }
}
