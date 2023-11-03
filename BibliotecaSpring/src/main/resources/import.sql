-- Autores
INSERT INTO `projecto_capgemini_biblioteca`.`autores` (`fec_nac`, `nacionalidad`, `nombre`) VALUES ('1847-11-08', 'Irlanda', 'Bram Stoker');
INSERT INTO `projecto_capgemini_biblioteca`.`autores` (`fec_nac`, `nacionalidad`, `nombre`) VALUES ('1564-04-26', 'Inglaterra', 'William Shakespeare');
INSERT INTO `projecto_capgemini_biblioteca`.`autores` (`fec_nac`, `nacionalidad`, `nombre`) VALUES ('1922-11-16', 'Portugal', 'José Saramago');
INSERT INTO `projecto_capgemini_biblioteca`.`autores` (`fec_nac`, `nacionalidad`, `nombre`) VALUES ('1904-07-12', 'Chile', 'Pablo Neruda');
INSERT INTO `projecto_capgemini_biblioteca`.`autores` (`fec_nac`, `nacionalidad`, `nombre`) VALUES ('1927-03-06', 'Colombia', 'Gabriel García Márquez');
INSERT INTO `projecto_capgemini_biblioteca`.`autores` (`fec_nac`, `nacionalidad`, `nombre`) VALUES ('1898-06-5', 'España', 'Federico García Lorca');
INSERT INTO `projecto_capgemini_biblioteca`.`autores` (`fec_nac`, `nacionalidad`, `nombre`) VALUES ('1821-12-12', 'Francia', 'Gustave Flaubert');
INSERT INTO `projecto_capgemini_biblioteca`.`autores` (`fec_nac`, `nacionalidad`, `nombre`) VALUES ('1821-11-11', 'Rusia', 'Fiodor Dostoievski');
INSERT INTO `projecto_capgemini_biblioteca`.`autores` (`fec_nac`, `nacionalidad`, `nombre`) VALUES ('1927-03-06', 'Colombia', 'Gabriel García Márquez');

-- Lectores
INSERT INTO `projecto_capgemini_biblioteca`.`lectores` (`n_socio`, `direccion`, `nombre`, `telefono`) VALUES ('1', 'Asturias', 'David', '666666666');
INSERT INTO `projecto_capgemini_biblioteca`.`lectores` (`n_socio`, `direccion`, `nombre`, `telefono`) VALUES ('2', 'Madrid', 'Laura', '611111111');
INSERT INTO `projecto_capgemini_biblioteca`.`lectores` (`n_socio`, `direccion`, `nombre`, `telefono`) VALUES ('3', 'Barcelona', 'Carlos', '622222222');
INSERT INTO `projecto_capgemini_biblioteca`.`lectores` (`n_socio`, `direccion`, `nombre`, `telefono`) VALUES ('4', 'Valencia', 'Elena', '633333333');
INSERT INTO `projecto_capgemini_biblioteca`.`lectores` (`n_socio`, `direccion`, `nombre`, `telefono`) VALUES ('5', 'Sevilla', 'Alejandra', '644444444');
INSERT INTO `projecto_capgemini_biblioteca`.`lectores` (`n_socio`, `direccion`, `nombre`, `telefono`) VALUES ('6', 'Bilbao', 'Mario', '655555555');
INSERT INTO `projecto_capgemini_biblioteca`.`lectores` (`n_socio`, `direccion`, `nombre`, `telefono`) VALUES ('7', 'Toledo', 'Sofía', '677777777');
INSERT INTO `projecto_capgemini_biblioteca`.`lectores` (`n_socio`, `direccion`, `nombre`, `telefono`) VALUES ('8', 'Granada', 'Luis', '688888888');
INSERT INTO `projecto_capgemini_biblioteca`.`lectores` (`n_socio`, `direccion`, `nombre`, `telefono`) VALUES ('9', 'Zaragoza', 'Ana', '699999999');

-- Libros
INSERT INTO `projecto_capgemini_biblioteca`.`libros` (`anyo`, `idautor`, `idlibro`, `editorial`, `tipo`, `titulo`) VALUES ('1989', '1', '1', 'Santillana', 'NOVELA', 'Dracula');
INSERT INTO `projecto_capgemini_biblioteca`.`libros` (`anyo`, `idautor`, `idlibro`, `editorial`, `tipo`, `titulo`) VALUES ('1995', '2', '2', 'Anaya', 'TEATRO', 'Romeo y Julieta');
INSERT INTO `projecto_capgemini_biblioteca`.`libros` (`anyo`, `idautor`, `idlibro`, `editorial`, `tipo`, `titulo`) VALUES ('2000', '3', '3', 'Alfaguara', 'ENSAYO', 'Ensayos sobre la ceguera');
INSERT INTO `projecto_capgemini_biblioteca`.`libros` (`anyo`, `idautor`, `idlibro`, `editorial`, `tipo`, `titulo`) VALUES ('2010', '4', '4', 'Planeta', 'POESIA', 'Cien sonetos de amor');
INSERT INTO `projecto_capgemini_biblioteca`.`libros` (`anyo`, `idautor`, `idlibro`, `editorial`, `tipo`, `titulo`) VALUES ('1982', '5', '5', 'Espasa', 'NOVELA', 'Cien años de soledad');
INSERT INTO `projecto_capgemini_biblioteca`.`libros` (`anyo`, `idautor`, `idlibro`, `editorial`, `tipo`, `titulo`) VALUES ('1998', '6', '6', 'Plaza & Janés', 'TEATRO', 'La casa de Bernarda Alba');
INSERT INTO `projecto_capgemini_biblioteca`.`libros` (`anyo`, `idautor`, `idlibro`, `editorial`, `tipo`, `titulo`) VALUES ('2005', '7', '7', 'Anagrama', 'ENSAYO', 'Historia de la locura en la época clásica');
INSERT INTO `projecto_capgemini_biblioteca`.`libros` (`anyo`, `idautor`, `idlibro`, `editorial`, `tipo`, `titulo`) VALUES ('1999', '8', '8', 'Galaxia Gutenberg', 'POESIA', 'Las flores del mal');
INSERT INTO `projecto_capgemini_biblioteca`.`libros` (`anyo`, `idautor`, `idlibro`, `editorial`, `tipo`, `titulo`) VALUES ('2015', '9', '9', 'Debolsillo', 'NOVELA', 'El amor en los tiempos del cólera');


