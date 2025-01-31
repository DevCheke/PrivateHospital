package com.mx.ClinicaPrivada.Pacientes.entidad;

import com.mx.ClinicaPrivada.Medico.entidad.Medicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Pacientes, Integer> {
    @Query(value = "SELECT * FROM PACIENTES",nativeQuery = true)List<Pacientes> listarPacientes();
}
