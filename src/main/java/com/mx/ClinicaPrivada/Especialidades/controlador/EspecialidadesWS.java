package com.mx.ClinicaPrivada.Especialidades.controlador;


import com.mx.ClinicaPrivada.Especialidades.entidad.Especialidades;
import com.mx.ClinicaPrivada.Especialidades.repositorio.EspecialidadesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class EspecialidadesWS {
    @Autowired
    private EspecialidadesRepositorio especialidadesRepositorio;

    //localhost:8081/api/listarespecialidades
    @GetMapping("/listarespecialidades")
    public List<Especialidades> listarespecialidades() {
        return especialidadesRepositorio.listar();
    }

    //localhost:8081/api/guardarespecialidad
    @PostMapping("/guardarespecialidad")
    public ResponseEntity<?> guardarespecialidad(@RequestBody Especialidades especialidades) {
        String mensaje = "ESPECIALIDAD GUARDADA!!!!";
        especialidadesRepositorio.save(especialidades);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensaje);
    }

    //localhost:8081/api/eliminar
    @DeleteMapping("/eliminar")
    public ResponseEntity<?> eliminarEspecialidad(@RequestBody Especialidades especialidades) {
        String mensaje = "ESPECIALIDAD ELIMINADA!!!!";
        especialidadesRepositorio.delete(especialidades);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensaje);
    }
}
