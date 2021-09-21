package com.clinicaOdontologica.service;

import com.clinicaOdontologica.dto.DomicilioDto;
import com.clinicaOdontologica.model.Domicilio;
import com.clinicaOdontologica.repository.IDomicilioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DomicilioService implements IGenericaService <DomicilioDto, Long> {

    @Autowired
    private IDomicilioRepository domicilioRepository;

    @Autowired
    private ObjectMapper mapper;

    @Override
    public DomicilioDto buscar(Long id) {
        Domicilio domicilio = domicilioRepository.findById(id).orElse(null);
        return mapper.convertValue(domicilio,DomicilioDto.class);
    }

    @Override
    public DomicilioDto guardar(DomicilioDto domicilioDto) {
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle(domicilioDto.getCalle());
        domicilio.setNumero(domicilioDto.getNumero());
        domicilio.setLocalidad(domicilioDto.getLocalidad());
        domicilio.setProvincia(domicilioDto.getProvincia());
        return mapper.convertValue(domicilioRepository.save(domicilio),DomicilioDto.class);
    }

    @Override
    public Boolean eliminar(Long id) {
        domicilioRepository.deleteById(id);
        return (this.buscar(id)== null);
    }

    @Override
    public List<DomicilioDto> buscarTodos() {
        List<DomicilioDto> ld = mapper.convertValue(domicilioRepository.findAll(), List.class);
        return ld;
    }

    @Override
    public DomicilioDto actualizar(DomicilioDto domicilioDto,Long id) {
        Domicilio domicilio = mapper.convertValue(this.buscar(id),Domicilio.class);
        if(domicilio != null){
            domicilio.setCalle(domicilioDto.getCalle());
            domicilio.setNumero(domicilioDto.getNumero());
            domicilio.setLocalidad(domicilioDto.getLocalidad());
            domicilio.setProvincia(domicilioDto.getProvincia());
            return mapper.convertValue(domicilioRepository.save(domicilio),DomicilioDto.class);
        }else{
            return null;
        }

    }

}