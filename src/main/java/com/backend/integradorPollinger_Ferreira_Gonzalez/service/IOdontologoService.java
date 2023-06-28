package com.backend.integradorPollinger_Ferreira_Gonzalez.service;


import com.backend.integradorPollinger_Ferreira_Gonzalez.dto.OdontologoDto;
import com.backend.integradorPollinger_Ferreira_Gonzalez.entity.Odontologo;
import com.backend.integradorPollinger_Ferreira_Gonzalez.exceptions.ResourceNotFoundException;

import java.util.List;

public interface IOdontologoService {
    OdontologoDto buscarOdontologoPorId(Long id);

    List<OdontologoDto> listarOdontologos();

    OdontologoDto registrarOdontologo(Odontologo odontologo);

    OdontologoDto actualizarOdontologo(Odontologo odontologo);

    void eliminarOdontologo(Long id) throws ResourceNotFoundException;
}

