package ru.otus.spring.library.domain;

import java.util.Objects;

public class PublishingHouse {
    private long id;
    private String name;
    private int settlementYear;

    public PublishingHouse(long id, String name, int settlementYear) {
        this.id = id;
        this.name = name;
        this.settlementYear = settlementYear;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSettlementYear() {
        return settlementYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PublishingHouse)) return false;
        PublishingHouse that = (PublishingHouse) o;
        return id == that.id &&
                name.equals(that.name) &&
                settlementYear == that.settlementYear;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, settlementYear);
    }
}
