package com.capgemini.bibliotecaSpring.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bibliotecaSpring.model.Lector;
import com.capgemini.bibliotecaSpring.model.Prestamo;
import com.capgemini.bibliotecaSpring.repositorio.PrestamoRepositorio;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.PrestamoService;
@Service
public class PrestamoServiceImpl extends ServiceImpl<PrestamoRepositorio, Prestamo> implements PrestamoService {

	@Autowired
	PrestamoRepositorio pr;

	@Override
	public List<Prestamo> findByLector(Lector lector) {
		// TODO Auto-generated method stub
		return pr.findByLector(lector);
	}

}
