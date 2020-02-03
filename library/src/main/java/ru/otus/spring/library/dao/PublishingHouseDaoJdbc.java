package ru.otus.spring.library.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.spring.library.domain.PublishingHouse;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@SuppressWarnings({"SqlNoDataSourceInspection", "ConstantConditions", "SqlDialectInspection"})
@Repository
public class PublishingHouseDaoJdbc implements PublishingHouseDao {

    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    public PublishingHouseDaoJdbc(NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
    }

    @Override
    public int count() {
        return namedParameterJdbcOperations.getJdbcOperations()
                .queryForObject ("select count(1) from publishing_houses", Integer.class);
    }

    @Override
    public void insert(PublishingHouse publishingHouse) {
        Map<String, Object> params = Map.of(
                "publishing_house_id", publishingHouse.getId(),
                "name", publishingHouse.getName(),
                "settlement_year", publishingHouse.getSettlementYear()
        );
        namedParameterJdbcOperations.update(
                "insert into publishing_houses (publishing_house_id, name, settlement_year)\n" +
                        "values (:publishing_house_id, :name, :settlement_year)",
                params
        );
    }

    @Override
    public PublishingHouse getById(long id) {
        Map<String, Object> params = Collections.singletonMap("publishing_house_id", id);
        return namedParameterJdbcOperations.queryForObject(
                "select publishing_house_id, name, settlement_year\n" +
                        "from publishing_houses\n" +
                        "where publishing_house_id = :publishing_house_id",
                params,
                new PublishingHouseDaoJdbc.PublishingHouseMapper()
        );
    }

    @Override
    public List<PublishingHouse> getAll() {
        return namedParameterJdbcOperations.query(
                "select publishing_house_id, name, settlement_year\n" +
                        "from publishing_houses\n", new PublishingHouseDaoJdbc.PublishingHouseMapper()
        );
    }

    @Override
    public void deleteById(long id) {
        Map<String, Object> params = Collections.singletonMap("publishing_house_id", id);
        namedParameterJdbcOperations.update(
                "delete from publishing_houses where publishing_house_id = :publishing_house_id", params
        );
    }

    private static class PublishingHouseMapper implements RowMapper<PublishingHouse> {
        @Override
        public PublishingHouse mapRow(ResultSet resultSet, int i) throws SQLException {
            long publishingHouseId = resultSet.getLong("publishing_house_id");
            String name = resultSet.getString("name");
            int settlementYear = resultSet.getInt("settlement_year");

            return new PublishingHouse(publishingHouseId, name, settlementYear);
        }
    }
}
