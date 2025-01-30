CREATE TABLE Pacientes (
    id_paciente BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellidopaterno VARCHAR(100) NOT NULL,
    apellidomaterno VARCHAR(100) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    genero VARCHAR(10) NOT NULL CHECK (genero IN ('Masculino', 'Femenino', 'Otro')),
    direccion VARCHAR(255),
    telefono VARCHAR(15) NOT NULL,
    email VARCHAR(100) NOT NULL,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);