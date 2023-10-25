package com.capgemini.bibliotecaSpring.service;

import java.time.LocalDate;

import com.capgemini.bibliotecaSpring.model.Lector;

public interface LectorService extends ServiceS<Lector> {

	void devolver(long id, LocalDate date);
	
}
