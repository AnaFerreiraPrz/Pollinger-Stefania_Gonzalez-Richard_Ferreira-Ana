package com.backend.integradorPollinger_Ferreira_Gonzalez.controller;

import com.backend.integradorPollinger_Ferreira_Gonzalez.dto.TurnoDto;
import com.backend.integradorPollinger_Ferreira_Gonzalez.entity.Turno;
import com.backend.integradorPollinger_Ferreira_Gonzalez.exceptions.BadRequestException;
import com.backend.integradorPollinger_Ferreira_Gonzalez.exceptions.ResourceNotFoundException;
import com.backend.integradorPollinger_Ferreira_Gonzalez.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private final ITurnoService turnoService;

    @Autowired
    public TurnoController(ITurnoService turnoService) {
        this.turnoService = turnoService;
    }

    //GET
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarTurnoPorId(@PathVariable Long id) {
        return new ResponseEntity<>(turnoService.buscarTurnoPorId(id), null, HttpStatus.OK);
    }

    @GetMapping()
    public List<TurnoDto> listarTurnos() {
        return turnoService.listarTodos();
    }

    //POST
    @PostMapping("/registrar")
    public ResponseEntity<TurnoDto> registrarTurno(@RequestBody Turno turno) throws BadRequestException {
        return new ResponseEntity<>(turnoService.guardarTurno(turno), null, HttpStatus.CREATED);
    }

    //DELETE
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarTurno(@PathVariable Long id) throws ResourceNotFoundException {

        turnoService.eliminarTurno(id);
        return ResponseEntity.ok("Turno eliminado");

    }

    //PUT
    @PutMapping("/actualizar")
    public ResponseEntity<TurnoDto> actualizarPaciente(@RequestBody Turno turno) {
        return new ResponseEntity<>(turnoService.actualizarTurno(turno), null, HttpStatus.OK);
    }


}
