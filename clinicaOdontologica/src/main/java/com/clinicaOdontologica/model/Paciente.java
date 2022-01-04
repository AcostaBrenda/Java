package com.clinicaOdontologica.model;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.HashSet;

@Data
@Entity
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)    //bidireccional
    private Set<Turno> turnos = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)                       //bidireccional
    @JoinColumn(name = "domicilio_id", nullable = false)
    private Domicilio domicilio;

    @Column(unique = false, length = 50)
    private String nombre;

    @Column(unique = false, length = 50)
    private String apellido;

    @Column(unique = true, length = 8)
    private String dni;

    @CreationTimestamp
    private LocalDate fechaIngreso;
}
