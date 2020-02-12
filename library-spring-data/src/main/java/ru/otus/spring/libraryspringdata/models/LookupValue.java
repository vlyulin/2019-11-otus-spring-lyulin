package ru.otus.spring.libraryspringdata.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
// @IdClass(LookupValueId.class)
@Table(name = "lookup_values")
public class LookupValue implements Serializable {

    @EmbeddedId
    LookupValueId key;

//    @Id @Column(name = "lookup_type")
//    private String lookupType;
//    @Id @Column(name = "lookup_code")
//    private String lookupCode;
//    @Id @Column(name = "language")
//    private String language;

    @Column(name = "enabled_flag")
    private char enabledFlag;
    @Column(name = "start_date_active")
    private LocalDate startDateActive = LocalDate.MIN;
    @Column(name = "end_date_active")
    private LocalDate endDateActive = LocalDate.MAX;
    @Column(name = "meaning", nullable = false)
    private String meaning;
    @Column(name = "description")
    private String description;
}
