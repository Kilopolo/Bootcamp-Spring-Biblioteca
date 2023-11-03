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
	@Query(value ="SELECT * FROM lectores as l\r\n"
			+ "inner join prestamos p on p.n_socio= l.n_socio\r\n"
			+ "left join copias c on c.idcopia=p.idcopia\r\n"
			+ "where c.estado ='BIBLIOTECA' AND l.n_socio= ?1", nativeQuery=true)
    List<Prestamo> findPrestamosByNSocioAndEstadoBiblioteca(Long nSocio);

}
