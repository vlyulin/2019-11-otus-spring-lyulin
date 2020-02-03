package ru.otus.spring.library.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.spring.library.config.Settings;
import ru.otus.spring.library.domain.Author;
import ru.otus.spring.library.domain.Book;
import ru.otus.spring.library.domain.LookupValue;
import ru.otus.spring.library.domain.PublishingHouse;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;


@SuppressWarnings({"SqlNoDataSourceInspection", "ConstantConditions", "SqlDialectInspection"})
@Repository
public class BookDaoJdbc implements BookDao {

    private static final String GENRES = "GENRES";

    private final Settings settings;
    private final NamedParameterJdbcOperations namedParameterJdbcOperations;
    private final AuthorDao authorDao;
    private final PublishingHouseDao publishingHouseDao;
    private final LookupValueDao lookupValueDao;

    public BookDaoJdbc(
            Settings settings, NamedParameterJdbcOperations namedParameterJdbcOperations,
            AuthorDao authorDao,
            PublishingHouseDao publishingHouseDao,
            LookupValueDao lookupValueDao) {
        this.settings = settings;
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
        this.authorDao = authorDao;
        this.publishingHouseDao = publishingHouseDao;
        this.lookupValueDao = lookupValueDao;
    }

    @Override
    public int count() {
        return namedParameterJdbcOperations.getJdbcOperations()
                .queryForObject ("select count(1) from books", Integer.class);
    }

    @Override
    public void insert(Book book) {

        Map<String, Object> params = Map.of(
                "book_id", book.getId(),
                "name", book.getName(),
                "genre", book.getGenre().getLookupCode(),
                "author_id", book.getAuthor().getId(),
                "publishing_house_id", book.getPublishingHouse().getId(),
                "publishing_year", book.getPublishingYear(),
                "pages", book.getPages()
        );
        namedParameterJdbcOperations.update(
                "insert into books (book_id, name, genre, author_id, publishing_house_id, publishing_year, pages)\n" +
                        "values (:book_id, :name, :genre, :author_id, :publishing_house_id, :publishing_year, :pages)",
                params
        );
    }

    @Override
    public Book getById(long id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("book_id", id);
        params.addValue("language",settings.getLanguage());

        return namedParameterJdbcOperations.queryForObject(
                "select b.book_id, b.name book_name, b.genre, b.author_id, b.publishing_house_id, b.publishing_year, b.pages,\n" +
                        "v.lookup_type, v.language, v.lookup_code, v.meaning, v.description,\n" +
                        "v.enabled_flag, v.start_date_active, v.end_date_active,\n" +
                        "a.name author_name, a.country, a.sex, a.date_of_birth,\n" +
                        "h.name ph_name, h.settlement_year\n" +
                        "from books b\n" +
                        ", lookup_values v\n" +
                        ", authors a\n" +
                        ", publishing_houses h\n" +
                        "where 1 = 1\n" +
                        "and b.genre = v.lookup_code and v.lookup_type = '" + GENRES + "'\n" +
                        "and v.language = :language\n" +
                        "and TODAY between ifnull(v.start_date_active,TODAY) and ifnull(v.end_date_active,TODAY)\n" +
                        "and b.author_id = a.author_id\n" +
                        "and b.publishing_house_id = h.publishing_house_id\n" +
                        "and book_id = :book_id"
                , params
                , new BookDaoJdbc.BookMapper()
        );
    }

    @Override
    public List<Book> getAll() {
        Map<String, Object> params = Collections.singletonMap("language", settings.getLanguage());
        return namedParameterJdbcOperations.query(
            "select b.book_id, b.name book_name, b.genre, b.author_id, b.publishing_house_id, b.publishing_year, b.pages,\n" +
                "v.lookup_type, v.language, v.lookup_code, v.meaning, v.description,\n" +
                "v.enabled_flag, v.start_date_active, v.end_date_active,\n" +
                "a.name author_name, a.country, a.sex, a.date_of_birth,\n" +
                "h.name ph_name, h.settlement_year\n" +
                "from books b\n" +
                ", lookup_values v\n" +
                ", authors a\n" +
                ", publishing_houses h\n" +
                "where 1 = 1\n" +
                "and b.genre = v.lookup_code and v.lookup_type = '" + GENRES + "'\n" +
                "and v.language = :language\n" +
                "and TODAY between ifnull(v.start_date_active,TODAY) and ifnull(v.end_date_active,TODAY)" +
                "and b.author_id = a.author_id\n" +
                "and b.publishing_house_id = h.publishing_house_id\n"
            , params
            , new BookMapper()
        );
    }

