package com.clinicaOdontologica.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Odontologo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)    //bidireccional
    private Set<Turno> turnos = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)   //bidireccional
    @JoinColumn(name = "domicilio_id", nullable = false)
    private Domicilio domicilio;

    @Column(unique = false, length = 50)
    private String nombre;

    @Column(unique = false, length = 50)
    private String apellido;

    @Column(unique = true,nullable = false)
    private Integer matricula;

    public Odontologo() {
    }

    public Odontologo(String nombre, String apellido, Integer matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }

    public Odontologo(Long id, String nombre, String apellido, Integer matricula) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(Set<Turno> turnos) {
        this.turnos = turnos;
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

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Odontologo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", matricula=" + matricula +
                '}';
    }
}
