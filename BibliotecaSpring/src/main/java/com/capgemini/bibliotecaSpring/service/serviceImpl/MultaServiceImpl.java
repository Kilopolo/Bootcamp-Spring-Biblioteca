package com.capgemini.bibliotecaSpring.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bibliotecaSpring.model.Lector;
import com.capgemini.bibliotecaSpring.model.Multa;
import com.capgemini.bibliotecaSpring.repositorio.MultaRepositorio;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.MultaService;

@Service
public class MultaServiceImpl extends ServiceImpl<MultaRepositorio, Multa> implements MultaService {
	
	@Autowired
	MultaRepositorio mr;
	
	@Override
	public List<Multa> findByLector(Lector lector) {
		// TODO Auto-generated method stub
		return mr.findByLector(lector);
	}

}
