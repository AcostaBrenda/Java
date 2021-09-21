package com.clinicaOdontologica.dto;

import com.clinicaOdontologica.model.Domicilio;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PacienteDto {

    private Domicilio domicilio;
    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fechaIngreso;
}
