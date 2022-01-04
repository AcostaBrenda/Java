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
@Table(name = "patient")
public class Patient extends GenericPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)                                      //unidireccional
    @JoinColumn(name = "medical_insurance_id")
    private MedicalInsurance medicalInsurance;

    @JsonIgnore
    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)                        //bidireccional
    private List<MedicalAppointment> medicalAppointments = new ArrayList<>();
}
