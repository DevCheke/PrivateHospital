package com.mx.ClinicaPrivada.Medico.Repositorio;

import com.mx.ClinicaPrivada.Medico.entidad.Medicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MedicoRepository extends JpaRepository<Medicos, Integer> {
    @Query(value = "SELECT * FROM MEDICOS ORDER BY ID ASC",nativeQuery = true)
    List<Medicos> listarMedicos();

    // Encuentra todos los médicos por su nombre
    List<Medicos> findByNombre(String nombre);
}
