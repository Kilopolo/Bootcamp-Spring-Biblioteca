package com.capgemini.bibliotecaSpring.service.serviceImpl;

import org.springframework.stereotype.Service;

import com.capgemini.bibliotecaSpring.model.Copia;
import com.capgemini.bibliotecaSpring.repositorio.CopiaRepositorio;
import com.capgemini.bibliotecaSpring.service.CopiaService;


@Service
public class CopiaServiceImpl extends ServiceImpl<CopiaRepositorio,Copia> implements CopiaService {


}
