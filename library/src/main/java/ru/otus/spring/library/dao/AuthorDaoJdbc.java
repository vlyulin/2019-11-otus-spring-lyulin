package ru.otus.spring.library.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.spring.library.domain.Author;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@SuppressWarnings({"SqlNoDataSourceInspection", "ConstantConditions", "SqlDialectInspection"})
@Repository
public class AuthorDaoJdbc implements AuthorDao {

    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    public AuthorDaoJdbc(NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
    }

    @Override
    public int count() {
        return namedParameterJdbcOperations.queryForObject ("select count(1) from authors", new HashMap<String,Object>(), Integer.class);
    }

    @Override
    public void insert(Author author) {
        Map<String, Object> params = Map.of(
                "author_id", author.getId(),
                "name", author.getName(),
                "country", author.getCountry(),
                "sex", author.getSex(),
                "date_of_birth", author.getDate_of_birth()
        );
        namedParameterJdbcOperations.update(
                "insert into authors (author_id, name, country, sex, date_of_birth)\n" +
                "values (:author_id, :name, :country, :sex, :date_of_birth)",
                params
        );
    }

    @Override
    public Author getById(long id) {
        Map<String, Object> params = Collections.singletonMap("author_id", id);
        return namedParameterJdbcOperations.queryForObject(
                "select author_id, name, country, sex, date_of_birth\n" +
                        "from authors\n" +
                        "where author_id = :author_id", params, new AuthorMapper()
        );
    }

    @Override
    public List<Author> getAll() {
        return namedParameterJdbcOperations.query(
                "select author_id, name, country, sex, date_of_birth\n" +
                        "from authors\n", new AuthorMapper()
        );
    }

    @Override
    public void deleteById(long id) {
        Map<String, Object> params = Collections.singletonMap("author_id", id);
        namedParameterJdbcOperations.update(
                "delete from authors where author_id = :author_id", params
        );
    }

    private static class AuthorMapper implements RowMapper<Author> {
        @Override
        public Author mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("author_id");
            String name = resultSet.getString("name");
            String country = resultSet.getString("country");
            char sex = resultSet.getString("sex").charAt(0);
            Date date_of_birth = resultSet.getDate("date_of_birth");

            return new Author(id, name, country, sex, date_of_birth);
        }
    }
}
