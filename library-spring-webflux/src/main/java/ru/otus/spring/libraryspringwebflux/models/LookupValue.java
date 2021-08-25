package ru.otus.spring.libraryspringwebflux.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "lookupValues")
public class LookupValue {

    @Transient
    public static final String GENRES_LOOKUP_TYPE = "GENRES";
    @Transient
    public static final String LOOKUP_COLLECTION_NAME = "lookupValues"; // TODO: А надо бы lookupvalues
    @Transient
    public static final String US = "US";
    @Transient
    public static final String RU = "RU";

    @Id
    private String id; // Облегчил себе жизнь
    @Field(name = "lookup_type")
    private String lookupType;
    @Field(name = "lookup_code")
    private String lookupCode;
    @Field(name = "language")
    private String language;
    @Field(name = "enabled_flag")
    private char enabledFlag;
    @Field(name = "start_date_active")
    private LocalDate startDateActive;
    @Field(name = "end_date_active")
    private LocalDate endDateActive;
    @Field(name = "meaning")
    private String meaning;
    @Field(name = "description")
    private String description;
}
