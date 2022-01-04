package com.clinicaOdontologica.service;

import com.clinicaOdontologica.DTO.TurnoDTO;
import com.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.clinicaOdontologica.model.Turno;
import com.clinicaOdontologica.repository.ITurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TurnoService implements IGenericaService <TurnoDTO, Long> {

    @Autowired
    private ITurnoRepository turnoRepository;

    @Autowired
    private ObjectMapper mapper;

    static final Logger logger = Logger.getLogger(TurnoService.class);

    @Override
    public TurnoDTO buscar(Long id) throws ResourceNotFoundException {
        Turno turno = turnoRepository.findById(id).orElse(null);
    if(turno != null){
        return mapper.convertValue(turno, TurnoDTO.class);
    }else{
        throw new ResourceNotFoundException("El turno no existe en el sistema");
          }
    }

    @Override
    public TurnoDTO guardar(TurnoDTO turnoDto) {
        Turno turno = new Turno();
        turno.setPaciente(turnoDto.getPaciente());
        turno.setOdontologo(turnoDto.getOdontologo());
        turno.setFecha(turnoDto.getFecha());
        return mapper.convertValue(turnoRepository.save(turno), TurnoDTO.class);

    }

    @Override
    public Boolean eliminar(Long id){
        if(turnoRepository.findById(id).isPresent()){
            turnoRepository.deleteById(id);
        }
        return turnoRepository.findById(id).isPresent();
    }

    @Override
    public List<TurnoDTO> buscarTodos() {
        List<TurnoDTO> listaTurnosDTO = new ArrayList<>();
        List<Turno> listaTurnos = turnoRepository.findAll();
        for (Turno turno : listaTurnos) {
            TurnoDTO turnoDTO = mapper.convertValue(turno, TurnoDTO.class);
            listaTurnosDTO.add(turnoDTO);
        }
        logger.info("Lista de turnos existentes: " + listaTurnosDTO);
        return listaTurnosDTO;
    }


    @Override
    public TurnoDTO actualizar(TurnoDTO turnoDto, Long id) throws ResourceNotFoundException {
        Turno turno = mapper.convertValue(this.buscar(id),Turno.class);
        if(turno != null){
            turno.setPaciente(turnoDto.getPaciente());
            turno.setOdontologo(turnoDto.getOdontologo());
            turno.setFecha(turnoDto.getFecha());
            return mapper.convertValue(turnoRepository.save(turno), TurnoDTO.class);
        }else{
           throw new ResourceNotFoundException("El turno no existe en el sistema");
        }

    }
}
