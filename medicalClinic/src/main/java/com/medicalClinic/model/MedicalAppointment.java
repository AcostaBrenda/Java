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
@Entity
@Table(name = "medical_appointment")
public class MedicalAppointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)                    //unidireccional
    @JoinColumn(name = "state_id")
    private State state;

    @ManyToOne(fetch = FetchType.LAZY)                       //bidireccional
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)                       //bidireccional
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @CreationTimestamp  //Hibernate obtiene la marca de tiempo actual de la máquina virtual y la establece como el valor del atributo anotado
    private LocalDate date;
}