package com.clinicaOdontologica;

import com.clinicaOdontologica.DTO.OdontologoDTO;
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
public class OdontologoDTOTest {

    private static final Logger logger = Logger.getLogger(OdontologoDTOTest.class);

    @Test
    public void entidadDTO(){
    Odontologo o = new Odontologo();
    o.setNombre("Miguel");
    o.setApellido("Sanchez");
    o.setMatricula(1234);
    ObjectMapper mapper = new ObjectMapper();
    OdontologoDTO odontologoDTO = mapper.convertValue(o,OdontologoDTO.class);
    Assert.assertNotNull(odontologoDTO);
    logger.info("Clase DTO de odontologo se carga correctamente");
    }
}