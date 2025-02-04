package com.mx.ClinicaPrivada.Cita.controlador;

import com.mx.ClinicaPrivada.Cita.citaDTO.CitaDTO;
import com.mx.ClinicaPrivada.Cita.entidad.CitaPacientes;
import com.mx.ClinicaPrivada.Cita.entidad.CitaPacientesRepository;
import com.mx.ClinicaPrivada.Cita.entidad.CitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class CitasPacientesWS {
    @Autowired
    private CitaPacientesRepository citaPacientesRepository;

    @Autowired
    private CitasService citasService;


    //localhost:8081/api/listarcitas
    @GetMapping("/listarcitas")
    public List<CitaDTO> listarcitas(){
         return citasService.obtenerCitas();
    }

    //localhost:8081/api/guardarcita
    @PostMapping("/guardarcita")
    public CitaPacientes guardarcita(@RequestBody CitaPacientes citaPacientes){
        return citasService.insertarCita(citaPacientes);
    }

    //localhost:8081/api/LISTA2
    @GetMapping("/LISTA2")
    public List<CitaPacientes> LISTA2(){
        return citaPacientesRepository.findAll();
    }
}

