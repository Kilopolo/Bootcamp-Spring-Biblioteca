package com.capgemini.bibliotecaSpring.service;

import java.util.List;

import com.capgemini.bibliotecaSpring.model.Lector;
import com.capgemini.bibliotecaSpring.model.Prestamo;

public interface PrestamoService extends ServiceS<Prestamo>  {
	List<Prestamo> findByLector(Lector lector);
}
