package com.clinicaOdontologica.DTO;
import com.clinicaOdontologica.model.Domicilio;
import com.clinicaOdontologica.model.Turno;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OdontologoDTO {

    private String nombre;
    private String apellido;
    private Integer matricula;
    private Domicilio domicilio;
    private List<Turno> turnos;
}
