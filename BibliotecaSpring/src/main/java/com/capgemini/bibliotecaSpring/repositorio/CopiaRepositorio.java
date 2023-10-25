package com.capgemini.bibliotecaSpring.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.bibliotecaSpring.model.Copia;
@Repository
public interface CopiaRepositorio extends JpaRepository<Copia, Long> {

}
