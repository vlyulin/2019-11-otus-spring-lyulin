package ru.otus.spring.library.security.repositories;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.otus.spring.library.security.models.LookupValue;
import ru.otus.spring.library.security.models.LookupValueId;
import ru.otus.spring.library.security.services.AppSession;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тестирование репозитория LookupsRepository")
@DataJpaTest
class LookupsRepositoryTest {

    public static final String GENRES = "GENRES";
    public static final String HARD_SCIENCE_FICTION = "HARD_SCIENCE_FICTION";
    public static final String LANGUAGE_RU = "RU";
    public static final int EXPECTED_ONE = 1;

    @Autowired
    LookupsRepository lookupsRepository;

    @Autowired
    private TestEntityManager em;

    @MockBean
    private AppSession session;

    @Test
    void findByLookupTypeLookupCodeLanguage() {
        LookupValueId lookupValueId = new LookupValueId(GENRES, HARD_SCIENCE_FICTION, LANGUAGE_RU);
        List<LookupValue> lookupValues = lookupsRepository.findByKey(lookupValueId);

        LookupValue referenceLookupValue = em.find(LookupValue.class, lookupValueId);
        assertThat(lookupValues).hasSize(EXPECTED_ONE).containsExactly(referenceLookupValue);
    }
}