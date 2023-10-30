package com.capgemini.bibliotecaSpring.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.bibliotecaSpring.model.Autor;
import com.capgemini.bibliotecaSpring.model.Libro;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro, Long> {

//	@Query("Select o FROM libros o WHERE o.titulo like ?1")
//	Page<Libro> searchByTitle(Pageable p, String searchText);
	List<Libro> findByAutor(Autor autor);
//	@Query("Select o FROM libros o WHERE o.title like ?1")
//	Page<Libro> searchByTitle(Pageable p, String searchText);

}
