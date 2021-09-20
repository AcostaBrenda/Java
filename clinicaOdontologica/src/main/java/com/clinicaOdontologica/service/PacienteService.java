package com.clinicaOdontologica.service;

import com.clinicaOdontologica.model.Paciente;
import com.clinicaOdontologica.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService implements IGenericaService <Paciente>{

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Override
    public Paciente buscar(Long id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    @Override
    public Paciente guardar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public Boolean eliminar(Long id) {
        pacienteRepository.deleteById(id);
        return (this.buscar(id)== null);
    }

    @Override
    public List<Paciente> buscarTodos() {
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente actualizar(Paciente paciente) {
       Paciente p= this.buscar(paciente.getId());
       if(p != null){
           p.setNombre(paciente.getNombre());
           p.setApellido(paciente.getApellido());
           p.setDni(paciente.getDni());
           p.setDomicilio(paciente.getDomicilio());
           p.setFechaIngreso(paciente.getFechaIngreso());
           return pacienteRepository.save(p);
       }else{
           return null;
       }
    }
}
