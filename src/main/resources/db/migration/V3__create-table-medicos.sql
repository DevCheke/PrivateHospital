CREATE TABLE medicos (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellidopaterno VARCHAR(100) NOT NULL,
    apellidomaterno VARCHAR(100) NOT NULL,
    cedula VARCHAR(20) UNIQUE NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    direccion VARCHAR(20) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    especialidad_id INT REFERENCES especialidades(id) ON DELETE SET NULL
);