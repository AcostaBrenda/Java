package com.medicalClinic.DTO;

import com.medicalClinic.model.Doctor;
import com.medicalClinic.model.Patient;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MedicalAppointmentDTO {

    private Doctor doctor;
    private Patient patient;
    private LocalDate date;
}
