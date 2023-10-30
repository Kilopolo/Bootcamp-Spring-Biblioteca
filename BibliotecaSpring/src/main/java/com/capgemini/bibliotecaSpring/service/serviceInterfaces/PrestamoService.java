package com.capgemini.bibliotecaSpring.service.serviceInterfaces;

import java.util.List;

import com.capgemini.bibliotecaSpring.model.Lector;
import com.capgemini.bibliotecaSpring.model.Prestamo;
import com.capgemini.bibliotecaSpring.service.ServiceS;

public interface PrestamoService extends ServiceS<Prestamo>  {
	List<Prestamo> findByLector(Lector lector);
}
