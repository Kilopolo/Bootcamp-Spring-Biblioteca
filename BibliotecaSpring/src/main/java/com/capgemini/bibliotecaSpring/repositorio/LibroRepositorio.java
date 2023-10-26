package com.capgemini.bibliotecaSpring.repositorio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.bibliotecaSpring.model.Libro;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro, Long> {
	
//	@Query("Select o FROM libros o WHERE o.titulo like ?1")
//	Page<Libro> searchByTitle(Pageable p, String searchText);

}
