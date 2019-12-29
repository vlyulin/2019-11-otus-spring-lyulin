package ru.otus.spring.library.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.dao.EmptyResultDataAccessException;
import ru.otus.spring.library.config.Settings;
import ru.otus.spring.library.domain.LookupValue;

import java.sql.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Тестирование операций с объектом LookupValue")
/*@SpringBootTest(properties = {
        InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
        ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
})*/
@JdbcTest
@Import({Settings.class, LookupValueDaoJdbc.class})
class LookupValueDaoJdbcTest {

    @Autowired
    LookupValueDaoJdbc lookupValueDaoJdbc;

    @DisplayName("Проверка вставки LookupValue")
    @Test
    void insert() {
        LookupValue reference_lookupValue = new LookupValue(
                "TOOLS",
                "RU",
                "IDEA",
                "Средство разработки",
                "IDE",
                'Y',
                Date.valueOf("2019-01-10"),
                null
        );
        lookupValueDaoJdbc.insert(reference_lookupValue);
        lookupValueDaoJdbc.deleteByLookupCode("TOOLS", "IDEA", "RU");
    }

    @DisplayName("Проверка поиска LookupValue по lookup_code")
    @Test
    void getByLookupCode() {
        LookupValue reference_lookupValue = new LookupValue(
                "TOOLS",
                "RU",
                "IDEA",
                "Средство разработки",
                "IDE",
                'Y',
                Date.valueOf("2019-01-10"),
                null
        );
        lookupValueDaoJdbc.insert(reference_lookupValue);
        LookupValue lookupValue = lookupValueDaoJdbc.getByLookupCode("TOOLS","IDEA");
        assertThat(reference_lookupValue.equals(lookupValue));
        lookupValueDaoJdbc.deleteByLookupCode("TOOLS","IDEA","RU");
    }

    @DisplayName("Проверка получения списка LookupValue по lookup_type")
    @Test
    void getAll() {
        List<LookupValue> lookupValueList = lookupValueDaoJdbc.getAll("TOOLS");
        assertThat(lookupValueList.size() == 1);
    }

    @DisplayName("Проверка удаления LookupValue")
    @Test
    void deleteByLookupCode() {
        LookupValue reference_lookupValue = new LookupValue(
                "TOOLS",
                "RU",
                "IDEA",
                "Средство разработки",
                "IDE",
                'Y',
                Date.valueOf("2019-01-10"),
                null
        );
        lookupValueDaoJdbc.insert(reference_lookupValue);
        lookupValueDaoJdbc.deleteByLookupCode("TOOLS","IDEA","RU");
        Throwable exception = assertThrows(EmptyResultDataAccessException.class,() ->
                lookupValueDaoJdbc.getByLookupCode("TOOLS","IDEA",null));
    }
}