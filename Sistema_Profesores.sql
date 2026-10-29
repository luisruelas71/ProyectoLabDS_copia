CREATE DATABASE Sistema_Profesores CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE Sistema_Profesores;


CREATE TABLE tipo_profesor (
    id_tipo INT AUTO_INCREMENT PRIMARY KEY,
    nombre_tipo VARCHAR(50) NOT NULL UNIQUE,
    limite_firmas INT NULL
);

INSERT INTO tipo_profesor (nombre_tipo, limite_firmas) VALUES
    ('Tiempo completo (1 firma)', 1),
    ('Tiempo completo (2 firmas)', 2),
    ('Asignatura', NULL);

CREATE TABLE profesor (
    id_profesor INT AUTO_INCREMENT PRIMARY KEY,
    id_tipo INT NOT NULL,
    correo_institucional VARCHAR(100) NOT NULL UNIQUE,
    contrasena VARCHAR(100) NOT NULL,
    FOREIGN KEY (id_tipo) REFERENCES tipo_profesor (id_tipo)
);

CREATE TABLE firma (
    id_firma INT AUTO_INCREMENT PRIMARY KEY,
    id_profesor INT NOT NULL,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    ubicacion VARCHAR(200) NOT NULL,
    fotografia LONGBLOB NOT NULL,
    FOREIGN KEY (id_profesor) REFERENCES profesor (id_profesor)
);

CREATE TABLE tarea (
    id_tarea INT AUTO_INCREMENT PRIMARY KEY,
    id_profesor INT NOT NULL,
    titulo VARCHAR(100) NOT NULL,
    descripcion VARCHAR(300) NOT NULL,
    fecha_limite DATETIME NOT NULL,
    prioridad VARCHAR(10) NOT NULL,
    completado BOOLEAN NOT NULL DEFAULT FALSE,
    CHECK (prioridad IN ('urgente', 'alta', 'media', 'baja')),
    FOREIGN KEY (id_profesor) REFERENCES profesor (id_profesor)
);