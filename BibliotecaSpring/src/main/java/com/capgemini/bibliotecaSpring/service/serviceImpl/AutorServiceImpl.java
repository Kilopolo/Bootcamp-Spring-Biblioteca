package com.capgemini.bibliotecaSpring.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bibliotecaSpring.model.Autor;
import com.capgemini.bibliotecaSpring.model.Libro;
import com.capgemini.bibliotecaSpring.repositorio.AutorRepositorio;
import com.capgemini.bibliotecaSpring.service.AutorService;


@Service
public class AutorServiceImpl extends ServiceImpl<AutorRepositorio,Autor> implements AutorService {
	
	@Autowired
	AutorRepositorio ar;	
	@Override
	public void deleteById(long id) {
		 ar.deleteById(id);
	
}
	@Override
	public List<Libro> findByAutor(Autor autor) {
		
		return null;
	}

	

}
