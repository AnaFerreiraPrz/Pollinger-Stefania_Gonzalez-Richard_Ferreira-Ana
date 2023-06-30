package com.backend.integradorPollinger_Ferreira_Gonzalez;

import com.backend.integradorPollinger_Ferreira_Gonzalez.dto.OdontologoDto;
import com.backend.integradorPollinger_Ferreira_Gonzalez.dto.PacienteDto;
import com.backend.integradorPollinger_Ferreira_Gonzalez.dto.TurnoDto;
import com.backend.integradorPollinger_Ferreira_Gonzalez.entity.Domicilio;
import com.backend.integradorPollinger_Ferreira_Gonzalez.entity.Odontologo;
import com.backend.integradorPollinger_Ferreira_Gonzalez.entity.Paciente;
import com.backend.integradorPollinger_Ferreira_Gonzalez.entity.Turno;
import com.backend.integradorPollinger_Ferreira_Gonzalez.exceptions.BadRequestException;
import com.backend.integradorPollinger_Ferreira_Gonzalez.exceptions.ResourceNotFoundException;
import com.backend.integradorPollinger_Ferreira_Gonzalez.service.impl.OdontologoService;
import com.backend.integradorPollinger_Ferreira_Gonzalez.service.impl.PacienteService;
import com.backend.integradorPollinger_Ferreira_Gonzalez.service.impl.TurnoService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TurnoServiceTest {

    @Autowired
    private TurnoService turnoService;

    @Autowired
    private OdontologoService odontologoService;

    @Autowired
    private PacienteService pacienteService;

    private static Paciente paciente;

    private static Odontologo odontologo;

    @BeforeAll
    public  static  void init(){
        paciente = new Paciente("Lu", "Murga", "654323456", LocalDate.of(2023, 06, 30), new Domicilio("calle", 1, "Localidad", "Provincia"));
        odontologo = new Odontologo("AD-25542544", "Patricia", "Lopez");
    }

    @Test
    @Order(1)
    void deberiaRegistrarUnTurno() throws BadRequestException{
        PacienteDto pacienteDto = pacienteService.guardarPaciente(paciente);
        OdontologoDto odontologoDto = odontologoService.registrarOdontologo(odontologo);

        TurnoDto turnoDto = turnoService.guardarTurno(new Turno(paciente, odontologo, LocalDateTime.of(2023, 8, 25, 13, 30, 00)));

        Assertions.assertNotNull(turnoDto);
        Assertions.assertNotNull(turnoDto.getId());
        Assertions.assertNotNull(turnoDto.getPaciente(), pacienteDto.getNombre() + " " + pacienteDto.getApellido());
        Assertions.assertNotNull(turnoDto.getOdontologo(), odontologoDto.getNombre() + " " + odontologoDto.getApellido());

    }

    @Test
    @Order(2)
    void deberiaListarUnTunoPorId() throws ResourceNotFoundException {
        TurnoDto turnoSolo = turnoService.buscarTurnoPorId(1L);
        Assertions.assertNotNull(turnoSolo);
    }

    @Test
    @Order(3)
    void deberiaEliminarUnTurnoPorId() throws ResourceNotFoundException{
        turnoService.eliminarTurno(1L);
        assertThrows(ResourceNotFoundException.class, () -> {
            turnoService.buscarTurnoPorId(1L);
        });
    }
}
