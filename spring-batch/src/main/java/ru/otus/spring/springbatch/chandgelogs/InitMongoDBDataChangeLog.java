package ru.otus.spring.springbatch.chandgelogs;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoDatabase;
import org.springframework.data.mongodb.core.MongoTemplate;

@ChangeLog(order = "001")
public class InitMongoDBDataChangeLog {

    @ChangeSet(order = "000", id = "dropDB", author = "vlyulin", runAlways = true)
    public void dropDB(MongoDatabase database){
        database.drop();
    }

}
