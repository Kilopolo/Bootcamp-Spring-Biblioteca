package com.capgemini.bibliotecaSpring.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.bibliotecaSpring.model.Lector;

@Repository
public interface LectorRepositorio extends JpaRepository<Lector, Long> {

}
