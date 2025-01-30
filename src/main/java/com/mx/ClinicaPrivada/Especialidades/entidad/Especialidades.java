package com.mx.ClinicaPrivada.Especialidades.entidad;

import jakarta.persistence.*;
import lombok.*;

 // Lombok genera getters, setters, toString, equals, y hashCode automáticamente
@Entity
@Table(name = "especialidades")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Especialidades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "nombre")
    private String nombre;

    public Especialidades(DatosRegistroEspecialidades datosRegistroEspecialidades){
        this.nombre = datosRegistroEspecialidades.nombre();
    }
}
