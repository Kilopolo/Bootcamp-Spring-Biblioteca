package com.capgemini.bibliotecaSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.bibliotecaSpring.model.Autor;
import com.capgemini.bibliotecaSpring.model.Copia;
import com.capgemini.bibliotecaSpring.model.Lector;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.AutorService;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.CopiaService;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.LectorService;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.LibroService;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.PrestamoService;

@RestController
@RequestMapping("/api")
// 	ACORDARSE DE LAS ANOTACIONES EN LAS RELACIONES MANY TO ONE Y ONE TO MANY , en one to one no es necesario
public class RESTcontroller {
	@Autowired
	public LibroService libroservice;
	@Autowired
	public AutorService autorservice;
	@Autowired
	public LectorService lectorservice;
	@Autowired
	public CopiaService copiaservice;
	@Autowired
	public PrestamoService prestamoservice;

	Copia copia=null;
	
	@GetMapping("/listado")
	public List<Lector> index() {
		return lectorservice.getAll();
	}
	@GetMapping("/listadoautor")
	public List<Autor> indexautor() {
		return autorservice.getAll();
	}
}

