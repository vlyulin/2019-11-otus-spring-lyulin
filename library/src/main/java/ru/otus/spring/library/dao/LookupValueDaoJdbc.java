package ru.otus.spring.library.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.spring.library.config.Settings;
import ru.otus.spring.library.domain.LookupValue;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"SqlNoDataSourceInspection", "ConstantConditions", "SqlDialectInspection"})
@Repository
public class LookupValueDaoJdbc implements LookupValueDao {

    private final Settings settings;
    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    public LookupValueDaoJdbc(Settings settings, NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.settings = settings;
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
    }

    @Override
    public void insert(LookupValue lookupValue) {
        if (lookupValue == null) return;

        Map<String, Object> params = Map.of(
                "lookup_type", lookupValue.getLookupType(),
                "language", lookupValue.getLanguage(),
                "lookup_code", lookupValue.getLookupCode(),
                "meaning", lookupValue.getMeaning(),
                "description", lookupValue.getDescription(),
                "enabled_flag", lookupValue.getEnabledFlag(),
                "start_date_active", lookupValue.getStartDateActive(),
                "end_date_active", lookupValue.getEndDateActive()
        );
        namedParameterJdbcOperations.update(
                "insert into lookup_values (lookup_type, language, lookup_code, meaning, description, enabled_flag, start_date_active, end_date_active)"+
                "values (:lookup_type, :language, :lookup_code, :meaning, :description, :enabled_flag, :start_date_active, :end_date_active)",
                params
        );
    }

    @Override
    public LookupValue getByLookupCode(String lookupType, String lookupCode, Date onDate) {

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("lookup_type", lookupType);
        params.addValue("lookup_code", lookupCode);
        params.addValue("language", settings.getLanguage());
        params.addValue("onDate", onDate);

        return namedParameterJdbcOperations.queryForObject(
                "select lookup_type, language, lookup_code, meaning, description, enabled_flag, start_date_active, end_date_active\n" +
                        "from lookup_values\n" +
                        "where lookup_type = :lookup_type\n" +
                        "and lookup_code = :lookup_code\n" +
                        "and language = :language\n" +
                        "and (:onDate is null or :onDate between ifnull(start_date_active,:onDate) and ifnull(end_date_active,:onDate))"
                , params, new LookupValueMapper()
        );
    }

    @Override
    public LookupValue getByLookupCode(String lookupType, String lookupCode) {
        return getByLookupCode(lookupType, lookupCode, null);
    }

    @Override
    public List<LookupValue> getAll(String lookupType) {
        Map<String, Object> params = Map.of(
                "lookup_type", lookupType,
                "language", settings.getLanguage()
        );
        return namedParameterJdbcOperations.query(
                "select lookup_type, language, lookup_code, meaning, description, enabled_flag, start_date_active, end_date_active\n" +
                        "from lookup_values\n" +
                        "where lookup_type = :lookup_type\n" +
                        "and language = :language\n" +
                        "and TODAY between ifnull(start_date_active,TODAY) and ifnull(end_date_active,TODAY)",
                params,
                new LookupValueDaoJdbc.LookupValueMapper()
        );
    }

    @Override
    public Map<String,LookupValue> getLookupTypeValues(String lookupType) {
        Map<String,LookupValue> lookupTypeValues = new HashMap<>();
        List<LookupValue> lookupValues = getAll(lookupType);
        for(LookupValue lookupValue: lookupValues) {
            lookupTypeValues.put(lookupValue.getLookupCode(), lookupValue);
        }
        return lookupTypeValues;
    }

    @Override
    public void deleteByLookupCode(String lookupType, String lookupCode, String language) {
        Map<String, Object> params = Map.of(
                "lookup_type", lookupType,
                "lookup_code", lookupCode,
                "language", language
        );
        namedParameterJdbcOperations.update(
                "delete from lookup_values " +
                        "where lookup_type = :lookup_type and lookup_code = :lookup_code " +
                        "and (:language is null or language = :language)",
                params
        );
    }

    private class LookupValueMapper implements RowMapper<LookupValue> {
        @Override
        public LookupValue mapRow(ResultSet resultSet, int i) throws SQLException {
            String lookupType = resultSet.getString("lookup_type");
            String language = resultSet.getString("language");
            String lookupCode = resultSet.getString("lookup_code");
            String meaning = resultSet.getString("meaning");
            String description = resultSet.getString("description");
            char enabledFlag = resultSet.getString("enabled_flag").charAt(0);
            Date startDateActive = resultSet.getDate("start_date_active");
            Date endDateActive = resultSet.getDate("end_date_active");
            return new LookupValue(lookupType, language, lookupCode, meaning, description, enabledFlag, startDateActive, endDateActive);
        }
    }
}
