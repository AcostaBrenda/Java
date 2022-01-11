package com.clinicaOdontologica.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)    //bidireccional
    private List<Turno> turnos = new ArrayList<>();

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
