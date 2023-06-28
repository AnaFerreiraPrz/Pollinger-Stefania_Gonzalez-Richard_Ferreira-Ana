package com.backend.integradorPollinger_Ferreira_Gonzalez.repository;


import com.backend.integradorPollinger_Ferreira_Gonzalez.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{
}
