package com.clinicaOdontologica.service;

import com.clinicaOdontologica.DTO.DomicilioDTO;
import com.clinicaOdontologica.DTO.TurnoDTO;
import com.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.clinicaOdontologica.model.Domicilio;
import com.clinicaOdontologica.model.Turno;
import com.clinicaOdontologica.repository.IDomicilioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DomicilioService implements IGenericaService <DomicilioDTO, Long> {

    @Autowired
    private IDomicilioRepository domicilioRepository;

    @Autowired
    private ObjectMapper mapper;

    static final Logger logger = Logger.getLogger(DomicilioService.class);

    @Override
    public DomicilioDTO buscar(Long id) throws ResourceNotFoundException {
        Domicilio domicilio = domicilioRepository.findById(id).orElse(null);
    if(domicilio != null){
        return mapper.convertValue(domicilio, DomicilioDTO.class);
    }else{
        throw new ResourceNotFoundException("El domicilio no existe en el sistema");
         }
    }

    @Override
    public DomicilioDTO guardar(DomicilioDTO domicilioDto) {
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle(domicilioDto.getCalle());
        domicilio.setNumero(domicilioDto.getNumero());
        domicilio.setLocalidad(domicilioDto.getLocalidad());
        domicilio.setProvincia(domicilioDto.getProvincia());
        return mapper.convertValue(domicilioRepository.save(domicilio), DomicilioDTO.class);
    }

    @Override
    public Boolean eliminar(Long id) throws ResourceNotFoundException{
         (domicilioRepository.findById(id).isPresent())?
                 domicilioRepository.deleteById(id):
                 throw new ResourceNotFoundException("El domicilio no existe en el sistema");
         }

    @Override
    public List<DomicilioDTO> buscarTodos() {
        List<DomicilioDTO> listaDomiciliosDTO = new ArrayList<>();
        List<Domicilio> listaDomicilios = domicilioRepository.findAll();
        for (Domicilio domicilio : listaDomicilios) {
            DomicilioDTO domicilioDTO = mapper.convertValue(domicilio, DomicilioDTO.class);
            listaDomiciliosDTO.add(domicilioDTO);
        }
        logger.info("Lista de domicilios existentes: " + listaDomiciliosDTO);
        return listaDomiciliosDTO;
    }

    @Override
    public DomicilioDTO actualizar(DomicilioDTO domicilioDto, Long id) throws ResourceNotFoundException{
        Domicilio domicilio = mapper.convertValue(this.buscar(id),Domicilio.class);
        if(domicilio != null){
            domicilio.setCalle(domicilioDto.getCalle());
            domicilio.setNumero(domicilioDto.getNumero());
            domicilio.setLocalidad(domicilioDto.getLocalidad());
            domicilio.setProvincia(domicilioDto.getProvincia());
            return mapper.convertValue(domicilioRepository.save(domicilio), DomicilioDTO.class);
        }else{
            throw new ResourceNotFoundException("El domicilio no existe en el sistema");
        }

    }

}