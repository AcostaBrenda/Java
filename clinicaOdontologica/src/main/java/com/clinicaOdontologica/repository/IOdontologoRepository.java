package com.clinicaOdontologica.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.clinicaOdontologica.model.Odontologo;

public interface IOdontologoRepository extends JpaRepository<Odontologo, Long> {
}