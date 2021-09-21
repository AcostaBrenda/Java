package com.clinicaOdontologica.model;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)                    //bidireccional
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)                    //bidireccional
    @JoinColumn(name = "odontologo_id", nullable = false)
    private Odontologo odontologo;

    @CreationTimestamp
    private LocalDate fecha;
}