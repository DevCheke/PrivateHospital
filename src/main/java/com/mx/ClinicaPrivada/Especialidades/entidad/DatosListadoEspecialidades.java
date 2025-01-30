package com.mx.ClinicaPrivada.Especialidades.entidad;

public record DatosListadoEspecialidades(
        String nombre
) {
    public DatosListadoEspecialidades(Especialidades especialidades) {
        this(especialidades.getNombre());
    }
}
