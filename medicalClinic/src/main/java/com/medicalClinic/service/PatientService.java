package com.medicalClinic.service;

import com.medicalClinic.DTO.PatientDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService implements IGenericService<PatientDTO, Long> {

    @Autowired
    private ObjectMapper mapper;


    @Override
    public PatientDTO find(Long aLong) {
        return null;
    }

    @Override
    public PatientDTO save(PatientDTO patientDTO) {
        return null;
    }

    @Override
    public Boolean delete(PatientDTO patientDTO) {
        return null;
    }

    @Override
    public List<PatientDTO> findAll() {
        return null;
    }

    @Override
    public PatientDTO update(PatientDTO patientDTO, Long aLong) {
        return null;
    }
}