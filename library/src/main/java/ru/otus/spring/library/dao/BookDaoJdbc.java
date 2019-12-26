package ru.otus.spring.library.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.spring.library.domain.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SuppressWarnings({"SqlNoDataSourceInspection", "ConstantConditions", "SqlDialectInspection"})
@Repository
public class BookDaoJdbc implements BookDao {

    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    public BookDaoJdbc(NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
    }

    @Override
    public int count() {
        return namedParameterJdbcOperations.queryForObject ("select count(1) from books", new HashMap<String,Object>(), Integer.class);
    }

    @Override
    public void insert(Book book) {

        Map<String, Object> params = Map.of(
                "book_id", book.getId(),
                "name", book.getName(),
                "genre", book.getGenre(),
                "author_id", book.getAuthorId(),
                "publishing_house_id", book.getPublishingHouseId(),
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
        Map<String, Object> params = Collections.singletonMap("book_id", id);
        return namedParameterJdbcOperations.queryForObject(
                "select b.book_id, b.name, b.genre, b.author_id, b.publishing_house_id, b.publishing_year, b.pages\n" +
                        "from books b\n" +
                        "where book_id = :book_id",
                params,
                new BookDaoJdbc.BookMapper()
        );
    }

    @Override
    public List<Book> getAll() {
        return namedParameterJdbcOperations.query(
                "select b.book_id, b.name, b.genre, b.author_id, b.publishing_house_id, b.publishing_year, b.pages\n" +
                        "from books b",
                new BookDaoJdbc.BookMapper()
        );
    }

    @Override
    public List<Book> getBooks(String bookName, String genreCode, String authorName, String publishingHouseName, int publishingYear, int pages) {

        // Скорее всего должен быть более простой путь передать null, если String = ''
        String _bookName = (bookName == null || bookName.isBlank() || bookName.isEmpty())?null:bookName;
        String _genreCode = (genreCode == null || genreCode.isBlank() || genreCode.isEmpty())?null:genreCode;
        String _authorName = (authorName == null || authorName.isBlank() || authorName.isEmpty())?null:authorName;
        String _publishingHouseName = (publishingHouseName == null || publishingHouseName.isBlank() || publishingHouseName.isEmpty())?null:publishingHouseName;
        String _publishingYear = (publishingYear == 0)?null:String.valueOf(publishingYear);
        String _pages = (pages == 0)?null:String.valueOf(pages);

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("book_name", _bookName);
        parameters.addValue("genre_code", _genreCode);
        parameters.addValue("author_name", _authorName);
        parameters.addValue("publishing_house_name", _publishingHouseName);
        parameters.addValue("publishing_year", _publishingYear);
        parameters.addValue("pages", _pages);

        return namedParameterJdbcOperations.query(
                "select b.book_id, b.name, b.genre, b.author_id, b.publishing_house_id, b.publishing_year, b.pages\n" +
                        "from books b\n" +
                        ", authors a\n" +
                        ", publishing_houses h\n" +
                        "where 1 = 1\n" +
                        "and b.author_id = a.author_id\n" +
                        "and b.publishing_house_id = h.publishing_house_id\n" +
                        "and (:book_name is null or (b.name like :book_name))\n" +
                        "and (:genre_code is null or b.genre like UPPER(:genre_code))\n" +
                        "and (:author_name is null or UPPER(a.name) like UPPER(:author_name))\n" +
                        "and (:publishing_house_name is null or UPPER(h.name) like UPPER(:publishing_house_name))\n" +
                        "and (:publishing_year is null or b.publishing_year = :publishing_year)\n" +
                        "and (:pages is null or b.pages = :pages)"
                ,parameters
                ,new BookDaoJdbc.BookMapper()
        );
    }

    @Override
    public void deleteById(long id) {
        Map<String, Object> params = Collections.singletonMap("book_id", id);
        namedParameterJdbcOperations.update(
                "delete from books where book_id = :book_id", params
        );
    }

    private static class BookMapper implements RowMapper<Book> {
        @Override
        public Book mapRow(ResultSet resultSet, int i) throws SQLException {
            long book_id = resultSet.getLong("book_id");
            String name = resultSet.getString("name");
            String genre = resultSet.getString("genre");
            long author_id = resultSet.getLong("author_id");
            long publishing_house_id = resultSet.getLong("publishing_house_id");
            int publishing_year = resultSet.getInt("publishing_year");
            int pages = resultSet.getInt("pages");

            Book book = new Book(book_id, name, genre, author_id, publishing_house_id, publishing_year, pages);
            return book;
        }
    }
}
