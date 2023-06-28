package com.backend.integradorPollinger_Ferreira_Gonzalez.service;

import com.backend.integradorPollinger_Ferreira_Gonzalez.dto.PacienteDto;
import com.backend.integradorPollinger_Ferreira_Gonzalez.entity.Paciente;
import com.backend.integradorPollinger_Ferreira_Gonzalez.exceptions.ResourceNotFoundException;

import java.util.List;

public interface IPacienteService {
    List<PacienteDto> listarPacientes();

    PacienteDto buscarPacientePorId(Long id);

    PacienteDto guardarPaciente(Paciente paciente);

    PacienteDto actualizarPaciente(Paciente paciente);

    void eliminarPaciente(Long id) throws ResourceNotFoundException;

}
