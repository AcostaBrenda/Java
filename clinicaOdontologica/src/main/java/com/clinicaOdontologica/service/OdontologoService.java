package com.clinicaOdontologica.service;

import com.clinicaOdontologica.model.Odontologo;
import com.clinicaOdontologica.repository.IOdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OdontologoService implements IGenericaService <Odontologo> {

    @Autowired
    private IOdontologoRepository odontologoRepository;

    @Override
    public Odontologo buscar(Long id) {
        return odontologoRepository.findById(id).orElse(null);
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }

    @Override
    public Boolean eliminar(Long id) {
        odontologoRepository.deleteById(id);
        return (this.buscar(id)== null);
    }

    @Override
    public List<Odontologo> buscarTodos() {
        return odontologoRepository.findAll();
    }

    @Override
    public Odontologo actualizar(Odontologo odontologo) {
        Odontologo o= this.buscar(odontologo.getId());
        if(o != null){
            o.setNombre(odontologo.getNombre());
            o.setApellido(odontologo.getApellido());
            o.setMatricula(odontologo.getMatricula());
            o.setDomicilio(odontologo.getDomicilio());
            return odontologoRepository.save(o);
        }else{
        return null;
    }

  }

}