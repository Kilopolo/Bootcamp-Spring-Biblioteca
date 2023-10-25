package com.capgemini.bibliotecaSpring.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.bibliotecaSpring.model.Multa;

@Repository
public interface MultaRepositorio extends JpaRepository<Multa, Long> {

}
