package com.capgemini.bibliotecaSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.capgemini.bibliotecaSpring.model.Autor;
import com.capgemini.bibliotecaSpring.model.Copia;
import com.capgemini.bibliotecaSpring.model.Lector;
import com.capgemini.bibliotecaSpring.model.Libro;
import com.capgemini.bibliotecaSpring.model.Prestamo;
import com.capgemini.bibliotecaSpring.service.AutorService;
import com.capgemini.bibliotecaSpring.service.CopiaService;
import com.capgemini.bibliotecaSpring.service.LectorService;
import com.capgemini.bibliotecaSpring.service.LibroService;
import com.capgemini.bibliotecaSpring.service.PrestamoService;

@Controller
public class Controlador {

	@Autowired
	LibroService libroservice;
	@Autowired
	AutorService autorservice;
	@Autowired
	LectorService lectorservice;
	@Autowired
	CopiaService copiaservice;
	@Autowired
	PrestamoService prestamoservice;

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
	@GetMapping("/libros/{idautor}")
	public String mostrarLibros(Model modelo, @PathVariable ("idautor") long idautor) {
		Autor autor = autorservice.getById(idautor);
		modelo.addAttribute("autor",autor);
		modelo.addAttribute("libros", libroservice.findByAutor(autor));
		return "libro/mostrar";
	}

	@GetMapping("/addlibro/{idautor}")
	public String formLibro(Model modelo, @PathVariable	("idautor") long idautor) {
		Libro libro = new Libro();
		Autor autor = autorservice.getById(idautor);
		modelo.addAttribute("autor",autor);
		modelo.addAttribute("libro", libro);
		return "libro/addLibro";
	}

	@GetMapping("/deletelibro/{idlibro}")
	public String deleteLibro(@PathVariable("idlibro") long idlibro, Model modelo) {
		Autor autor = libroservice.getById(idlibro).getAutor();
		modelo.addAttribute("autor", autor);
		libroservice.deleteById(idlibro);
		return "redirect:/libros/"+autor.getIdautor();

	}
	@GetMapping("/updatelibro/{idlibro}")
	public String updateLibro(Model modelo, @PathVariable	("idlibro") long idlibro) {
		Libro libro = libroservice.getById(idlibro);
		modelo.addAttribute("autor",libro.getAutor());
		modelo.addAttribute("libro", libro);
		return "libro/updateLibro";
	}
	

	// LECTORES
	@GetMapping("/lectores")
	public String mostrarLectores(Model modelo) {
		modelo.addAttribute("lectores", lectorservice.getAll());
		return "lector/mostrar";
	}
	
	@GetMapping("/addlector")
	public String formLector(Model modelo) {
		Lector lector = new Lector();
		modelo.addAttribute("lector", lector);
		return "lector/addLector";
	}
	@GetMapping("/deletelector/{idlector}")
	public String deleteLector(@PathVariable("idlector") long idlector, Model modelo) {
		lectorservice.deleteById(idlector);
		return "redirect:/lectores";

	}
	
	
	//PRESTAMOS
	@GetMapping("/prestamos/{idlector}")
	public String mostrarPrestamosLector(Model modelo, @PathVariable ("idlector") long idlector) {
		Lector lector = lectorservice.getById(idlector);
		modelo.addAttribute("lector",lector);
		modelo.addAttribute("prestamos", prestamoservice.findByLector(lector));
		return "prestamo/mostrar";
	}
	
	@GetMapping("/addprestamo/{idlector}")
	public String formPrestamo(Model modelo, @PathVariable	("idlector") long idlector) {
		Prestamo prestamo = new Prestamo();
		Lector lector = lectorservice.getById(idlector);
		modelo.addAttribute("lector",lector);
		modelo.addAttribute("prestamo", prestamo);
		modelo.addAttribute("copias", copiaservice.getAll());
		return "prestamo/addPrestamo";
	}
	@GetMapping("/deleteprestamo/{idprestamo}")
	public String deletePrestamo(@PathVariable("idprestamo") long idprestamo, Model modelo) {
		Lector lector = prestamoservice.getById(idprestamo).getLector();
		modelo.addAttribute("lector", lector);
		prestamoservice.deleteById(idprestamo);
		return "redirect:/prestamos/"+lector.getIdlector();

	}
	
	//COPIAS
	@GetMapping("/copias/{idlibro}")
	public String mostrarCopiasLibro(Model modelo, @PathVariable ("idlibro") long idlibro) {
		Libro libro = libroservice.getById(idlibro);
		modelo.addAttribute("libro",libro);
		modelo.addAttribute("copias", copiaservice.findByLibro(libro));
		return "copia/mostrar";
	}
	@GetMapping("/addcopia/{idlibro}")
	public String formCopia(Model modelo, @PathVariable	("idlibro") long idlibro) {
		Copia copia = new Copia();
		Libro libro = libroservice.getById(idlibro);
		modelo.addAttribute("libro",libro);
		modelo.addAttribute("copia", copia);
		return "copia/addCopia";
	}
	@GetMapping("/deletecopia/{idcopia}")
	public String deleteCopia(@PathVariable("idcopia") long idcopia, Model modelo) {
		Libro libro = copiaservice.getById(idcopia).getLibro();
		modelo.addAttribute("libro", libro);
		copiaservice.deleteById(idcopia);
		return "redirect:/copias/"+libro.getIdlibro();

	}

}
