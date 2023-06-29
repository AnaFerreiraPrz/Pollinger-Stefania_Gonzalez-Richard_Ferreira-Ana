package com.backend.integradorPollinger_Ferreira_Gonzalez.service;

import com.backend.integradorPollinger_Ferreira_Gonzalez.dto.TurnoDto;
import com.backend.integradorPollinger_Ferreira_Gonzalez.entity.Turno;
import com.backend.integradorPollinger_Ferreira_Gonzalez.exceptions.BadRequestException;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)


class ITurnoServiceTest {

    @Autowired
    private ITurnoService iTurnoService;


    @Test
    @Order(1)
    void deberiaIngresarUnTurno() throws BadRequestException {

        Turno turnoAIngresar = new Turno("Maria Perez","Juan Lopez","2023-08-25 15:25");
        TurnoDto turnoDto = iTurnoService.guardarTurno(turnoAIngresar);

        Assertions.assertNotNull(turnoDto);
        Assertions.assertNotNull(turnoDto.getId());
    }

    @Test
    @Order(2)
    void deberiaRetornarUnaListaVacia(){

        List<TurnoDto> turnoDtos = iTurnoService.listarTodos();
        Assertions.assertTrue(turnoDtos.isEmpty());

    }


}