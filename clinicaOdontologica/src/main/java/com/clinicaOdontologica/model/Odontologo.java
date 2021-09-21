package com.clinicaOdontologica.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Odontologo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)    //bidireccional
    private Set<Turno> turnos = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)   //bidireccional
    @JoinColumn(name = "domicilio_id", nullable = false)
    private Domicilio domicilio;

    @Column(unique = false, length = 50)
    private String nombre;

    @Column(unique = false, length = 50)
    private String apellido;

    @Column(unique = true,nullable = false)
    private Integer matricula;
}
