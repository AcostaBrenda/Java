package com.medicalClinic.repository;

import com.medicalClinic.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Long>{

    Patient findByDni(int dni);
}
