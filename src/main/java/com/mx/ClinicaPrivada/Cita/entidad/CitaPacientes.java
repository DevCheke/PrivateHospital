package com.mx.ClinicaPrivada.Cita.entidad;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mx.ClinicaPrivada.Medico.entidad.Medicos;
import com.mx.ClinicaPrivada.Pacientes.entidad.Pacientes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "citas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CitaPacientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "paciente_id", referencedColumnName = "id_paciente")
    private Pacientes paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id", referencedColumnName = "id")
    private Medicos medico;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    @Column(name = "fecha_cita")
    private LocalDateTime fechaCita;

    @Column(name = "motivo")
    private String motivo;
}
