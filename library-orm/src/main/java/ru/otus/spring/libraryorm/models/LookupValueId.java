package ru.otus.spring.libraryorm.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class LookupValueId implements Serializable {
    @Column(name = "lookup_type")
    private String lookupType;
    @Column(name = "lookup_code")
    private String lookupCode;
    @Column(name = "language")
    private String language;
}
