package com.medicalClinic.repository;

import com.medicalClinic.model.MedicalAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMedicalAppointmentRepository extends JpaRepository<MedicalAppointment, Long>{
}
