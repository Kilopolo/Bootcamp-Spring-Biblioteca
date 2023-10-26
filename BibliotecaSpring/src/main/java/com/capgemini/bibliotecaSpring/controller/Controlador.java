package com.capgemini.bibliotecaSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.capgemini.bibliotecaSpring.model.Autor;
import com.capgemini.bibliotecaSpring.model.Lector;
import com.capgemini.bibliotecaSpring.service.LibroService;

@Controller
public class Controlador {
	
	@Autowired
	private LibroService service;

	    @GetMapping("/")
	    public String helloWorld() {
	        System.out.println("Hola, mundo");
	        return "index.html";
	    }
		@GetMapping("/addlector")
		public String showNewLectorForm(Model modelo) {
			Lector lector = new Lector();
			modelo.addAttribute("lector", lector);
			return "lector/addLector";
		}
		@GetMapping("/addautor")
		public String showNewAutorForm(Model modelo) {
			Autor autor = new Autor();
			modelo.addAttribute("autor", autor);
			return "autor/addAutor";
		}
	

}
