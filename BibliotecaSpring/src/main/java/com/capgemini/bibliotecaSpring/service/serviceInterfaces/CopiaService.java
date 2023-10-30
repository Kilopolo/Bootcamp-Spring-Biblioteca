package com.capgemini.bibliotecaSpring.service.serviceInterfaces;

import java.util.List;

import com.capgemini.bibliotecaSpring.model.Copia;
import com.capgemini.bibliotecaSpring.model.Libro;
import com.capgemini.bibliotecaSpring.service.ServiceS;

public interface CopiaService extends ServiceS<Copia> {
	List<Copia> findByLibro(Libro libro);
}
