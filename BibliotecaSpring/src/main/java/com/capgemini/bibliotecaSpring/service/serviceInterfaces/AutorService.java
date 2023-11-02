package com.capgemini.bibliotecaSpring.service.serviceInterfaces;

import org.springframework.data.domain.Page;

import com.capgemini.bibliotecaSpring.model.Autor;
import com.capgemini.bibliotecaSpring.service.ServiceS;

public interface AutorService extends ServiceS<Autor> {
	//Paginación para mostrar elementos por pagina (numero de pagina, elementos de la pagina, ordenacion y direccion)
		Page<Autor> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection);
}
