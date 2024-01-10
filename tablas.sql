

CREATE TABLE `Curso`(
	idCurso INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    profesor VARCHAR(30) NOT NULL,
    modalidad VARCHAR(15) NOT NULL,
    ciclo INT NOT NULL,
    facultad VARCHAR(20) NOT NULL,
    creditos NUMERIC(2,1) NOT NULL,
    PRIMARY KEY(`idCurso`)
);

INSERT INTO Curso(nombre,profesor,modalidad,ciclo,facultad,creditos) VALUES ('Introducción a la Biología Molecular', 'Luis Garcia', 'Presencial', 5, 'Numeros', 4);
INSERT INTO Curso(nombre,profesor,modalidad,ciclo,facultad,creditos) VALUES ('Matemáticas Avanzadas', 'Javier Pérez', 'Virtual', 2, 'Letras', 5);
INSERT INTO Curso(nombre,profesor,modalidad,ciclo,facultad,creditos) VALUES ('Historia del Arte Antiguo', 'Sara Smith', 'Presencial', 9, 'Numeros', 3);
INSERT INTO Curso(nombre,profesor,modalidad,ciclo,facultad,creditos) VALUES ('Programación en Java', 'Peter Parker', 'Virtual', 7, 'Numeros', 4);
INSERT INTO Curso(nombre,profesor,modalidad,ciclo,facultad,creditos) VALUES ('Economía Internacional', 'Norma Medina', 'Presencial', 1, 'Letras', 5);
INSERT INTO Curso(nombre,profesor,modalidad,ciclo,facultad,creditos) VALUES ('Diseño Gráfico Creativo', 'Luis Garcia', 'Presencial', 8, 'Letras', 4);
INSERT INTO Curso(nombre,profesor,modalidad,ciclo,facultad,creditos) VALUES ('Psicología del Desarrollo', 'Javier Pérez', 'Virtual', 4, 'Letras', 4);
INSERT INTO Curso(nombre,profesor,modalidad,ciclo,facultad,creditos) VALUES ('Física Cuántica', 'Sara Smith', 'Presencial', 3, 'Numeros', 5);
INSERT INTO Curso(nombre,profesor,modalidad,ciclo,facultad,creditos) VALUES ('Inglés Avanzado', 'Peter Parker', 'Virtual', 6, 'Letras', 3);
INSERT INTO Curso(nombre,profesor,modalidad,ciclo,facultad,creditos) VALUES ('Química Orgánica', 'Norma Medina', 'Presencial', 10, 'Letras', 4);
INSERT INTO Curso(nombre,profesor,modalidad,ciclo,facultad,creditos) VALUES ('Gestión de Proyectos Empresariales', 'Luis Garcia', 'Virtual', 1, 'Numeros', 5);
INSERT INTO Curso(nombre,profesor,modalidad,ciclo,facultad,creditos) VALUES ('Literatura Contemporánea', 'Javier Pérez', 'Presencial', 8, 'Numeros', 3);
INSERT INTO Curso(nombre,profesor,modalidad,ciclo,facultad,creditos) VALUES ('Introducción a la Inteligencia Artificial', 'Sara Smith', 'Virtual', 5, 'Numeros', 4);
INSERT INTO Curso(nombre,profesor,modalidad,ciclo,facultad,creditos) VALUES ('Derecho Internacional', 'Peter Parker', 'Presencial', 3, 'Letras', 5);
INSERT INTO Curso(nombre,profesor,modalidad,ciclo,facultad,creditos) VALUES ('Marketing Digital', 'Norma Medina', 'Virtual', 2, 'Numeros', 4);
INSERT INTO Curso(nombre,profesor,modalidad,ciclo,facultad,creditos) VALUES ('Introducción a la Psicología Clínica', 'Luis Garcia', 'Presencial', 9, 'Numeros', 4);
INSERT INTO Curso(nombre,profesor,modalidad,ciclo,facultad,creditos) VALUES ('Marketing Estratégico', 'Javier Pérez', 'Virtual', 10, 'Letras', 5);
INSERT INTO Curso(nombre,profesor,modalidad,ciclo,facultad,creditos) VALUES ('Historia de la Filosofía Moderna', 'Sara Smith', 'Presencial', 4, 'Numeros', 3);
INSERT INTO Curso(nombre,profesor,modalidad,ciclo,facultad,creditos) VALUES ('Programación en Python', 'Peter Parker', 'Virtual', 7, 'Numeros', 4);
INSERT INTO Curso(nombre,profesor,modalidad,ciclo,facultad,creditos) VALUES ('Economía de Mercado', 'Norma Medina', 'Presencial', 2, 'Letras', 5);
INSERT INTO Curso(nombre,profesor,modalidad,ciclo,facultad,creditos) VALUES ('Diseño de Experiencia de Usuario', 'Luis Garcia', 'Presencial', 6, 'Numeros', 4);
INSERT INTO Curso(nombre,profesor,modalidad,ciclo,facultad,creditos) VALUES ('Neurociencia Cognitiva', 'Javier Pérez', 'Virtual', 1, 'Letras', 4);
INSERT INTO Curso(nombre,profesor,modalidad,ciclo,facultad,creditos) VALUES ('Física Moderna', 'Sara Smith', 'Presencial', 10, 'Numeros', 5);
INSERT INTO Curso(nombre,profesor,modalidad,ciclo,facultad,creditos) VALUES ('Inglés de Negocios', 'Peter Parker', 'Virtual', 8, 'Letras', 3);
INSERT INTO Curso(nombre,profesor,modalidad,ciclo,facultad,creditos) VALUES ('Bioquímica Avanzada', 'Norma Medina', 'Presencial', 4, 'Numeros', 4);
INSERT INTO Curso(nombre,profesor,modalidad,ciclo,facultad,creditos) VALUES ('Gestión de Recursos Humanos', 'Luis Garcia', 'Virtual', 6, 'Letras', 5);
INSERT INTO Curso(nombre,profesor,modalidad,ciclo,facultad,creditos) VALUES ('Literatura del Siglo XIX', 'Javier Pérez', 'Presencial', 7, 'Numeros', 3);
INSERT INTO Curso(nombre,profesor,modalidad,ciclo,facultad,creditos) VALUES ('Machine Learning Aplicado', 'Sara Smith', 'Virtual', 9, 'Numeros', 4);
INSERT INTO Curso(nombre,profesor,modalidad,ciclo,facultad,creditos) VALUES ('Derecho Constitucional Comparado', 'Peter Parker', 'Presencial', 1, 'Letras', 5);
INSERT INTO Curso(nombre,profesor,modalidad,ciclo,facultad,creditos) VALUES ('Marketing en Redes Sociales', 'Norma Medina', 'Virtual', 3, 'Numeros', 4);


