package com.capgemini.bibliotecaSpring.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bibliotecaSpring.model.Copia;
import com.capgemini.bibliotecaSpring.model.Libro;
import com.capgemini.bibliotecaSpring.repositorio.CopiaRepositorio;
import com.capgemini.bibliotecaSpring.service.CopiaService;

@Service
public class CopiaServiceImpl extends ServiceImpl<CopiaRepositorio, Copia> implements CopiaService {
	@Autowired
	CopiaRepositorio cr;

	@Override
	public List<Copia> findByLibro(Libro libro) {

		return cr.findByLibro(libro);
	}

}
