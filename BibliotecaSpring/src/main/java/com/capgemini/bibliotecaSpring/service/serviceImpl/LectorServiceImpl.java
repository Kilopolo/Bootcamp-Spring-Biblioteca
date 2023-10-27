package com.capgemini.bibliotecaSpring.service.serviceImpl;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.capgemini.bibliotecaSpring.model.Lector;
import com.capgemini.bibliotecaSpring.repositorio.LectorRepositorio;
import com.capgemini.bibliotecaSpring.service.security.ServiceImpl;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.LectorService;

@Service
public class LectorServiceImpl extends ServiceImpl<LectorRepositorio, Lector> implements LectorService {

	private final int MAX_LIBROS = 3;

	@Override
	public void devolver(long id, LocalDate date) {
		// TODO Auto-generated method stub

	}

	@Override
	public void prestar(long id, LocalDate fechaAct) {
		// TODO Auto-generated method stub

	}

	@Override
	public void multar(int dias) {
		// TODO Auto-generated method stub

	}

}
