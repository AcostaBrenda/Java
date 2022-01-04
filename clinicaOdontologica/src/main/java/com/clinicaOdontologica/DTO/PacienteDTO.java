package com.clinicaOdontologica.DTO;

import com.clinicaOdontologica.model.Domicilio;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PacienteDTO {

    private Domicilio domicilio;
    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fechaIngreso;
}
