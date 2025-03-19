CREATE DATABASE IF NOT EXISTS Autos;
USE Autos;

CREATE TABLE clientes (
    id_cliente INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    cedula INT NOT NULL,
    marca VARCHAR(50) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    placa VARCHAR(50) NOT NULL
);

CREATE TABLE auto (
    id_auto INT PRIMARY KEY AUTO_INCREMENT,
    marca VARCHAR(100) NOT NULL,
    modelo DATE,
    color VARCHAR(50) NOT NULL
);

CREATE TABLE vendedor (
    id_vendedor INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    codigo INT,
    ventas INT NOT NULL
);

CREATE TABLE info (
    id_info INT PRIMARY KEY AUTO_INCREMENT,
    estado VARCHAR(100) NOT NULL,
    valor INT NOT NULL,
    origen VARCHAR(50) NOT NULL,
    id_auto INT NOT NULL,
    FOREIGN KEY (id_auto) REFERENCES auto (id_auto) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE otros_vehiculos (
    id_otros_vehiculos INT PRIMARY KEY AUTO_INCREMENT,
    tipo_vehiculo VARCHAR(100) NOT NULL,
    valor INT NOT NULL,
    origen VARCHAR(50) NOT NULL,
    id_auto INT NOT NULL,
    FOREIGN KEY (id_auto) REFERENCES auto (id_auto) ON DELETE CASCADE ON UPDATE CASCADE
);