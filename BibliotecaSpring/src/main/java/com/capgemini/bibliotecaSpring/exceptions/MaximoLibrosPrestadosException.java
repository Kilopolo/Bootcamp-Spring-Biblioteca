package com.capgemini.bibliotecaSpring.exceptions;

public class MaximoLibrosPrestadosException extends RuntimeException {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public MaximoLibrosPrestadosException() {
		super("Lo sentimos, pero has alcanzado el máximo de libros prestados. Devuelve al menos un libro para poder prestar otro.");
	}
}
