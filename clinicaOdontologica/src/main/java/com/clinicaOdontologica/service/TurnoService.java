package com.clinicaOdontologica.service;

import com.clinicaOdontologica.dto.TurnoDto;
import com.clinicaOdontologica.model.Turno;
import com.clinicaOdontologica.repository.ITurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService implements IGenericaService <TurnoDto, Long> {

    @Autowired
    private ITurnoRepository turnoRepository;

    @Autowired
    private ObjectMapper mapper;

    @Override
    public TurnoDto buscar(Long id) {
        Turno turno = turnoRepository.findById(id).orElse(null);
        return mapper.convertValue(turno,TurnoDto.class);
    }

    @Override
    public TurnoDto guardar(TurnoDto turnoDto) {
        Turno turno = new Turno();
        turno.setPaciente(turnoDto.getPaciente());
        turno.setOdontologo(turnoDto.getOdontologo());
        turno.setFecha(turnoDto.getFecha());
        return mapper.convertValue(turnoRepository.save(turno),TurnoDto.class);

    }

    @Override
    public Boolean eliminar(Long id) {
        turnoRepository.deleteById(id);
        return (this.buscar(id)== null);
    }

    @Override
    public List<TurnoDto> buscarTodos() {
        List<TurnoDto> lt = mapper.convertValue(turnoRepository.findAll(), List.class);
        return lt;
    }

    @Override
    public TurnoDto actualizar(TurnoDto turnoDto,Long id) {
        Turno turno = mapper.convertValue(this.buscar(id),Turno.class);
        if(turno != null){
            turno.setPaciente(turnoDto.getPaciente());
            turno.setOdontologo(turnoDto.getOdontologo());
            turno.setFecha(turnoDto.getFecha());
            return mapper.convertValue(turnoRepository.save(turno),TurnoDto.class);
        }else{
            return null;
        }

    }

}
