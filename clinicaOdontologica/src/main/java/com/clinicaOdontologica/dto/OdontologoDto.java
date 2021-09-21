package com.clinicaOdontologica.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OdontologoDto {
    private String nombre;
    private String apellido;
    private Integer matricula;
}
