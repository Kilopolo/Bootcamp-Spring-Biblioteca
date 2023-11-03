package com.capgemini.bibliotecaSpring.service.serviceImpl;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bibliotecaSpring.enumerados.EstadoCopia;
import com.capgemini.bibliotecaSpring.model.Copia;
import com.capgemini.bibliotecaSpring.model.Lector;
import com.capgemini.bibliotecaSpring.model.Multa;
import com.capgemini.bibliotecaSpring.model.Prestamo;
import com.capgemini.bibliotecaSpring.repositorio.CopiaRepositorio;
import com.capgemini.bibliotecaSpring.repositorio.LectorRepositorio;
import com.capgemini.bibliotecaSpring.repositorio.MultaRepositorio;
import com.capgemini.bibliotecaSpring.repositorio.PrestamoRepositorio;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.LectorService;

@Service
public class LectorServiceImpl extends ServiceImpl<LectorRepositorio, Lector> implements LectorService {

	private static final int DIAS_MULTA = 0;
	private static final int MAX_COPIAS = 3;
	@Autowired
	public LectorRepositorio lectorrepo;
	@Autowired
	public MultaRepositorio multarepo;
	@Autowired
	public PrestamoRepositorio prestamorepo;
	@Autowired
	public CopiaRepositorio copiarepo;


	private boolean isNotMoroso(Lector lector) {
		Multa multa = lector.getMulta();
		return multa == null || multa.getFFin() == null || multa.getFFin().isBefore(LocalDate.now());
	}


}
