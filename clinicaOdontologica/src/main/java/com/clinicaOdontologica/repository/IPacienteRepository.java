package com.clinicaOdontologica.repository;
import com.clinicaOdontologica.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPacienteRepository extends JpaRepository<Paciente, Long> {
}