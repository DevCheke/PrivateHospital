package com.mx.ClinicaPrivada.Pacientes.controlador;

import com.mx.ClinicaPrivada.Pacientes.entidad.PacienteRepository;
import com.mx.ClinicaPrivada.Pacientes.entidad.PacienteService;
import com.mx.ClinicaPrivada.Pacientes.entidad.Pacientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class PacientesWS {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PacienteService pacienteService;

    //localhost:8081/api/listaDePacientes
    @GetMapping("/listaDePacientes")
    public ResponseEntity<?> listarPacientes() {
        return ResponseEntity.accepted().body(pacienteRepository.listarPacientes());
    }

    //localhost:8081/api/guardarPacientes
    @PostMapping("/guardarPacientes")
    public ResponseEntity<?> guardarPacientes(@RequestBody Pacientes pacientes) {
        pacienteService.guardarPaciente(pacientes);
        return ResponseEntity.accepted().body("GUARDADO!");
    }

    //localhost:8081/api/buscarPacientePorNSeguro/{numSeguro}
    @GetMapping("/buscarPacientePorNSeguro/{numSeguro}")
    public ResponseEntity<?>buscarPacientePorNSeguro(@PathVariable String numSeguro){
        Optional<Pacientes> buscarPaciente = pacienteRepository.findByIdPaciente(numSeguro);
        if (buscarPaciente.isEmpty()) {
            return ResponseEntity.badRequest().body("PACIENTE NO ENCONTRADO!!!");
        }
        return ResponseEntity.accepted().body(buscarPaciente.get());
    }
}
