package com.mx.ClinicaPrivada.Especialidades.repositorio;

import com.mx.ClinicaPrivada.Especialidades.entidad.Especialidades;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface EspecialidadesRepositorio extends JpaRepository<Especialidades, Integer> {
    @Query(value ="SELECT * FROM ESPECIALIDADES" ,nativeQuery = true)List<Especialidades> listar();

    @Transactional
    void deleteByNombre(String nombre); // Borra por nombre
}
