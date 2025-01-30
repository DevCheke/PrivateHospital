package com.mx.ClinicaPrivada.Medico.controlador;

import com.mx.ClinicaPrivada.Especialidades.entidad.Especialidades;
import com.mx.ClinicaPrivada.Medico.Repositorio.MedicoRepository;
import com.mx.ClinicaPrivada.Medico.entidad.Medicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class MedicoWS {
    @Autowired
    private MedicoRepository medicoRepository;

    //localhost:8081/api/mostrarmedicos
    @GetMapping("mostrarmedicos")
    public List<Medicos> mostrarMedicos(){
        return medicoRepository.listaMedicos();
    }

    //localhost:8081/api/guardarMedico
    @PostMapping("guardarMedico")
    public ResponseEntity<?> guardarMedico(@RequestBody Medicos medicos){
        String mensaje = "GUARDADO!!!";
        medicoRepository.save(medicos);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensaje);
    }
}
