package com.mx.ClinicaPrivada.Cita.citaDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CitaDTO {
    private int id_cita;
    private String pacienteId;
    private String cedula;
    private String nombreMedico;
    private String medicoApellidop;
    private String medicoApellidom;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime fechaCita;
    private String motivo;


}
