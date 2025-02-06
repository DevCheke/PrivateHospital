package com.mx.ClinicaPrivada.Cita.entidad;


import com.mx.ClinicaPrivada.Cita.citaDTO.CitaDTO;
import com.mx.ClinicaPrivada.Medico.entidad.Medicos;
import com.mx.ClinicaPrivada.Pacientes.entidad.Pacientes;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CitasService {

    private CitaPacientesRepository citaRepository;

    public CitasService(CitaPacientesRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    public List<CitaDTO> obtenerCitas() {
        List<Object[]> resultado = citaRepository.getCitasConMedico();

        return resultado.stream().map(obj ->
                new CitaDTO(
                        ((Number) obj[0]).intValue(),
                        (String) obj[1],
                        (String) obj[2],
                        (String) obj[3],
                        (String) obj[4],
                        (String) obj[5],
                        (obj[6] != null) ? ((java.sql.Timestamp) obj[6]).toLocalDateTime() : null,
                        (String) obj[7]
                )
        ).collect(Collectors.toList());
    }

    //Metodo para insertar la cita
    public CitaPacientes insertarCita(CitaPacientes cita) {
        // Convertir la fecha de String a LocalDateTime si es necesario
        String input = "31-12-2025 20:44";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(input, formatter);
        return citaRepository.save(cita);
    }
}
