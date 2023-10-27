package com.capgemini.bibliotecaSpring.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.bibliotecaSpring.model.Autor;
import com.capgemini.bibliotecaSpring.model.Libro;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro, Long> {
	List<Libro> findByAutor(Autor autor);
}
