package com.capgemini.Biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.Biblioteca.model.Libro;
@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

}
