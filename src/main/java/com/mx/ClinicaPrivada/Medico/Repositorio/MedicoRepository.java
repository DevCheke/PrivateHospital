package com.mx.ClinicaPrivada.Medico.Repositorio;

import com.mx.ClinicaPrivada.Medico.entidad.Medicos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medicos, Integer> {
}
