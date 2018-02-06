CREATE DATABASE Taller CHARACTER SET utf8 COLLATE utf8_spanish2_ci;
use taller;
CREATE TABLE Mecanico
	(idMecanico INT auto_increment not null unique,
	nombreMecanico VARCHAR(45) not null,
	apellido1Mecanico VARCHAR(45) not null,
	apellido2Mecanico VARCHAR(45) not null,
	dniMecanico VARCHAR(9) not null,
	sueldoMecanico INT not null,
	PRIMARY KEY (idMecanico));
	
CREATE TABLE Vagon
	(idVagon INT auto_increment not null unique,
	fabricanteVagon VARCHAR(45) not null,
	modeloVagon VARCHAR(45) not null,
	antiguedadVagon INT not null,
	capacidadVagon INT not null,
	matriculaVagon INT not null,
	PRIMARY KEY (idVagon));
	
CREATE TABLE Mantenimiento
	(idMantenimiento INT auto_increment not null unique,
	nombreMantenimiento VARCHAR(45) not null,
	costeMantenimiento INT not null,
	horasMantenimiento INT not null,
	informeMantenimiento VARCHAR(500) not null,
	idMecanicoFK INT not null,
	idVagonFK INT not null,
	PRIMARY KEY (idMantenimiento),
	FOREIGN KEY (idMecanicoFK) REFERENCES Mecanico(idMecanico),
	FOREIGN KEY (idVagonFK) REFERENCES Vagon(idVagon));
	
	INSERT INTO Mecanico(nombreMecanico,apellido1Mecanico,apellido2Mecanico,dniMecanico,sueldoMecanico)
	VALUES ("Alejandro","Cabezas","Sáez","28630979G","1200");
	
	INSERT INTO Vagon(fabricanteVagon,modeloVagon,antiguedadVagon,capacidadVagon,matriculaVagon)
	VALUES ("Mercedes","A4G2",2,250,12345);
	
	INSERT INTO Mantenimiento(nombreMantenimiento,costeMantenimiento,horasMantenimiento,informeMantenimiento,idMecanicoFK,idVagonFK)
	VALUES ("Ruedas delanteras",500,4,"Revisión estado ruedas delanteras",1,1);