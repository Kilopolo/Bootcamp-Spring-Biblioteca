package com.capgemini.bibliotecaSpring.service.serviceInterfaces;

import java.util.List;

import org.springframework.data.domain.Page;

import com.capgemini.bibliotecaSpring.model.Lector;
import com.capgemini.bibliotecaSpring.model.Prestamo;
import com.capgemini.bibliotecaSpring.service.ServiceS;

public interface PrestamoService extends ServiceS<Prestamo> {
	List<Prestamo> findByLector(Lector lector);

	// Paginación para mostrar elementos por pagina (numero de pagina, elementos de
	// la pagina, ordenacion y direccion)
	Page<Prestamo> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection);
	 Prestamo guardar(Prestamo prestamo);
	void borrar(Prestamo prestamo);
	void devolver(Prestamo prestamo);
	void multar(Lector lector, int dias);
}
