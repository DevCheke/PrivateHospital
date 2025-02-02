package com.mx.ClinicaPrivada.Pacientes.entidad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Pacientes, String> {
    @Query(value = "SELECT * FROM PACIENTES",nativeQuery = true)List<Pacientes> listarPacientes();

    Optional<Pacientes> findByIdPaciente(String idPaciente);

    @Query(value= "SELECT id_paciente FROM PACIENTES ORDER BY CAST(SUBSTRING(id_paciente, 4) AS INTEGER) DESC LIMIT 1",
            nativeQuery = true) String obtenerUltimoIdPaciente();
}
