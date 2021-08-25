package ru.otus.spring.library.rest.models;

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
@Table(name = "lookup_values")
public class LookupValue implements Serializable {

    @EmbeddedId
    LookupValueId key;
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
