package com.capgemini.bibliotecaSpring.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.capgemini.bibliotecaSpring.model.Autor;
import com.capgemini.bibliotecaSpring.repositorio.AutorRepositorio;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.AutorService;

@Service
public class AutorServiceImpl extends ServiceImpl<AutorRepositorio, Autor> implements AutorService {

	@Autowired
	AutorRepositorio ar;

	@Override
	public void deleteById(long id) {
		ar.deleteById(id);

	}
	
	@Override
	public Page<Autor> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection) {
		//if reducido --> variable = lógica ? true : false
		//Preguntamos si es ascendente, si lo es se ordena ascendente, sino en descendente.
		Sort sort= sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())? Sort.by(sortField).ascending(): Sort.by(sortField).descending();
		//la paginación la montamos en el objeto
		Pageable pageable = PageRequest.of(pageNum -1, pageSize, sort);
		//Le pasamos la paginación el objeto
		return this.ar.findAll(pageable);
	}

}
