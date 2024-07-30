CREATE TABLE Persona (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(10),
    nombre_pila VARCHAR(50),
    segundo_nombre VARCHAR(50),
    apellidos VARCHAR(100),
    direccion VARCHAR(255),
    fecha_nacimiento DATE
);

CREATE TABLE Hospital (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    direccion VARCHAR(255)
);

CREATE TABLE Departamento (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    hospital_id INT,
    FOREIGN KEY (hospital_id) REFERENCES Hospital(id)
);

CREATE TABLE Personal (
    id INT PRIMARY KEY,
    fecha_vinculacion DATE,
    salario DECIMAL(10, 2),
    departamento_id INT,
    tipo_personal ENUM('administrativo', 'tecnico', 'operaciones'),
    tipo_operacion ENUM('doctor', 'enfermera') DEFAULT NULL,
    tipo_tecnico ENUM('tecnico', 'tecnologia') DEFAULT NULL,
    FOREIGN KEY (id) REFERENCES Persona(id),
    FOREIGN KEY (departamento_id) REFERENCES Departamento(id)
);

CREATE TABLE Doctor (
    id INT PRIMARY KEY,
    es_lider BOOLEAN,
    FOREIGN KEY (id) REFERENCES Personal(id)
);

CREATE TABLE Equipo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    lider_id INT,
    FOREIGN KEY (lider_id) REFERENCES Doctor(id)
);

CREATE TABLE EquipoDoctor (
    equipo_id INT,
    doctor_id INT,
    PRIMARY KEY (equipo_id, doctor_id),
    FOREIGN KEY (equipo_id) REFERENCES Equipo(id),
    FOREIGN KEY (doctor_id) REFERENCES Doctor(id)
);

CREATE TABLE Pabellon (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    capacidad INT
);

CREATE TABLE Paciente (
    id INT PRIMARY KEY,
    fecha_ingreso DATE,
    pabellon_id INT,
    FOREIGN KEY (id) REFERENCES Persona(id),
    FOREIGN KEY (pabellon_id) REFERENCES Pabellon(id)
);
