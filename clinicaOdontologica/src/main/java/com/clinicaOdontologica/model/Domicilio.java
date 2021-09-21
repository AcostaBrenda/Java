package com.clinicaOdontologica.model;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)    //bidireccional
    private Set<Paciente> pacientes = new HashSet<>();

    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)    //bidireccional
    private Set<Odontologo> odontologos = new HashSet<>();

    @Column(nullable = false)
    private String calle;

    @Column(length = 5)
    private Integer numero;

    @Column(nullable = false)
    private String localidad;

    @Column(nullable = false)
    private String provincia;
}

