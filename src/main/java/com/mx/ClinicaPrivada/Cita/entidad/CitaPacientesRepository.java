package com.mx.ClinicaPrivada.Cita.entidad;

import com.mx.ClinicaPrivada.Medico.entidad.Medicos;
import com.mx.ClinicaPrivada.Pacientes.entidad.Pacientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CitaPacientesRepository extends JpaRepository<CitaPacientes, Integer> {
    @Query(value = """
                	SELECT c.id, paciente_id, m.cedula AS medico_cedula, nombre AS nombre_medico, apellidopaterno as medico_apellidop, apellidomaterno as medico_apellidom,\s
                	fecha_cita, motivo FROM citas c LEFT JOIN medicos m  ON c.medico_id = m.id
    """, nativeQuery = true)
    List<Object[]> getCitasConMedico();
}
