package com.capgemini.bibliotecaSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.capgemini.bibliotecaSpring.model.Libro;
import com.capgemini.bibliotecaSpring.service.LibroService;

@Controller
public class Controlador {
	
	@Autowired
	private LibroService service;

	    @GetMapping("/")
	    public String helloWorld() {
	        System.out.println("Hola, mundo");
	        return "index";
	    }
	    
	    @GetMapping("/addlibro")
		public String addLibro(Model model) {
			Libro libro=new Libro();
			model.addAttribute("libro", libro);
			return "libro/addLibro";
		}
	
	

}
