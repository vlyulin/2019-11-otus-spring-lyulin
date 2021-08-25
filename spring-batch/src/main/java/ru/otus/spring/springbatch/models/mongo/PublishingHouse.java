package ru.otus.spring.springbatch.models.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublishingHouse {
    @Field(name = "name")
    private String name;
    @Field(name = "settlement_year")
    private int settlementYear;
}
