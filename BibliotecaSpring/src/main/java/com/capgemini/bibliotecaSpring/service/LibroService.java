package com.capgemini.bibliotecaSpring.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.capgemini.bibliotecaSpring.model.Libro;

public interface LibroService extends ServiceS<Libro> {
	public Page<Libro> searchOffersByTitle(Pageable p, String searchText);
	}
