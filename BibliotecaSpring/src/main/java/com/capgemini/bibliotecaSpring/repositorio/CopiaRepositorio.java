package com.capgemini.bibliotecaSpring.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.bibliotecaSpring.model.Copia;
import com.capgemini.bibliotecaSpring.model.Libro;

@Repository
public interface CopiaRepositorio extends JpaRepository<Copia, Long> {
	List<Copia> findByLibro(Libro libro);
}
