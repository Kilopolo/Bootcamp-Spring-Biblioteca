package com.capgemini.bibliotecaSpring.service.serviceImpl;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.capgemini.bibliotecaSpring.model.Libro;
import com.capgemini.bibliotecaSpring.repositorio.LibroRepositorio;
import com.capgemini.bibliotecaSpring.service.LibroService;

@Service
public class LibroServiceImpl extends ServiceImpl<LibroRepositorio, Libro> implements LibroService {

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
}
