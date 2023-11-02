package com.capgemini.bibliotecaSpring.service.serviceInterfaces;

import java.util.List;

import com.capgemini.bibliotecaSpring.model.Lector;
import com.capgemini.bibliotecaSpring.model.Multa;
import com.capgemini.bibliotecaSpring.service.ServiceS;

public interface MultaService extends ServiceS<Multa> {
	List<Multa> findByLector(Lector lector);
}
