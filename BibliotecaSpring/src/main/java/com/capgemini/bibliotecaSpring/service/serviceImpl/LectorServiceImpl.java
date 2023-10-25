package com.capgemini.bibliotecaSpring.service.serviceImpl;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.capgemini.bibliotecaSpring.model.Lector;
import com.capgemini.bibliotecaSpring.service.LectorService;


@Service
public class LectorServiceImpl extends ServiceImpl<LectorService, Lector> implements LectorService{

	@Override
	public void devolver(long id, LocalDate date) {
		// TODO Auto-generated method stub
		
	}




}
