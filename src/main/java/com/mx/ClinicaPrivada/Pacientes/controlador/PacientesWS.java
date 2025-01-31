package com.mx.ClinicaPrivada.Pacientes.controlador;

import com.mx.ClinicaPrivada.Pacientes.entidad.PacienteRepository;
import com.mx.ClinicaPrivada.Pacientes.entidad.PacienteService;
import com.mx.ClinicaPrivada.Pacientes.entidad.Pacientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> listarPacientes(){
        return ResponseEntity.accepted().body(pacienteRepository.listarPacientes());
    }

    //localhost:8081/api/guardarPacientes
    @PostMapping("/guardarPacientes")
    public ResponseEntity<?> guardarPacientes(@RequestBody Pacientes pacientes){
        pacienteService.crearPaciente(pacientes);
        return ResponseEntity.accepted().body("GUARDADO!");
    }
}
