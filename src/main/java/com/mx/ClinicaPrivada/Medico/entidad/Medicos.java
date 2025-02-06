package com.mx.ClinicaPrivada.Medico.entidad;


import com.fasterxml.jackson.annotation.JsonProperty;
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
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidopaterno")
    private String apellidoPaterno;

    @Column(name = "apellidomaterno")
    private String apellidoMaterno;

    @Column(name = "cedula")
    private String cedula;

    @Column(name = "especialidad")
    private String especialidad;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "email")
    private String email;



    /*RELACION MUCHOS A UNO CON LA ENTIDAD ESPECIALIDAD
    @ManyToOne
    @JsonProperty("especialidad")//CAMBIAR FORMATO EN JSON
    //REFERENCIA A LA LLAVE FORANEA ESPECIALIDAD_NOMBRE DE MEDICOS A COLUMNA NOMBRE DE ESPECIALIDAD
    @JoinColumn(name = "especialidad_nombre", referencedColumnName = "nombre",  nullable = true)
    private Especialidades especialidades;*/


}

