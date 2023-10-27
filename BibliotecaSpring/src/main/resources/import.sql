-- Autores
INSERT INTO `projecto_capgemini_biblioteca`.`autores` (`fec_nac`, `nacionalidad`, `nombre`) VALUES ('1881-10-25', 'Asturias', 'Andres');
INSERT INTO `projecto_capgemini_biblioteca`.`autores` (`fec_nac`, `nacionalidad`, `nombre`) VALUES ('1880-09-30', 'Andalucía', 'Maria');
INSERT INTO `projecto_capgemini_biblioteca`.`autores` (`fec_nac`, `nacionalidad`, `nombre`) VALUES ('1875-07-02', 'Madrid', 'Pedro');
INSERT INTO `projecto_capgemini_biblioteca`.`autores` (`fec_nac`, `nacionalidad`, `nombre`) VALUES ('1899-12-11', 'Valencia', 'Luisa');
INSERT INTO `projecto_capgemini_biblioteca`.`autores` (`fec_nac`, `nacionalidad`, `nombre`) VALUES ('1905-03-17', 'Cataluña', 'Javier');
INSERT INTO `projecto_capgemini_biblioteca`.`autores` (`fec_nac`, `nacionalidad`, `nombre`) VALUES ('1860-05-08', 'Aragón', 'Elena');
INSERT INTO `projecto_capgemini_biblioteca`.`autores` (`fec_nac`, `nacionalidad`, `nombre`) VALUES ('1898-08-22', 'Galicia', 'Manuel');
INSERT INTO `projecto_capgemini_biblioteca`.`autores` (`fec_nac`, `nacionalidad`, `nombre`) VALUES ('1872-04-14', 'Castilla y León', 'Ana');
INSERT INTO `projecto_capgemini_biblioteca`.`autores` (`fec_nac`, `nacionalidad`, `nombre`) VALUES ('1910-01-27', 'Extremadura', 'Carlos');

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
INSERT INTO `projecto_capgemini_biblioteca`.`prestamos` ( `fecha_inicio`, `idcopia`, `n_socio`) VALUES ( '2023-09-10', '1', '1');
INSERT INTO `projecto_capgemini_biblioteca`.`prestamos` (`fecha_fin`, `fecha_inicio`, `idcopia`, `n_socio`) VALUES ('2023-10-15', '2023-09-05', '2', '2');
INSERT INTO `projecto_capgemini_biblioteca`.`prestamos` (`fecha_fin`, `fecha_inicio`, `idcopia`, `n_socio`) VALUES ('2023-12-28', '2023-12-18', '3', '3');
INSERT INTO `projecto_capgemini_biblioteca`.`prestamos` (`fecha_fin`, `fecha_inicio`, `idcopia`, `n_socio`) VALUES ('2023-11-29', '2023-11-19', '4', '4');
INSERT INTO `projecto_capgemini_biblioteca`.`prestamos` ( `fecha_inicio`, `idcopia`, `n_socio`) VALUES ( '2023-02-16', '5', '5');
INSERT INTO `projecto_capgemini_biblioteca`.`prestamos` ( `fecha_inicio`, `idcopia`, `n_socio`) VALUES ( '2023-05-17', '6', '6');
INSERT INTO `projecto_capgemini_biblioteca`.`prestamos` (`fecha_fin`, `fecha_inicio`, `idcopia`, `n_socio`) VALUES ('2023-03-24', '2023-03-14', '7', '7');
INSERT INTO `projecto_capgemini_biblioteca`.`prestamos` ( `fecha_inicio`, `idcopia`, `n_socio`) VALUES ( '2023-06-03', '8', '8');
INSERT INTO `projecto_capgemini_biblioteca`.`prestamos` (`fecha_fin`, `fecha_inicio`, `idcopia`, `n_socio`) VALUES ('2023-09-22', '2023-09-12', '9', '9');

