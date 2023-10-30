package com.capgemini.bibliotecaSpring.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bibliotecaSpring.model.Autor;
import com.capgemini.bibliotecaSpring.model.Libro;
import com.capgemini.bibliotecaSpring.repositorio.LibroRepositorio;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.LibroService;

@Service
public class LibroServiceImpl extends ServiceImpl<LibroRepositorio, Libro> implements LibroService {
	@Autowired
	LibroRepositorio lr;

//	@Autowired
//	LibroRepositorio librosRepository;
//	 
//	public Page<Libro> searchBookByTitle(Pageable p, String searchText){
//		searchText = "%"+searchText+"%";
//		Page<Libro> boffers = new PageImpl<Libro>(new LinkedList<Libro>());
//		
//		boffers = librosRepository.searchByTitle(p, searchText);
//		return boffers;
//	}
	@Override
	public List<Libro> findByAutor(Autor autor) {
		// TODO Auto-generated method stub
		return lr.findByAutor(autor);
	}
	

}
