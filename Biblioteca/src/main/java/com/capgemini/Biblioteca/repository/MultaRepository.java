package com.capgemini.Biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.Biblioteca.model.Libro;

public interface MultaRepository extends JpaRepository<Libro, String> {

}
