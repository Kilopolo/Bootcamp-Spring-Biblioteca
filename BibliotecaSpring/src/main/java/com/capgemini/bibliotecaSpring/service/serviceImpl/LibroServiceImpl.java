package com.capgemini.bibliotecaSpring.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	@Override
	public Page<Libro> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection) {
		//if reducido --> variable = lógica ? true : false
		//Preguntamos si es ascendente, si lo es se ordena ascendente, sino en descendente.
		Sort sort= sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())? Sort.by(sortField).ascending(): Sort.by(sortField).descending();
		//la paginación la montamos en el objeto
		Pageable pageable = PageRequest.of(pageNum -1, pageSize, sort);
		//Le pasamos la paginación el objeto
		return this.lr.findAll(pageable);
	}

}
