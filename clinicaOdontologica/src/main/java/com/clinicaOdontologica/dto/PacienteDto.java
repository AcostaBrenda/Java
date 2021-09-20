package com.clinicaOdontologica.dto;

import com.clinicaOdontologica.model.Domicilio;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PacienteDto {

    private Domicilio domicilio;
    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fechaIngreso;

    public PacienteDto() {
    }

    public PacienteDto(Domicilio domicilio, String nombre, String apellido, String dni, LocalDate fechaIngreso) {
        this.domicilio = domicilio;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}