    @Override
    public List<Book> getBooks(
                String bookName,
                String genreCode,
                String genreMeaning,
                String authorName,
                String publishingHouseName,
                int publishingYear,
                int pages)
    {
        String _bookName = (bookName == null || bookName.isBlank() || bookName.isEmpty())?null:bookName;
        String _genreCode = (genreCode == null || genreCode.isBlank() || genreCode.isEmpty())?null:genreCode;
        String _genreMeaning = (genreMeaning == null || genreMeaning.isBlank() || genreMeaning.isEmpty())?null:genreMeaning;
        String _authorName = (authorName == null || authorName.isBlank() || authorName.isEmpty())?null:authorName;
        String _publishingHouseName = (publishingHouseName == null || publishingHouseName.isBlank() || publishingHouseName.isEmpty())?null:publishingHouseName;
        String _publishingYear = (publishingYear == 0)?null:String.valueOf(publishingYear);
        String _pages = (pages == 0)?null:String.valueOf(pages);

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("book_name", _bookName);
        parameters.addValue("genre_code", _genreCode);
        parameters.addValue("genre_meaning", _genreMeaning);
        parameters.addValue("author_name", _authorName);
        parameters.addValue("publishing_house_name", _publishingHouseName);
        parameters.addValue("publishing_year", _publishingYear);
        parameters.addValue("pages", _pages);
        parameters.addValue("language",settings.getLanguage());

        return namedParameterJdbcOperations.query(
                "select b.book_id, b.name book_name, b.genre, b.author_id, b.publishing_house_id, b.publishing_year, b.pages,\n" +
                        "v.lookup_type, v.language, v.lookup_code, v.meaning, v.description,\n" +
                        "v.enabled_flag, v.start_date_active, v.end_date_active,\n" +
                        "a.name author_name, a.country, a.sex, a.date_of_birth,\n" +
                        "h.name ph_name, h.settlement_year\n" +
                        "from books b\n" +
                        ", lookup_values v\n" +
                        ", authors a\n" +
                        ", publishing_houses h\n" +
                        "where 1 = 1\n" +
                        "and b.genre = v.lookup_code and v.lookup_type = '" + GENRES + "'\n" +
                        "and v.language = :language\n" +
                        "and TODAY between ifnull(v.start_date_active,TODAY) and ifnull(v.end_date_active,TODAY)" +
                        "and b.author_id = a.author_id\n" +
                        "and b.publishing_house_id = h.publishing_house_id\n" +
                        "and (:book_name is null or (b.name like :book_name))\n" +
                        "and (:genre_code is null or b.genre like UPPER(:genre_code))\n" +
                        "and (:genre_meaning is null or UPPER(v.meaning) like UPPER(:genre_meaning))\n" +
                        "and (:author_name is null or UPPER(a.name) like UPPER(:author_name))\n" +
                        "and (:publishing_house_name is null or UPPER(h.name) like UPPER(:publishing_house_name))\n" +
                        "and (:publishing_year is null or b.publishing_year = :publishing_year)\n" +
                        "and (:pages is null or b.pages = :pages)"
                ,parameters
                , new BookMapper()
        );
    }

    @Override
    public void deleteById(long id) {
        Map<String, Object> params = Collections.singletonMap("book_id", id);
        namedParameterJdbcOperations.update(
                "delete from books where book_id = :book_id", params
        );
    }

    private class BookMapper implements RowMapper<Book> {
        @Override
        public Book mapRow(ResultSet rs, int i) throws SQLException {

            LookupValue lookupValue =
                    new LookupValue(
                            rs.getString("lookup_type"),
                            rs.getString("language"),
                            rs.getString("lookup_code"),
                            rs.getString("meaning"),
                            rs.getString("description"),
                            rs.getString("enabled_flag").charAt(0),
                            rs.getDate("start_date_active"),
                            rs.getDate("end_date_active")
                    );

            Author author = new Author (
                    rs.getLong("author_id"),
                    rs.getString("author_name"),
                    rs.getString("country"),
                    rs.getString("sex").charAt(0),
                    rs.getDate("date_of_birth")
            );

            PublishingHouse publishingHouse = new PublishingHouse(
                    rs.getLong("publishing_house_id"),
                    rs.getString("name"),
                    rs.getInt("settlement_year")
            );

            return new Book(
                            rs.getLong("book_id"),
                            rs.getString("book_name"),
                            lookupValue,
                            author,
                            publishingHouse,
                            rs.getInt("publishing_year"),
                            rs.getInt("pages")
                    );
        }
    }

}
