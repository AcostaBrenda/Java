package com.medicalClinic.service;

import com.medicalClinic.DTO.DoctorDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medicalClinic.repository.IDoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DoctorService implements IGenericService<DoctorDTO, Long> {

    @Autowired
    private IDoctorRepository doctorRepository;

    @Autowired
    private ObjectMapper mapper;

    @Override
    public DoctorDTO find(Long aLong) {
        return null;
    }

    @Override
    public DoctorDTO save(DoctorDTO doctorDTO) {
        return null;
    }

    @Override
    public Boolean delete(DoctorDTO doctorDTO) {
        return null;
    }

    @Override
    public List<DoctorDTO> findAll() {
        return null;
    }

    @Override
    public DoctorDTO update(DoctorDTO doctorDTO, Long aLong) {
        return null;
    }
}