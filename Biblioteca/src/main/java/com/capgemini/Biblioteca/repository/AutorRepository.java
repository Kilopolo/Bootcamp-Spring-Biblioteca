package com.capgemini.Biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.Biblioteca.model.Libro;

public interface AutorRepository extends JpaRepository<Libro, String> {

}
