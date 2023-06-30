package com.backend.integradorPollinger_Ferreira_Gonzalez;


import com.backend.integradorPollinger_Ferreira_Gonzalez.dto.OdontologoDto;
import com.backend.integradorPollinger_Ferreira_Gonzalez.entity.Odontologo;
import com.backend.integradorPollinger_Ferreira_Gonzalez.exceptions.ResourceNotFoundException;
import com.backend.integradorPollinger_Ferreira_Gonzalez.service.impl.OdontologoService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OdontologoServiceTest {
    @Autowired
    OdontologoService odontologoService;

    @Test
    @Order(1)
    void deberiaRegistrarUnOdontologo() {
        Odontologo odontologo = new Odontologo("AD-123456789", "Richard", "Gonzalez");
        OdontologoDto odontologoResult = odontologoService.registrarOdontologo(odontologo);
        assertEquals("AD-123456789", odontologoResult.getMatricula());
    }

    @Test
    @Order(2)
    void deberiaListarSolamenteUnOdontologo() {
        List<OdontologoDto> odontologoDtoList = odontologoService.listarOdontologos();
        assertEquals(1, odontologoDtoList.size());
    }

    @Test
    @Order(3)
    void deberiaEliminarElOdontologoConId1() throws ResourceNotFoundException {
        odontologoService.eliminarOdontologo(1L);
        assertThrows(ResourceNotFoundException.class, () -> odontologoService.eliminarOdontologo(1L));
    }
}
