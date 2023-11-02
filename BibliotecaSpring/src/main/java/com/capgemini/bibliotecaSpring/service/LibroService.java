package com.capgemini.bibliotecaSpring.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.capgemini.bibliotecaSpring.model.Libro;

import java.util.List;

import com.capgemini.bibliotecaSpring.model.Autor;

public interface LibroService extends ServiceS<Libro> {
	//	public Page<Libro> searchBookByTitle(Pageable p, String searchText);
	List<Libro> findByAutor(Autor autor);
	}