CREATE TABLE `Servicio`(
	idServicio INT NOT NULL AUTO_INCREMENT,
    nombreServicio VARCHAR(50) NOT NULL,
    PRIMARY KEY(`idServicio`)
);

INSERT INTO servicio(nombreServicio) VALUES ("Cubiculo Biblioteca Central");
INSERT INTO servicio(nombreServicio) VALUES ("Cubiculo Centro de Innovacion");
INSERT INTO servicio(nombreServicio) VALUES ("Sala de Cine");
INSERT INTO servicio(nombreServicio) VALUES ("Consulta Medica");
INSERT INTO servicio(nombreServicio) VALUES ("Prestamo de Libros");
INSERT INTO servicio(nombreServicio) VALUES ("Cancha de Futbol");
INSERT INTO servicio(nombreServicio) VALUES ("Cancha de Basquet");
INSERT INTO servicio(nombreServicio) VALUES ("Auditorio de Ingenieria");
INSERT INTO servicio(nombreServicio) VALUES ("Auditorio de Comunicaciones");
INSERT INTO servicio(nombreServicio) VALUES ("Auditorio de Estudios Generales");


CREATE TABLE `reservaServicio`(
	idReserva INT NOT NULL AUTO_INCREMENT,
    idServicio INT NOT NULL,
    fechaServicio DATE NULL,
    totalAlumnos INT NOT NULL, #Cantidad de alumnos que usaron el servicio
    PRIMARY KEY(`idReserva`),
    FOREIGN KEY (idServicio) REFERENCES Servicio(idServicio) ON DELETE CASCADE
);

