package com.capgemini.bibliotecaSpring.service;

import java.util.List;

import com.capgemini.bibliotecaSpring.model.Copia;
import com.capgemini.bibliotecaSpring.model.Libro;

public interface CopiaService extends ServiceS<Copia> {
	List<Copia> findByLibro(Libro libro);
}
