package com.clinicaOdontologica.service;

import com.clinicaOdontologica.DTO.PacienteDTO;
import com.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.clinicaOdontologica.model.Paciente;
import com.clinicaOdontologica.repository.IPacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteService implements IGenericaService <PacienteDTO, Long> {

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    private ObjectMapper mapper;

    static final Logger logger = Logger.getLogger(PacienteService.class);

    @Override
    public PacienteDTO buscar(Long id) throws ResourceNotFoundException{
        Paciente paciente = pacienteRepository.findById(id).orElse(null);
        if(paciente != null){
        return mapper.convertValue(paciente, PacienteDTO.class);
    }else{
          throw new ResourceNotFoundException("El paciente con los datos ingresados no existe en el sistema");
     }
    }


    @Override
    public PacienteDTO guardar(PacienteDTO pacienteDto) {
        Paciente paciente = new Paciente();
        paciente.setDomicilio(pacienteDto.getDomicilio());
        paciente.setNombre(pacienteDto.getNombre());
        paciente.setApellido(pacienteDto.getApellido());
        paciente.setDni(pacienteDto.getDni());
        paciente.setFechaIngreso(pacienteDto.getFechaIngreso());
        return mapper.convertValue(pacienteRepository.save(paciente), PacienteDTO.class);

    }

    @Override
    public Boolean eliminar(Long id){
        if(pacienteRepository.findById(id).isPresent()){
            pacienteRepository.deleteById(id);
        }
        return pacienteRepository.findById(id).isPresent();
    }

    @Override
    public List<PacienteDTO> buscarTodos() {
        List<PacienteDTO> listaPacientesDTO = new ArrayList<>();
        List<Paciente> listaPacientes = pacienteRepository.findAll();
        for (Paciente paciente : listaPacientes) {
            PacienteDTO pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);
            listaPacientesDTO.add(pacienteDTO);
        }
        logger.info("Lista de pacientes existentes: " + listaPacientesDTO);
        return listaPacientesDTO;
    }

    @Override
    public PacienteDTO actualizar(PacienteDTO pacienteDto, Long id) throws ResourceNotFoundException{
        Paciente paciente = mapper.convertValue(this.buscar(id),Paciente.class);
        if(paciente != null){
            paciente.setDomicilio(pacienteDto.getDomicilio());
            paciente.setNombre(pacienteDto.getNombre());
            paciente.setApellido(pacienteDto.getApellido());
            paciente.setDni(pacienteDto.getDni());
            paciente.setFechaIngreso(pacienteDto.getFechaIngreso());
            return mapper.convertValue(pacienteRepository.save(paciente), PacienteDTO.class);
        }else{
            throw new ResourceNotFoundException("El paciente con los datos ingresados no existe en el sistema");
        }
    }
}