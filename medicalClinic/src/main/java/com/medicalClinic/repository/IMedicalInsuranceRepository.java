package com.medicalClinic.repository;

import com.medicalClinic.model.MedicalInsurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMedicalInsuranceRepository extends JpaRepository<MedicalInsurance,Long> {
}
