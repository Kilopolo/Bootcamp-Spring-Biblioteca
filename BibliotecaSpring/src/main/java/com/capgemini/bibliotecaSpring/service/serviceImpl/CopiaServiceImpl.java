package com.capgemini.bibliotecaSpring.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bibliotecaSpring.enumerados.EstadoCopia;
import com.capgemini.bibliotecaSpring.model.Copia;
import com.capgemini.bibliotecaSpring.model.Libro;
import com.capgemini.bibliotecaSpring.repositorio.CopiaRepositorio;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.CopiaService;

@Service
public class CopiaServiceImpl extends ServiceImpl<CopiaRepositorio, Copia> implements CopiaService {
	@Autowired
	CopiaRepositorio cr;

	@Override
	public List<Copia> findByLibro(Libro libro) {

		return cr.findByLibro(libro);
	}

	@Override
	public List<Copia> copiaBiblioteca() {
		List<Copia> copias=cr.findAll();
		List<Copia> copiasBiblioteca = new ArrayList<Copia>();
		for(Copia cb : copias) {
			if(cb.getEstado()== EstadoCopia.BIBLIOTECA) {
				copiasBiblioteca.add(cb);
			}
		}
		return copiasBiblioteca;
	}

}
