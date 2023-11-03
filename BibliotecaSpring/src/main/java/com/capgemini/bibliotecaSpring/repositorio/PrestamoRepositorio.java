package com.capgemini.bibliotecaSpring.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.bibliotecaSpring.model.Lector;
import com.capgemini.bibliotecaSpring.model.Prestamo;

@Repository
public interface PrestamoRepositorio extends JpaRepository<Prestamo, Long> {
	List<Prestamo> findByLector(Lector lector);

}
