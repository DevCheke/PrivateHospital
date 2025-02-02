package com.mx.ClinicaPrivada.Pacientes.entidad;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "pacientes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pacientes {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private String idPaciente;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidopaterno")
    private String apellidoPaterno;

    @Column(name = "apellidomaterno")
    private String apellidoMaterno;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "genero")
    @Enumerated(EnumType.STRING)
    private Genero genero;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "email")
    private String email;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro = LocalDateTime.now();

    //SE CREO ESTE METODO PARA ELIMINAR LOS MILISEGUNDOS EN LA FECHA DEL REGISTRO
    public void eliminarSegundos(){
        LocalDateTime truncar = fechaRegistro.truncatedTo(ChronoUnit.SECONDS);

    }
}
