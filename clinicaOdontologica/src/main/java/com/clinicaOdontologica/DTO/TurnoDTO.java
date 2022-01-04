package com.clinicaOdontologica.DTO;

import com.clinicaOdontologica.model.Odontologo;
import com.clinicaOdontologica.model.Paciente;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TurnoDTO {
    private Paciente paciente;
    private Odontologo odontologo;
    private LocalDate fecha;
}
