package com.capgemini.bibliotecaSpring.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.bibliotecaSpring.model.Lector;
import com.capgemini.bibliotecaSpring.model.User;

@Repository
public interface LectorRepositorio extends JpaRepository<Lector, Long> {
	Lector findByUser(User user);
}
