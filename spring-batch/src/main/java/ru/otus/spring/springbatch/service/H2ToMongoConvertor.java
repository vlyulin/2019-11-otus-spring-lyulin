package ru.otus.spring.springbatch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.spring.springbatch.models.h2.LookupValue;
import ru.otus.spring.springbatch.models.h2.User;
import ru.otus.spring.springbatch.repositories.MongoBookRepository;

import java.util.Collections;

@Service
public class H2ToMongoConvertor {

    @Autowired
    MongoBookRepository mongoBookRepository;

    public ru.otus.spring.springbatch.models.mongo.Book bookTransformation (ru.otus.spring.springbatch.models.h2.Book h2book) {
        ru.otus.spring.springbatch.models.mongo.Book mongoBook = new ru.otus.spring.springbatch.models.mongo.Book();
        mongoBook.setId( h2book.getId() );
        mongoBook.setName( h2book.getName() );
        mongoBook.setPages( h2book.getPages() );
        mongoBook.setPublishingYear( h2book.getPublishingYear() );

        try {
            ru.otus.spring.springbatch.models.mongo.LookupValue mongoLookupValue =
                    new ru.otus.spring.springbatch.models.mongo.LookupValue();
            LookupValue h2LookupValue = h2book.getGenre();
            mongoLookupValue.setLookupType( h2LookupValue.getKey().getLookupType() );
            mongoLookupValue.setLookupCode( h2LookupValue.getKey().getLookupCode() );
            mongoLookupValue.setLanguage( h2LookupValue.getKey().getLanguage() );
            mongoLookupValue.setMeaning( h2LookupValue.getMeaning() );
            mongoLookupValue.setDescription( h2LookupValue.getDescription() );
            mongoLookupValue.setEnabledFlag( h2LookupValue.getEnabledFlag() );
            if( h2LookupValue.getStartDateActive() != null ) {
                mongoLookupValue.setStartDateActive(h2LookupValue.getStartDateActive());
            }
            if( h2LookupValue.getEndDateActive() != null ) {
                mongoLookupValue.setEndDateActive(h2LookupValue.getEndDateActive());
            }
            mongoBook.setGenres(Collections.singletonList(mongoLookupValue));
        } catch (Exception e) {
        }

        try {
            ru.otus.spring.springbatch.models.mongo.Author mongoAuthor = new
                    ru.otus.spring.springbatch.models.mongo.Author();
            mongoAuthor.setName( h2book.getAuthor().getName() );
            mongoAuthor.setCountry( h2book.getAuthor().getCountry() );
            mongoAuthor.setDateOfBirth( h2book.getAuthor().getDateOfBirth() );
            mongoAuthor.setSex( h2book.getAuthor().getSex());
            mongoBook.setAuthor( mongoAuthor );
        } catch (Exception e) {
        }

        try {
            ru.otus.spring.springbatch.models.mongo.PublishingHouse mongoPublishingHouse =
                    new ru.otus.spring.springbatch.models.mongo.PublishingHouse();
            mongoPublishingHouse.setName( h2book.getPublishingHouse().getName() );
            mongoPublishingHouse.setSettlementYear( h2book.getPublishingHouse().getSettlementYear() );
            mongoBook.setPublishingHouse( mongoPublishingHouse );
        } catch (Exception e) {
        }

        return mongoBook;
    }

    private ru.otus.spring.springbatch.models.mongo.User makeUser(User user) {

        if( user == null ) return null;

        ru.otus.spring.springbatch.models.mongo.User mongoUser =
                new ru.otus.spring.springbatch.models.mongo.User() ;
        mongoUser.setId( user.getId() );
        mongoUser.setLogin( user.getLogin() );
        mongoUser.setName( user.getName() );
        mongoUser.setPassword( user.getPassword() );
        return mongoUser;
    }

    public ru.otus.spring.springbatch.models.mongo.Comment commentTransformation (ru.otus.spring.springbatch.models.h2.Comment h2Comment) {
        ru.otus.spring.springbatch.models.mongo.Comment mongoComment = new
                ru.otus.spring.springbatch.models.mongo.Comment();

        mongoComment.setId( h2Comment.getId() );
        mongoComment.setComment( h2Comment.getComment() );
        mongoComment.setCreationDate( h2Comment.getCreationDate() );
        mongoComment.setLastUpdateDate( h2Comment.getLastUpdateDate() );
        ru.otus.spring.springbatch.models.mongo.Book mongoBook =
                mongoBookRepository.findById(h2Comment.getBookId()).get();
        mongoComment.setBook(mongoBook);
        mongoComment.setCreatedBy(makeUser(h2Comment.getCreatedBy()));
        mongoComment.setLastUpdatedBy(makeUser(h2Comment.getLastUpdatedBy()));

        return mongoComment;
    }
}
