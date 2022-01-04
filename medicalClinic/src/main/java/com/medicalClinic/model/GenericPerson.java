package com.medicalClinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class GenericPerson {

    private String name;

    private String lastname;

    private int dni;

    @CreationTimestamp
    private LocalDate dateOfEntry;

    @OneToOne(optional = false,fetch =FetchType.LAZY,cascade = CascadeType.ALL)  //unidireccional
    @JoinColumn(name = "user_id", referencedColumnName ="id",unique = true )
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)                          //unidireccional
    @JoinColumn(name = "address_id")
    private Address address;
}
