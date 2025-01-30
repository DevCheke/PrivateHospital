package com.mx.ClinicaPrivada.Especialidades.entidad;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("tipo_especialidad")
    private String nombre;

     /* Ignorar el campo id al serializar
     @JsonIgnore
     public int getId() {
         return id;
     }*/
    public Especialidades(DatosRegistroEspecialidades datosRegistroEspecialidades){
        this.nombre = datosRegistroEspecialidades.nombre();
    }
}
