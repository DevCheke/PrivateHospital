package com.mx.ClinicaPrivada.Pacientes.entidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    public Pacientes guardarPaciente(Pacientes paciente) {
        // Obtener el último paciente guardado para calcular el nuevo ID
        String ultimoId = pacienteRepository.obtenerUltimoIdPaciente();
        int nuevoNumero = (ultimoId != null) ? Integer.parseInt(ultimoId.replace("NS-", "")) + 1 : 1;
        String nuevoId = "NS-" + nuevoNumero;
        paciente.setIdPaciente(nuevoId);  // Asignamos el nuevo ID
        return pacienteRepository.save(paciente);
    }
}
