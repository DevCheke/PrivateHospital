CREATE TABLE historialmedico (
    id BIGSERIAL PRIMARY KEY,
    paciente_id VARCHAR(15) REFERENCES pacientes(id_paciente) ON DELETE CASCADE,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    diagnostico TEXT NOT NULL,
    tratamiento TEXT NOT NULL
);