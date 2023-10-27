package com.capgemini.bibliotecaSpring.service;

import java.util.List;

import com.capgemini.bibliotecaSpring.model.Autor;
import com.capgemini.bibliotecaSpring.model.Libro;

public interface LibroService extends ServiceS<Libro> {
	List<Libro> findByAutor(Autor autor);
	}
