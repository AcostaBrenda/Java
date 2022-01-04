package com.medicalClinic.service;

import com.medicalClinic.DTO.MedicalAppointmentDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalAppointmentService implements IGenericService<MedicalAppointmentDTO, Long> {

    @Autowired
    private ObjectMapper mapper;

    @Override
    public MedicalAppointmentDTO find(Long aLong) {
        return null;
    }

    @Override
    public MedicalAppointmentDTO save(MedicalAppointmentDTO medicalAppointmentDTO) {
        return null;
    }

    @Override
    public Boolean delete(MedicalAppointmentDTO medicalAppointmentDTO) {
        return null;
    }

    @Override
    public List<MedicalAppointmentDTO> findAll() {
        return null;
    }

    @Override
    public MedicalAppointmentDTO update(MedicalAppointmentDTO medicalAppointmentDTO, Long aLong) {
        return null;
    }
}
