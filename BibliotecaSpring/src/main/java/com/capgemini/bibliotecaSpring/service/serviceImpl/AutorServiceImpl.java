package com.capgemini.bibliotecaSpring.service.serviceImpl;

import org.springframework.stereotype.Service;

import com.capgemini.bibliotecaSpring.model.Autor;
import com.capgemini.bibliotecaSpring.repositorio.AutorRepositorio;
import com.capgemini.bibliotecaSpring.service.AutorService;


@Service
public class AutorServiceImpl extends ServiceImpl<AutorRepositorio,Autor> implements AutorService {


}
