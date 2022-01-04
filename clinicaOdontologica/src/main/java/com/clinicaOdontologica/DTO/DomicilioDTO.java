package com.clinicaOdontologica.DTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DomicilioDTO {
    private String calle;
    private Integer numero;
    private String localidad;
    private String provincia;
}
