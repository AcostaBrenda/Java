package com.medicalClinic.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.medicalClinic.model.Rol;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {
    private String mail;
    private String password;
    private Rol rol;
    private Long person_id;
}

