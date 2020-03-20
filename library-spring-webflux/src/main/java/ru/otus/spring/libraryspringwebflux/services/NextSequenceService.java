package ru.otus.spring.libraryspringwebflux.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import ru.otus.spring.libraryspringwebflux.models.CustomSequences;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

// https://stackoverflow.com/questions/36448921/how-can-we-create-auto-generated-field-for-mongodb-using-spring-boot
// Альтернатива MongoDBEvents для автоматического назначения инкрементальных идентификаторов из последовательности
// Подход с MongoDBEvents у меня не заработал
@Service
public class NextSequenceService {

    @Autowired
    // TODO: На реактивщине не работает. Не проходит тест BookCommentsRepositoryTest
    // private ReactiveMongoTemplate reactiveMongoTemplate;
    private MongoTemplate mongoTemplate;

    public int getNextSequence(String seqName)
    {
        // Mono<CustomSequences> counter = reactiveMongoTemplate.findAndModify(
        CustomSequences counter = mongoTemplate.findAndModify(
                query(where("_id").is(seqName)),
                new Update().inc("seq",1),
                options().returnNew(true).upsert(true),
                CustomSequences.class);

        // return counter.block().getSeq();
        return counter.getSeq();
    }
}
