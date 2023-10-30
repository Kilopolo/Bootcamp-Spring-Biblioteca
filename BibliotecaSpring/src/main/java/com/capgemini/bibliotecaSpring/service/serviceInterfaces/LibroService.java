package com.capgemini.bibliotecaSpring.service.serviceInterfaces;

import java.util.List;

import com.capgemini.bibliotecaSpring.model.Autor;
import com.capgemini.bibliotecaSpring.model.Libro;
import com.capgemini.bibliotecaSpring.service.ServiceS;

public interface LibroService extends ServiceS<Libro> {
	//	public Page<Libro> searchBookByTitle(Pageable p, String searchText);
	List<Libro> findByAutor(Autor autor);
	}
