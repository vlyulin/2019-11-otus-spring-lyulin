package ru.otus.spring.libraryorm.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@EqualsAndHashCode
@Entity
@Table(name = "lookup_values")
public class LookupValue implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lookup_value_id", updatable = false, nullable = false)
    private long id;
    // Поля из LookupValueId
    @Column(name = "lookup_type")
    private String lookupType;
    @Column(name = "lookup_code")
    private String lookupCode;
    @Column(name = "language")
    private String language;
    //
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
