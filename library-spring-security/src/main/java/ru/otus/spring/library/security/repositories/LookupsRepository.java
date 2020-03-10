package ru.otus.spring.library.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.otus.spring.library.security.models.LookupValue;
import ru.otus.spring.library.security.models.LookupValueId;

import java.util.List;

public interface LookupsRepository extends JpaRepository<LookupValue, Long> {
    List<LookupValue> findByKey(LookupValueId key);

    // https://stackoverflow.com/questions/22007341/spring-jpa-selecting-specific-columns
    // Метод понадобился только для того, чтобы восстанавливать EmbededId,
    // который на возвращается при запросе книги
    //    {
    //        "id": 1,
    //            "name": "В ядовитом поясе",
    //            "publishingYear": 2010,
    //            "pages": 320,
    //            "genre": {
    //        "key": {}, <-- Пусто !!!
    //        "enabledFlag": "Y",
    //                "startDateActive": "+169108099-07-05",
    //                "endDateActive": "+169104628-12-09",
    //                "meaning": "Твердая научная фантастика",
    //                "description": "Твердая научная фантастика"
    //    ...
    @Query("select l.key from LookupValue l where l.meaning = :meaning and l.key.language = :language")
    List<LookupValueId> findByMeaningAndKeyLanguage(@Param("meaning") String meaning, @Param("language") String language);

    // Все значения для указаного языка
    List<LookupValue> findByKeyLanguage(String language);
}
