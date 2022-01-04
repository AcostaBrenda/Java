package com.medicalClinic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "doctor")
public class Doctor extends GenericPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50,nullable = false)
    private String enrollment;

    @Column(length = 50, nullable = false)
    private String speciality;

    @JsonIgnore
    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)                      //bidireccional
    private List<MedicalAppointment> medicalAppointments = new ArrayList<>();
}