package com.capgemini.bibliotecaSpring.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.bibliotecaSpring.model.Lector;
import com.capgemini.bibliotecaSpring.model.Prestamo;

@Repository
public interface LectorRepositorio extends JpaRepository<Lector, Long> {

	//-hacer la query para coger el ultimo prestamo devuelto y coger la fecha para comparar y multar
	@Query("SELECT p FROM lectores l " +
            "INNER JOIN prestamos p ON p.n_socio = l.n_socio " +
            "LEFT JOIN copias c ON c.idcopia = p.idcopia " +
            "WHERE c.estado = 'BIBLIOTECA' " +
            "AND l.n_socio = :nSocio")
    List<Prestamo> findPrestamosByNSocioAndEstadoBiblioteca(@Param("nSocio") Long nSocio);

}
