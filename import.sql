USE test;

CREATE TABLE alumno (
id int,
nombre varchar(25),
apellido  varchar(25),
ciudad varchar(15),
PRIMARY KEY (id)
);

CREATE TABLE curso (
id int,
nombre varchar(25),
PRIMARY KEY (id)
);

CREATE TABLE alumnocurso (
id int,
alumno_id int,
curso_id int(25),
  FOREIGN KEY (alumno_id) REFERENCES alumno(id) ON DELETE CASCADE,
   FOREIGN KEY (curso_id) REFERENCES curso(id) ON DELETE CASCADE
);

INSERT INTO alumno(id, nombre, apellido, ciudad) VALUES
(1, 'Hugo', 'Onetto', 'Barcelona'),
(2, 'Paula', 'Barba', 'Valencia'),
(3, 'Rodolfo', 'Suarez', 'Cuenca');

INSERT INTO curso(id, nombre) VALUES
(1, 'Matemáticas'),
(2, 'Inglés');

INSERT INTO alumnocurso(alumno_id, curso_id) VALUES
(1, 1),
(1, 2),
(1, 2);

