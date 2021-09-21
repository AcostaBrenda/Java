package com.clinicaOdontologica.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DomicilioDto {
    private String calle;
    private Integer numero;
    private String localidad;
    private String provincia;
}
