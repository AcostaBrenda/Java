package com.clinicaOdontologica.service;

import com.clinicaOdontologica.DTO.OdontologoDTO;
import com.clinicaOdontologica.DTO.TurnoDTO;
import com.clinicaOdontologica.model.Odontologo;
import com.clinicaOdontologica.model.Turno;
import com.clinicaOdontologica.repository.IOdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OdontologoService implements IGenericaService <OdontologoDTO, Long> {

    @Autowired
    private IOdontologoRepository odontologoRepository;

    @Autowired
    private ObjectMapper mapper;

    static final Logger logger = Logger.getLogger(OdontologoService.class);

    @Override
    public OdontologoDTO buscar(Long id) {
        Odontologo odontologo = odontologoRepository.findById(id).orElse(null);
        return mapper.convertValue(odontologo, OdontologoDTO.class);
    }

    @Override
    public OdontologoDTO guardar(OdontologoDTO odontologoDto) {
       Odontologo odontologo = new Odontologo();
       odontologo.setNombre(odontologoDto.getNombre());
       odontologo.setApellido(odontologoDto.getApellido());
       odontologo.setMatricula(odontologoDto.getMatricula());
       return mapper.convertValue(odontologoRepository.save(odontologo), OdontologoDTO.class);

    }

    @Override
    public Boolean eliminar(Long id) {
        odontologoRepository.deleteById(id);
        return (this.buscar(id)== null);
    }

    @Override
    public List<OdontologoDTO> buscarTodos() {
        List<OdontologoDTO> listaOdontologoDTO = new ArrayList<>();
        List<Odontologo> listaOdontologos = odontologoRepository.findAll();
        for (Odontologo odontologo : listaOdontologos) {
            OdontologoDTO odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);
            listaOdontologoDTO.add(odontologoDTO);
        }
        logger.info("Lista de odontologos existentes: " + listaOdontologoDTO);
        return listaOdontologoDTO;
    }

    @Override
    public OdontologoDTO actualizar(OdontologoDTO odontologoDto, Long id) {
        Odontologo o = mapper.convertValue(this.buscar(id),Odontologo.class);
        if(o != null){
            o.setNombre(odontologoDto.getNombre());
            o.setApellido(odontologoDto.getApellido());
            o.setMatricula(odontologoDto.getMatricula());
            return mapper.convertValue(odontologoRepository.save(o), OdontologoDTO.class);
        }else{
        return null;
    }

  }

}