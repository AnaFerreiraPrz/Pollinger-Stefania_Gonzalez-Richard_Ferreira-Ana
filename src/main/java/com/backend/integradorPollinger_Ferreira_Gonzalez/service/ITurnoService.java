package com.backend.integradorPollinger_Ferreira_Gonzalez.service;

import com.backend.integradorPollinger_Ferreira_Gonzalez.dto.TurnoDto;
import com.backend.integradorPollinger_Ferreira_Gonzalez.entity.Turno;
import com.backend.integradorPollinger_Ferreira_Gonzalez.exceptions.BadRequestException;
import com.backend.integradorPollinger_Ferreira_Gonzalez.exceptions.ResourceNotFoundException;

import java.util.List;

public interface ITurnoService {
    TurnoDto guardarTurno(Turno turno) throws BadRequestException;

    List<TurnoDto> listarTodos();

    TurnoDto buscarTurnoPorId(Long id);

    TurnoDto actualizarTurno(Turno turno);

    void eliminarTurno(Long id) throws ResourceNotFoundException;


}
