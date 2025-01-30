package com.mx.ClinicaPrivada.Medico.entidad;


import com.mx.ClinicaPrivada.Especialidades.entidad.Especialidades;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "medicos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Medicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidopaterno")
    private String apellidoPaterno;

    @Column(name = "apellidomaterno")
    private String apellidoMaterno;

    @Column(name = "cedula")
    private String cedula;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "especialidad_id", referencedColumnName = "id", nullable = true)
    private Especialidades especialidades;


}

