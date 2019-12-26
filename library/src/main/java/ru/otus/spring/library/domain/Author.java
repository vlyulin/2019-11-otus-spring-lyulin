package ru.otus.spring.library.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Author {
    private long id;
    private String country;
    private char sex;
    private Date date_of_birth;
    private String name;

    public Author(long id, String name, String country, char sex, Date date_of_birth) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.sex = sex;
        // Избавляемся от времени
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.date_of_birth = formatter.parse(formatter.format(date_of_birth));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public long getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public char getSex() {
        return sex;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        Author author = (Author) o;
        return id == author.id &&
                sex == author.sex &&
                country.equals(author.country) &&
                date_of_birth.equals(author.date_of_birth) &&
                name.equals(author.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, sex, date_of_birth, name);
    }
}
