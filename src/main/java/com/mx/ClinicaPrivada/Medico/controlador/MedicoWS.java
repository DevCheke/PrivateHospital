package com.mx.ClinicaPrivada.Medico.controlador;

import com.mx.ClinicaPrivada.Especialidades.entidad.Especialidades;
import com.mx.ClinicaPrivada.Medico.Repositorio.MedicoRepository;
import com.mx.ClinicaPrivada.Medico.entidad.Medicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class MedicoWS {
    @Autowired
    private MedicoRepository medicoRepository;

    //localhost:8081/api/mostrarmedicos
    @GetMapping("mostrarmedicos")
    public List<Medicos> mostrarMedicos() {
        return medicoRepository.listarMedicos();
    }

    //localhost:8081/api/guardarMedico
    @PostMapping("guardarMedico")
    public ResponseEntity<?> guardarMedico(@RequestBody Medicos medicos) {
        String mensaje = "GUARDADO!!!";
        medicoRepository.save(medicos);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensaje);
    }

    //localhost:8081/api/buscarmedico
    @PostMapping("buscarmedico")
    public ResponseEntity<?> buscarmedico(@RequestBody Medicos medicos) {
        //SE CREO UNA LISTA DE TIPO MEDICOS PARA BUSCAR PRIMERO SI EXISTE EL NOMBRE
        List<Medicos> listaMedicos = medicoRepository.findByNombre(medicos.getNombre());
        //SE UTILIZA .isEmpty para comprobar que la lista este vacia o no contenga un valor similar en listaMedicos
        if (listaMedicos.isEmpty()) {
            // Si no se encuentra médicos, devolvera un mensaje de ERROR!
            String mensaje = "EL MEDICO CON EL NOMBRE '" + medicos.getNombre() + "' NO SE ENCUENTRA! VERIFICAR!";
            return new ResponseEntity<>(mensaje, HttpStatus.BAD_REQUEST);
        }
        //SI LOS ENCUENTRA DEVUELVE EL REGISTRO O LOS MEDICOS ENCONTRADOS CON ESE NOMBRE
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(listaMedicos);
    }

    //localhost:8081/api/actualizarMedico
    @PutMapping("actualizarMedico")
    public ResponseEntity<?> actualizarMedico(@RequestBody Medicos medicos) {
        String mensaje = "ACTUALIZADO!!!";
        medicoRepository.save(medicos);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensaje);
    }

    //localhost:8081/api/eliminarMedico
    @DeleteMapping("/eliminarMedico")
    public ResponseEntity<?> eliminarMedico(@RequestBody Medicos medicos) {
        List<Medicos> encontrarMedico = medicoRepository.findById(medicos.getId());
        if (encontrarMedico.isEmpty()==null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID no proporcionado. Verifica los datos.");
        } else {
            // Eliminar el médico si existe
            medicoRepository.deleteById(medicos.getId());
            return ResponseEntity.status(HttpStatus.OK).body("Médico eliminado exitosamente.");
        }
    }
}
