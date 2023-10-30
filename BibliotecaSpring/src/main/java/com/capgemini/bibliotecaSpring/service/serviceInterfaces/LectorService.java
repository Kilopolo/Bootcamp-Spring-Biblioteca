package com.capgemini.bibliotecaSpring.service.serviceInterfaces;

import java.time.LocalDate;

import com.capgemini.bibliotecaSpring.model.Copia;
import com.capgemini.bibliotecaSpring.model.Lector;
import com.capgemini.bibliotecaSpring.service.ServiceS;

public interface LectorService extends ServiceS<Lector> {

	/**
	 * {precondicion: prestamos.notEmpty()}
	 * 
	 * @param id
	 * @param date
	 */
	public void devolver(long id, LocalDate fechaAct);

	/**
	 * {precondicion: multa == 0}
	 * 
	 * @param id
	 * @param fechaAct
	 */
	public void prestar(long id, LocalDate fechaAct,Copia copia);
	
	void multar(long idLector, int diasRetraso);
	
}
