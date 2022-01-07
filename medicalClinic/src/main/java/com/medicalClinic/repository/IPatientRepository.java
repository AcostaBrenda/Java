package com.medicalClinic.repository;

import com.medicalClinic.model.Address;
import com.medicalClinic.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Long>{

    Address findByDni(int dni);
}
