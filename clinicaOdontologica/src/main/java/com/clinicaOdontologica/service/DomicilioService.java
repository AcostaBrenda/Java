package com.clinicaOdontologica.service;

import com.clinicaOdontologica.model.Domicilio;
import com.clinicaOdontologica.repository.IDomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DomicilioService implements IGenericaService<Domicilio>{

    @Autowired
    private IDomicilioRepository domicilioRepository;

    @Override
    public Domicilio buscar(Long id) {
        return domicilioRepository.findById(id).orElse(null);
    }

    @Override
    public Domicilio guardar(Domicilio domicilio) {
        return domicilioRepository.save(domicilio);
    }

    @Override
    public Boolean eliminar(Long id) {
        domicilioRepository.deleteById(id);
        return (this.buscar(id)== null);
    }

    @Override
    public List<Domicilio> buscarTodos() {
        return domicilioRepository.findAll();
    }

    @Override
    public Domicilio actualizar(Domicilio domicilio){
        Domicilio d =this.buscar(domicilio.getId());
        if(d != null) {
            d.setCalle(domicilio.getCalle());
            d.setNumero(domicilio.getNumero());
            d.setLocalidad(domicilio.getLocalidad());
            d.setProvincia(domicilio.getProvincia());
            return domicilioRepository.save(d);
        }else {
            return null;
        }
    }
}
