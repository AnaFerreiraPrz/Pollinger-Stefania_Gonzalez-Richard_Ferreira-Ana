package com.backend.integradorPollinger_Ferreira_Gonzalez.service;

import com.backend.integradorPollinger_Ferreira_Gonzalez.dto.PacienteDto;
import com.backend.integradorPollinger_Ferreira_Gonzalez.entity.Paciente;
import com.backend.integradorPollinger_Ferreira_Gonzalez.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class PacienteServiceTest {

    @Autowired
    private IPacienteService iPacienteService;

    @Test
    @Order(1)
    void deberiaIngresarUnPaciente(){
        Paciente pacienteAIngresar = new Paciente("Juana", "Perez", 425862, "1986-02-16", "Rivera 1563");
        PacienteDto pacienteDto = iPacienteService.guardarPaciente(pacienteAIngresar);

        Assertions.assertNotNull(pacienteDto);
        Assertions.assertNotNull(pacienteDto.getId());

    }

    @Test
    @Order(2)
    void deberiaListarSoloUnPaciente(){
        List<PacienteDto> pacienteDtos = iPacienteService.listarPacientes();
        assertEquals(1, pacienteDtos.size());

    }


    @Test
    @Order(3)
    void deberiaEliminarElPacienteId1() throws ResourceNotFoundException {
        iPacienteService.eliminarPaciente(1L);

        Assertions.assertThrows(ResourceNotFoundException.class, () -> iPacienteService.eliminarPaciente(1L));

    }



}