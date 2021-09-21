package com.clinicaOdontologica.service;

import com.clinicaOdontologica.dto.OdontologoDto;
import com.clinicaOdontologica.model.Odontologo;
import com.clinicaOdontologica.repository.IOdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OdontologoService implements IGenericaService <OdontologoDto, Long> {

    @Autowired
    private IOdontologoRepository odontologoRepository;

    @Autowired
    private ObjectMapper mapper;

    @Override
    public OdontologoDto buscar(Long id) {
        Odontologo odontologo = odontologoRepository.findById(id).orElse(null);
        return mapper.convertValue(odontologo,OdontologoDto.class);
    }

    @Override
    public OdontologoDto guardar(OdontologoDto odontologoDto) {
       Odontologo odontologo = new Odontologo();
       odontologo.setNombre(odontologoDto.getNombre());
       odontologo.setApellido(odontologoDto.getApellido());
       odontologo.setMatricula(odontologoDto.getMatricula());
       return mapper.convertValue(odontologoRepository.save(odontologo),OdontologoDto.class);

    }

    @Override
    public Boolean eliminar(Long id) {
        odontologoRepository.deleteById(id);
        return (this.buscar(id)== null);
    }

    @Override
    public List<OdontologoDto> buscarTodos() {
        List<OdontologoDto> lo = mapper.convertValue(odontologoRepository.findAll(), List.class);
        return lo;
    }

    @Override
    public OdontologoDto actualizar(OdontologoDto odontologoDto,Long id) {
        Odontologo o = mapper.convertValue(this.buscar(id),Odontologo.class);
        if(o != null){
            o.setNombre(odontologoDto.getNombre());
            o.setApellido(odontologoDto.getApellido());
            o.setMatricula(odontologoDto.getMatricula());
            return mapper.convertValue(odontologoRepository.save(o),OdontologoDto.class);
        }else{
        return null;
    }

  }

}