package com.capgemini.bibliotecaSpring.service.serviceInterfaces;

import java.util.List;

import org.springframework.data.domain.Page;

import com.capgemini.bibliotecaSpring.model.Lector;
import com.capgemini.bibliotecaSpring.model.Multa;
import com.capgemini.bibliotecaSpring.service.ServiceS;

public interface MultaService extends ServiceS<Multa> {
	List<Multa> findByLector(Lector lector);
	//Paginación para mostrar elementos por pagina (numero de pagina, elementos de la pagina, ordenacion y direccion)
		Page<Multa> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection);
}
