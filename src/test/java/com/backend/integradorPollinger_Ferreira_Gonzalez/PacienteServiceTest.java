package com.backend.integradorPollinger_Ferreira_Gonzalez;

import com.backend.integradorPollinger_Ferreira_Gonzalez.dto.PacienteDto;
import com.backend.integradorPollinger_Ferreira_Gonzalez.entity.Domicilio;
import com.backend.integradorPollinger_Ferreira_Gonzalez.entity.Paciente;
import com.backend.integradorPollinger_Ferreira_Gonzalez.exceptions.ResourceNotFoundException;
import com.backend.integradorPollinger_Ferreira_Gonzalez.service.impl.PacienteService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PacienteServiceTest {
    @Autowired
    PacienteService pacienteService;

    @Test
    @Order(1)
    void deberiaRegistrarUnPaciente() {
        Paciente paciente = new Paciente("Ana", "Ferreira", "123456789", LocalDate.now(), new Domicilio("Rondeau", 1234, "Montevideo", "Montevideo"));
        PacienteDto pacienteResult = pacienteService.guardarPaciente(paciente);

        assertEquals(1, paciente.getId());
    }

    @Test
    @Order(2)
    void deberiaListarSolamenteUnPaciente() {
        List<PacienteDto> pacienteDtoList = pacienteService.listarPacientes();
        assertEquals(1, pacienteDtoList.size());
    }

    @Test
    @Order(3)
    void deberiaEliminarElPacienteConId1() throws ResourceNotFoundException {
        pacienteService.eliminarPaciente(1L);
        assertThrows(ResourceNotFoundException.class, () -> pacienteService.eliminarPaciente(1L));
    }
}