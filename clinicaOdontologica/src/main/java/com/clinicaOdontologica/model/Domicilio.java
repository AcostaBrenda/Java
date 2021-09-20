package com.clinicaOdontologica.model;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)    //bidireccional
    private Set<Paciente> pacientes = new HashSet<>();

    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)    //bidireccional
    private Set<Odontologo> odontologos = new HashSet<>();

    @Column(nullable = false)
    private String calle;

    @Column(length = 5)
    private Integer numero;

    @Column(nullable = false)
    private String localidad;

    @Column(nullable = false)
    private String provincia;

    public Domicilio() {
    }

    public Domicilio(Long id, String calle, Integer numero, String localidad, String provincia) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }
    public Domicilio( String calle, Integer numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "Domicilio{" +
                "id=" + id +
                ", calle='" + calle + '\'' +
                ", numero='" + numero + '\'' +
                ", localidad='" + localidad + '\'' +
                ", provincia='" + provincia + '\'' +
                '}';
    }
}

