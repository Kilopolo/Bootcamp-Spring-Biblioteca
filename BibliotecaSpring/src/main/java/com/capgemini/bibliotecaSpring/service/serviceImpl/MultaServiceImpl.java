package com.capgemini.bibliotecaSpring.service.serviceImpl;

import org.springframework.stereotype.Service;

import com.capgemini.bibliotecaSpring.model.Multa;
import com.capgemini.bibliotecaSpring.repositorio.MultaRepositorio;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.MultaService;

@Service
public class MultaServiceImpl extends ServiceImpl<MultaRepositorio, Multa> implements MultaService {

}