--Copias
INSERT INTO `projecto_capgemini_biblioteca`.`copias` (`idlibro`, `estado`) VALUES ('1', 'PRESTADO'); 
INSERT INTO `projecto_capgemini_biblioteca`.`copias` (`idlibro`, `estado`) VALUES ('2', 'BIBLIOTECA');
INSERT INTO `projecto_capgemini_biblioteca`.`copias` (`idlibro`, `estado`) VALUES ('3', 'BIBLIOTECA');
INSERT INTO `projecto_capgemini_biblioteca`.`copias` (`idlibro`, `estado`) VALUES ('4', 'REPARACION');
INSERT INTO `projecto_capgemini_biblioteca`.`copias` (`idlibro`, `estado`) VALUES ('5', 'PRESTADO');
INSERT INTO `projecto_capgemini_biblioteca`.`copias` (`idlibro`, `estado`) VALUES ('6', 'PRESTADO');
INSERT INTO `projecto_capgemini_biblioteca`.`copias` (`idlibro`, `estado`) VALUES ('7', 'BIBLIOTECA');
INSERT INTO `projecto_capgemini_biblioteca`.`copias` (`idlibro`, `estado`) VALUES ('8', 'RETRASO');
INSERT INTO `projecto_capgemini_biblioteca`.`copias` (`idlibro`, `estado`) VALUES ('9', 'REPARACION');
INSERT INTO `projecto_capgemini_biblioteca`.`copias` (`idlibro`, `estado`) VALUES ('1', 'BIBLIOTECA'); 
INSERT INTO `projecto_capgemini_biblioteca`.`copias` (`idlibro`, `estado`) VALUES ('1', 'BIBLIOTECA'); 
INSERT INTO `projecto_capgemini_biblioteca`.`copias` (`idlibro`, `estado`) VALUES ('1', 'BIBLIOTECA'); 
INSERT INTO `projecto_capgemini_biblioteca`.`copias` (`idlibro`, `estado`) VALUES ('1', 'BIBLIOTECA'); 


-- Prestamos
INSERT INTO `projecto_capgemini_biblioteca`.`prestamos` (`fecha_fin`, `fecha_inicio`, `idcopia`, `n_socio`) VALUES ( '2023-10-10','2023-09-10', '1', '1');
INSERT INTO `projecto_capgemini_biblioteca`.`prestamos` (`fecha_fin`, `fecha_inicio`, `idcopia`, `n_socio`) VALUES ('2023-10-15', '2023-09-05', '2', '2');
INSERT INTO `projecto_capgemini_biblioteca`.`prestamos` (`fecha_fin`, `fecha_inicio`, `idcopia`, `n_socio`) VALUES ('2023-12-28', '2023-12-18', '3', '3');
INSERT INTO `projecto_capgemini_biblioteca`.`prestamos` (`fecha_fin`, `fecha_inicio`, `idcopia`, `n_socio`) VALUES ('2023-11-29', '2023-11-19', '4', '4');
INSERT INTO `projecto_capgemini_biblioteca`.`prestamos` ( `fecha_inicio`, `idcopia`, `n_socio`) VALUES ( '2023-02-16', '5', '5');
INSERT INTO `projecto_capgemini_biblioteca`.`prestamos` ( `fecha_inicio`, `idcopia`, `n_socio`) VALUES ( '2023-05-17', '6', '6');
INSERT INTO `projecto_capgemini_biblioteca`.`prestamos` (`fecha_fin`, `fecha_inicio`, `idcopia`, `n_socio`) VALUES ('2023-03-24', '2023-03-14', '7', '7');
INSERT INTO `projecto_capgemini_biblioteca`.`prestamos` ( `fecha_inicio`, `idcopia`, `n_socio`) VALUES ( '2023-06-03', '8', '8');
INSERT INTO `projecto_capgemini_biblioteca`.`prestamos` (`fecha_fin`, `fecha_inicio`, `idcopia`, `n_socio`) VALUES ('2023-09-22', '2023-09-12', '9', '9');

-- Users

--INSERT INTO `projecto_capgemini_biblioteca`.`users` (`id`, `n_socio`, `email`, `password`,`role`) VALUES ('1','1', 'admin@gmail.com', '1234', 'ROLE_ADMIN');
--INSERT INTO `projecto_capgemini_biblioteca`.`users` (`id`, `n_socio`, `email`, `password`,`role`) VALUES ('2','2', 'user@gmail.com', '1234', 'ROLE_USER');