INSERT INTO reservaServicio(idServicio, fechaServicio, totalAlumnos) VALUES (6, "2022-05-09", 10);
INSERT INTO reservaServicio(idServicio, fechaServicio, totalAlumnos) VALUES (9, "2022-03-28", 20);
INSERT INTO reservaServicio(idServicio, fechaServicio, totalAlumnos) VALUES (2, "2022-08-17", 4);
INSERT INTO reservaServicio(idServicio, fechaServicio, totalAlumnos) VALUES (4, "2023-02-22", 1);
INSERT INTO reservaServicio(idServicio, fechaServicio, totalAlumnos) VALUES (8, "2023-01-14", 20);


CREATE TABLE `auditoria` (
	`idauditoria` INT NOT NULL AUTO_INCREMENT,
    `nombrusuarioeServicio` VARCHAR(50) NOT NULL,
    `diaServicio` DATE NOT NULL,
    `operacion` VARCHAR(25) NOT NULL,
	`fechahora` DATETIME NOT NULL,
	PRIMARY KEY (`idauditoria`)
);


-- usuario: cheredia, clave: 12345
CREATE TABLE `usuario`(
    usuario VARCHAR(20) NOT NULL,
    clave VARCHAR(100) NOT NULL,
	PRIMARY KEY (`usuario`)
);

DROP TABLE objetoperdido;

CREATE TABLE `objetoperdido`(
	idPerdido INT NOT NULL AUTO_INCREMENT,
    descripcion VARCHAR(50) NOT NULL,
	fechaPerdida DATE NOT NULL,
	fechaRecuperacion DATE NULL,
	PRIMARY KEY (`idPerdido`)
);

INSERT INTO objetoperdido(descripcion, fechaPerdida, fechaRecuperacion) VALUES ("Celular Xiomi Redmi Note 9S", "2023-06-09", "2023-08-12");
INSERT INTO objetoperdido(descripcion, fechaPerdida) VALUES ("Cargador blanco tipo C", "2023-05-09");
INSERT INTO objetoperdido(descripcion, fechaPerdida, fechaRecuperacion) VALUES ("Celular iPhone 12 con protector rojo", "2023-04-09", "2023-06-03");
INSERT INTO objetoperdido(descripcion, fechaPerdida, fechaRecuperacion) VALUES ("MacBoox Air protector transparente", "2023-03-22", "2023-06-09");
INSERT INTO objetoperdido(descripcion, fechaPerdida) VALUES ("Parlante cuadrado JBL azul", "2023-05-22");
INSERT INTO objetoperdido(descripcion, fechaPerdida) VALUES ("Audifonos SkullCandy Negros", "2023-09-12");
INSERT INTO objetoperdido(descripcion, fechaPerdida, fechaRecuperacion) VALUES ("Shaker gris", "2022-12-19", "2023-01-04");
INSERT INTO objetoperdido(descripcion, fechaPerdida) VALUES ("Cargador negro tipo C", "2022-12-13");
INSERT INTO objetoperdido(descripcion, fechaPerdida, fechaRecuperacion) VALUES ("Mouse Click Silencioso Negro", "2022-08-02", "2023-08-09");
INSERT INTO objetoperdido(descripcion, fechaPerdida) VALUES ("Mouse Pad Negro", "2022-05-09");
