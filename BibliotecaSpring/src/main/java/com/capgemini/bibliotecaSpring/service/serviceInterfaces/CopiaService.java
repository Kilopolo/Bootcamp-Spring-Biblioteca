package com.capgemini.bibliotecaSpring.service.serviceInterfaces;

import java.util.List;

import org.springframework.data.domain.Page;

import com.capgemini.bibliotecaSpring.model.Copia;
import com.capgemini.bibliotecaSpring.model.Libro;
import com.capgemini.bibliotecaSpring.service.ServiceS;

public interface CopiaService extends ServiceS<Copia> {
	List<Copia> findByLibro(Libro libro);
	//Paginación para mostrar elementos por pagina (numero de pagina, elementos de la pagina, ordenacion y direccion)
	Page<Copia> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection);
	List<Copia> copiaBiblioteca();
}
