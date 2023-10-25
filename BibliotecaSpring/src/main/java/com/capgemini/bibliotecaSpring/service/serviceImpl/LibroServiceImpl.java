package com.capgemini.bibliotecaSpring.service.serviceImpl;

import org.springframework.stereotype.Service;

import com.capgemini.bibliotecaSpring.model.Libro;
import com.capgemini.bibliotecaSpring.repositorio.LibroRepositorio;
import com.capgemini.bibliotecaSpring.service.LibroService;

@Service
public class LibroServiceImpl extends ServiceImpl<LibroRepositorio, Libro> implements LibroService {


}
