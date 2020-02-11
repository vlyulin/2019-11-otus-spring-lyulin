package ru.otus.spring.libraryspringnosql.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LookupValue {
    @Field(name = "lookup_type")
    private String lookupType;
    @Field(name = "lookup_code")
    private String lookupCode;
    @Field(name = "language")
    private String language;
    @Field(name = "enabled_flag")
    private char enabledFlag;
    @Field(name = "start_date_active")
    private LocalDate startDateActive; // = LocalDate.MIN;
    @Field(name = "end_date_active")
    private LocalDate endDateActive; // = LocalDate.MAX;
    @Field(name = "meaning")
    private String meaning;
    @Field(name = "description")
    private String description;
}
