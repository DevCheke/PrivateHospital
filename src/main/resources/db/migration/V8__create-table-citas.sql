CREATE TABLE citas (
    id BIGSERIAL PRIMARY KEY,
    paciente_id VARCHAR(15) REFERENCES pacientes(id_paciente) ON DELETE CASCADE,
    medico_id INT REFERENCES medicos(id) ON DELETE SET NULL,
    fecha_cita TIMESTAMP NOT NULL,
    motivo TEXT NOT NULL
);