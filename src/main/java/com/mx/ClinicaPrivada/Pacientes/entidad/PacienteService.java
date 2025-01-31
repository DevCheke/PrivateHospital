package com.mx.ClinicaPrivada.Pacientes.entidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    public Pacientes crearPaciente(Pacientes paciente) {
        // Asegurémonos de asignar el num_seguro desde el principio si el id no está disponible
        if (paciente.getNumSeguro() == null || paciente.getNumSeguro().isEmpty()) {
            paciente.setNumSeguro("NSS-0");
            // Asignamos un valor predeterminado temporal
        }
        // Guardamos el paciente para que se le asigne un ID
        Pacientes pacienteGuardado = pacienteRepository.save(paciente);
        // Ahora que tenemos el id, actualizamos el num_seguro con el formato NSS-id
        pacienteGuardado.setNumSeguro("NSS-" + pacienteGuardado.getIdPaciente());
        // Guardamos el paciente con el num_seguro
        return pacienteRepository.save(pacienteGuardado);
    }
}
