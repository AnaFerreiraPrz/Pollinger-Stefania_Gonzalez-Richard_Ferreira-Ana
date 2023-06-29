package com.backend.integradorPollinger_Ferreira_Gonzalez.service;

import com.backend.integradorPollinger_Ferreira_Gonzalez.dto.OdontologoDto;
import com.backend.integradorPollinger_Ferreira_Gonzalez.entity.Odontologo;
import com.backend.integradorPollinger_Ferreira_Gonzalez.exceptions.ResourceNotFoundException;
import com.backend.integradorPollinger_Ferreira_Gonzalez.service.impl.OdontologoService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class IOdontologoServiceTest {

    @Autowired
    private OdontologoService odontologoService;

    @Test
    @Order(1)
    void deberiaIngresarOdontologo(){

        Odontologo odontologoAIngresar = new Odontologo("dg1544", "Juan","Rodriguez");
        OdontologoDto odontologoDto = odontologoService.registrarOdontologo(odontologoAIngresar);

        Assertions.assertNotNull(odontologoDto);
        Assertions.assertNotNull(odontologoDto.getId());

    }

    @Test
    @Order(2)
    void deberiaListarUnSoloOdontologo(){
        List<OdontologoDto> odontologoDtos = odontologoService.listarOdontologos();
        assertEquals(1, odontologoDtos.size());


    }


@Test
@Order(3)
void deberiaEliminarElprimerOdontologo() throws ResourceNotFoundException {
        odontologoService.eliminarOdontologo(1L);
        Assertions.assertThrows(ResourceNotFoundException.class, () -> odontologoService.eliminarOdontologo(1L));

}




}