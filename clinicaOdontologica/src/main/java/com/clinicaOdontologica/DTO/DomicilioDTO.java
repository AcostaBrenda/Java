package com.clinicaOdontologica.DTO;
import com.clinicaOdontologica.model.Odontologo;
import com.clinicaOdontologica.model.Paciente;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DomicilioDTO {
    private String calle;
    private Integer numero;
    private String localidad;
    private String provincia;
    private List<Paciente> pacientes;
    private List<Odontologo> odontologos;
}
