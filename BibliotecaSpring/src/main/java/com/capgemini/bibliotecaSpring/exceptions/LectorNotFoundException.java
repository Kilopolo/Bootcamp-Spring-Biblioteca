package com.capgemini.bibliotecaSpring.exceptions;

public class LectorNotFoundException extends RuntimeException {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public LectorNotFoundException(Long id) {
		super("Lector no encontrado con ID: " + id);
	}
}