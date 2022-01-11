package com.clinicaOdontologica.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)    //bidireccional
    private List<Paciente> pacientes = new ArrayList<>();

    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)    //bidireccional
    private List<Odontologo> odontologos = new ArrayList<>();

    @Column(nullable = false)
    private String calle;

    @Column(length = 5, nullable = false)
    private int numero;

    @Column(nullable = false)
    private String localidad;

    @Column(nullable = false)
    private String provincia;
}

