package com.capgemini.bibliotecaSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.capgemini.bibliotecaSpring.model.Autor;
import com.capgemini.bibliotecaSpring.model.Lector;
import com.capgemini.bibliotecaSpring.model.Libro;
import com.capgemini.bibliotecaSpring.service.AutorService;
import com.capgemini.bibliotecaSpring.service.LibroService;

@Controller
public class Controlador {

	@Autowired
	LibroService libroservice;
	@Autowired
	AutorService autorservice;

	@GetMapping("/")
	public String index() {
		System.out.println("Hola, mundo");
		return "index";
	}

	// AUTORES
	@GetMapping("/autores")
	public String mostrarAutores(Model modelo) {
		modelo.addAttribute("autores", autorservice.getAll());
		return "autor/mostrar";
	}

	@GetMapping("/addautor")
	public String formAutor(Model modelo) {
		Autor autor = new Autor();
		modelo.addAttribute("autor", autor);
		return "autor/addAutor";
	}

	@GetMapping("/deleteautor/{idautor}")
	public String deleteAutor(@PathVariable("idautor") long idautor, Model modelo) {

		autorservice.deleteById(idautor);
		return "redirect:/autores";

	}

	// LIBROS
	@GetMapping("/libros")
	public String mostrarLibros(Model modelo) {
		modelo.addAttribute("libros", libroservice.getAll());
		return "libro/mostrar";
	}

	@GetMapping("/addlibro")
	public String formLibro(Model model) {
		Libro libro = new Libro();
		model.addAttribute("autores", autorservice.getAll());
		model.addAttribute("libro", libro);
		return "libro/addLibro";
	}

	@GetMapping("/deletelibro/{idlibro}")
	public String deleteLibro(@PathVariable("idlibro") long idlibro, Model modelo) {

		libroservice.deleteById(idlibro);
		return "redirect:/libros";

	}

	// LECTORES
	@GetMapping("/addlector")
	public String formLector(Model modelo) {
		Lector lector = new Lector();
		modelo.addAttribute("lector", lector);
		return "lector/addLector";
	}

}
