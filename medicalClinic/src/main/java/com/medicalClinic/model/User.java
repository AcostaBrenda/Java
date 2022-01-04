package com.medicalClinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, unique = true,nullable = false)
    private String mail;

    @Column(nullable = false)
    private String password;

    @ManyToOne(cascade = CascadeType.ALL)  //unidireccional
    @JoinColumn(name = "rol_id")
    private Rol rol;
}
