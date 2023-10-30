package com.capgemini.bibliotecaSpring.service;

import java.time.LocalDate;

import com.capgemini.bibliotecaSpring.model.Lector;

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
	public void prestar(long id, LocalDate fechaAct);

	void multar(int dias);

}
