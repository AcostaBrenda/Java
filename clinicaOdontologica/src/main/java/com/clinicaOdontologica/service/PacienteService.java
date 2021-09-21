package com.clinicaOdontologica.service;

import com.clinicaOdontologica.dto.PacienteDto;
import com.clinicaOdontologica.model.Paciente;
import com.clinicaOdontologica.repository.IPacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService implements IGenericaService <PacienteDto, Long> {

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    private ObjectMapper mapper;

    @Override
    public PacienteDto buscar(Long id) {
        Paciente paciente = pacienteRepository.findById(id).orElse(null);
        return mapper.convertValue(paciente,PacienteDto.class);
    }

    @Override
    public PacienteDto guardar(PacienteDto pacienteDto) {
        Paciente paciente = new Paciente();
        paciente.setDomicilio(pacienteDto.getDomicilio());
        paciente.setNombre(pacienteDto.getNombre());
        paciente.setApellido(pacienteDto.getApellido());
        paciente.setDni(pacienteDto.getDni());
        paciente.setFechaIngreso(pacienteDto.getFechaIngreso());
        return mapper.convertValue(pacienteRepository.save(paciente),PacienteDto.class);

    }

    @Override
    public Boolean eliminar(Long id) {
        pacienteRepository.deleteById(id);
        return (this.buscar(id)== null);
    }

    @Override
    public List<PacienteDto> buscarTodos() {
        List<PacienteDto> lp = mapper.convertValue(pacienteRepository.findAll(), List.class);
        return lp;
    }

    @Override
    public PacienteDto actualizar(PacienteDto pacienteDto,Long id) {
        Paciente paciente = mapper.convertValue(this.buscar(id),Paciente.class);
        if(paciente != null){
            paciente.setDomicilio(pacienteDto.getDomicilio());
            paciente.setNombre(pacienteDto.getNombre());
            paciente.setApellido(pacienteDto.getApellido());
            paciente.setDni(pacienteDto.getDni());
            paciente.setFechaIngreso(pacienteDto.getFechaIngreso());
            return mapper.convertValue(pacienteRepository.save(paciente),PacienteDto.class);
        }else{
            return null;
        }

    }

}