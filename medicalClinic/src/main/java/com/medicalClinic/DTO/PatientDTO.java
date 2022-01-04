package com.medicalClinic.DTO;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.medicalClinic.model.MedicalInsurance;
import com.medicalClinic.model.GenericPerson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PatientDTO {

    private MedicalInsurance medicalInsurance;
    private GenericPerson genericPerson;
}
