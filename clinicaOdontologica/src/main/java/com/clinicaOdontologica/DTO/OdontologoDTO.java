package com.clinicaOdontologica.DTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OdontologoDTO {
    private String nombre;
    private String apellido;
    private Integer matricula;
}
