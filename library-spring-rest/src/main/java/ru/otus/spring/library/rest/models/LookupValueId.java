package ru.otus.spring.library.rest.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class LookupValueId implements Serializable {

    //    @Id @Column(name = "lookup_type")
//    private String lookupType;
//    @Id @Column(name = "lookup_code")
//    private String lookupCode;
//    @Id @Column(name = "language")
//    private String language;

    @Column(name = "lookup_type")
    private String lookupType;
    @Column(name = "lookup_code")
    private String lookupCode;
    @Column(name = "language")
    private String language;
}
