package com.capgemini.bibliotecaSpring.service.serviceInterfaces;

import java.util.List;

import org.springframework.data.domain.Page;

import com.capgemini.bibliotecaSpring.model.Autor;
import com.capgemini.bibliotecaSpring.model.Libro;
import com.capgemini.bibliotecaSpring.service.ServiceS;

public interface LibroService extends ServiceS<Libro> {
	// public Page<Libro> searchBookByTitle(Pageable p, String searchText);
	List<Libro> findByAutor(Autor autor);
	//Paginación para mostrar elementos por pagina (numero de pagina, elementos de la pagina, ordenacion y direccion)
		Page<Libro> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection);
}
