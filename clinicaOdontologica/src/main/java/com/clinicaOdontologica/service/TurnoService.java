package com.clinicaOdontologica.service;

import com.clinicaOdontologica.model.Turno;
import com.clinicaOdontologica.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService implements IGenericaService <Turno>{

    @Autowired
    private ITurnoRepository turnoRepository;

    @Override
    public Turno buscar(Long id) {
        return turnoRepository.findById(id).orElse(null);
    }

    @Override
    public Turno guardar(Turno turno) {
        return turnoRepository.save(turno);
    }

    @Override
    public Boolean eliminar(Long id) {
        turnoRepository.deleteById(id);
        return (this.buscar(id)== null);
    }

    @Override
    public List<Turno> buscarTodos() {
        return turnoRepository.findAll();
    }

    @Override
    public Turno actualizar(Turno turno) {
       Turno t= this.buscar(turno.getId());
       if(t != null){
        t.setFecha(turno.getFecha());
        t.setPaciente(turno.getPaciente());
        t.setOdontologo(turno.getOdontologo());
        return turnoRepository.save(t);
       }else{
           return null;
       }
    }
}
