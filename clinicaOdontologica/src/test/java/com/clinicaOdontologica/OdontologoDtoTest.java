package com.clinicaOdontologica;

import com.clinicaOdontologica.dto.OdontologoDto;
import com.clinicaOdontologica.model.Odontologo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(JUnit4.class)
@SpringBootTest
public class OdontologoDtoTest {

    //aún en proceso
    /*private static final Logger logger = Logger.getLogger(OdontologoDtoTest.class);
    @Test
    public void entidadDto(){
    Odontologo o = new Odontologo();
    o.setNombre("Miguel");
    o.setApellido("Sanchez");
    o.setMatricula(1234);
    ObjectMapper mapper = new ObjectMapper();
    OdontologoDto odontologoDTO = mapper.convertValue(o,OdontologoDto.class);
    Assert.assertNotNull(odontologoDTO);
    logger.info("Clase Dto de odontologo se carga correctamente");
    }*/
}
