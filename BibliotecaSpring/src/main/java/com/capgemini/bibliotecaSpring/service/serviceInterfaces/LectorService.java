package com.capgemini.bibliotecaSpring.service.serviceInterfaces;

import com.capgemini.bibliotecaSpring.model.Lector;
import com.capgemini.bibliotecaSpring.model.Prestamo;
import com.capgemini.bibliotecaSpring.service.ServiceS;

public interface LectorService extends ServiceS<Lector> {


	/**
	 * {precondicion: multa == 0}
	 * 
	 * @param id
	 * @param fechaAct
	 */	


	void multar(long idLector, Prestamo prestamo);
}
