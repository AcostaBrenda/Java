package com.clinicaOdontologica.repository;
import com.clinicaOdontologica.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITurnoRepository extends JpaRepository<Turno, Long> {
}