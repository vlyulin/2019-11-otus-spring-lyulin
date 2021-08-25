package ru.otus.spring.libraryspringwebflux.repositories;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import ru.otus.spring.libraryspringwebflux.models.LookupValue;

public interface LookupsRepository extends ReactiveMongoRepository<LookupValue, Long> {

    Flux<LookupValue> findByLookupTypeAndLanguage(String lookupType, String language);

    @Query("and(eq('lookup_type', :lookupType), eq('lookup_code', :lookupCode))")
    Flux<LookupValue> findByLookupTypeLookupCode(String lookupType, String lookupCode);
}
