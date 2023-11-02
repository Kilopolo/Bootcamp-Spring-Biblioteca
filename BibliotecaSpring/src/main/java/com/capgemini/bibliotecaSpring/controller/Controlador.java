package com.capgemini.bibliotecaSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capgemini.bibliotecaSpring.enumerados.EstadoCopia;
import com.capgemini.bibliotecaSpring.model.Autor;
import com.capgemini.bibliotecaSpring.model.Copia;
import com.capgemini.bibliotecaSpring.model.Lector;
import com.capgemini.bibliotecaSpring.model.Libro;
import com.capgemini.bibliotecaSpring.model.Prestamo;
import com.capgemini.bibliotecaSpring.model.User;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.AutorService;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.CopiaService;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.LectorService;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.LibroService;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.PrestamoService;

@Controller
@RequestMapping({ "/admin", "/" })
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

	@PostMapping("/saveautor")
	public String saveAutor(@ModelAttribute("autor") Autor autor) {
		autorservice.save(autor);
		return "redirect:/autores";
	}

	@GetMapping("/addautor")
	public String formAutor(Model modelo) {
		Autor autor = new Autor();
		modelo.addAttribute("autor", autor);
		return "autor/addAutor";
	}

	@GetMapping("/updateautor/{idautor}")
	public String updateAutor(Model modelo, @PathVariable("idautor") long idautor) {
		Autor autor = autorservice.getById(idautor);
		modelo.addAttribute("autor", autor);
		return "autor/updateAutor";
	}

	@GetMapping("/deleteautor/{idautor}")
	public String deleteAutor(@PathVariable("idautor") long idautor, Model modelo) {
		autorservice.deleteById(idautor);
		return "redirect:/autores";

	}

	// LIBROS
	@GetMapping("/libros/{idautor}")
	public String mostrarLibros(Model modelo, @PathVariable("idautor") long idautor) {
		Autor autor = autorservice.getById(idautor);
		modelo.addAttribute("autor", autor);
		modelo.addAttribute("libros", libroservice.findByAutor(autor));
		return "libro/mostrar";
	}

	@GetMapping("/libros")
	public String mostrarTodoLibros(Model modelo) {
		modelo.addAttribute("libros", libroservice.getAll());
		return "libro/mostrarTodos";
	}

	@PostMapping("/savelibro/{idautor}")
	public String saveLibro(@ModelAttribute("libro") Libro libro, @PathVariable("idautor") long idautor, Model modelo) {
		Autor autor = autorservice.getById(idautor);
		libro.setAutor(autor);
		libroservice.save(libro);
		modelo.addAttribute("autor", autor);
		return "redirect:/libros/" + autor.getIdautor();
	}

	@GetMapping("/addlibro/{idautor}")
	public String formLibro(Model modelo, @PathVariable("idautor") long idautor) {
		Libro libro = new Libro();
		Autor autor = autorservice.getById(idautor);
		modelo.addAttribute("autor", autor);
		modelo.addAttribute("libro", libro);
		return "libro/addLibro";
	}

	@GetMapping("/deletelibro/{idlibro}")
	public String deleteLibro(@PathVariable("idlibro") long idlibro, Model modelo) {
		Autor autor = libroservice.getById(idlibro).getAutor();
		modelo.addAttribute("autor", autor);
		libroservice.deleteById(idlibro);
		return "redirect:/libros/" + autor.getIdautor();

	}

	@GetMapping("/updatelibro/{idlibro}")
	public String updateLibro(Model modelo, @PathVariable("idlibro") long idlibro) {
		Libro libro = libroservice.getById(idlibro);
		modelo.addAttribute("autor", libro.getAutor());
		modelo.addAttribute("libro", libro);
		return "libro/updateLibro";
	}

	// LECTORES
	@GetMapping("/lectores")
	public String mostrarLectores(Model modelo) {
		modelo.addAttribute("users", userservice.getAll());
		return "lector/mostrar";
	}

	

	@GetMapping("/updatelector/{id}")
	public String updateLector(Model modelo, @PathVariable("id") long id) {
		User user = userservice.getById(id);
		modelo.addAttribute("user", user);
		return "lector/updateLector";
	}

	@GetMapping("/deletelector/{id}")
	public String deleteLector(@PathVariable("id") long id, Model modelo) {
		userservicio.deleteById(id);
		return "redirect:/lectores";

	}

	// PRESTAMOS
	@GetMapping("/prestamos/{idlector}")
	public String mostrarPrestamosLector(Model modelo, @PathVariable("idlector") long idlector) {
		Lector lector = lectorservice.getById(idlector);
		modelo.addAttribute("lector", lector);
		modelo.addAttribute("prestamos", prestamoservice.findByLector(lector));
		return "prestamo/mostrar";
	}

	@PostMapping("/saveprestamo/{idlector}")
	public String savePrestamo(@ModelAttribute("prestamo") Prestamo prestamo, @PathVariable("idlector") long idlector,
			Model modelo) {
		Lector lector = lectorservice.getById(idlector);
		prestamo.setLector(lector);
		Copia copia = prestamo.getCopia();
		copia.setEstado(EstadoCopia.PRESTADO);
		prestamo.setCopia(copia);
		prestamoservice.save(prestamo);
		modelo.addAttribute("lector", lector);
		return "redirect:/prestamos/" + idlector;
	}

	@GetMapping("/addprestamo/{idlector}")
	public String formPrestamo(Model modelo, @PathVariable("idlector") long idlector) {
		Prestamo prestamo = new Prestamo();
		Lector lector = lectorservice.getById(idlector);
		modelo.addAttribute("lector", lector);
		modelo.addAttribute("prestamo", prestamo);
		modelo.addAttribute("copias", copiaservice.getAll());
		return "prestamo/addPrestamo";
	}

	@GetMapping("/updateprestamo/{idprestamo}")
	public String updatePrestamo(Model modelo, @PathVariable("idprestamo") long idprestamo) {
		Prestamo prestamo = prestamoservice.getById(idprestamo);
		modelo.addAttribute("lector", prestamo.getLector());
		modelo.addAttribute("prestamo", prestamo);
		return "prestamo/updatePrestamo";
	}

	@GetMapping("/deleteprestamo/{idprestamo}")
	public String deletePrestamo(@PathVariable("idprestamo") long idprestamo, Model modelo) {
		Lector lector = prestamoservice.getById(idprestamo).getLector();
		modelo.addAttribute("lector", lector);
		prestamoservice.deleteById(idprestamo);
		return "redirect:/prestamos/" + lector.getIdlector();

	}

	// COPIAS
	@GetMapping("/copias/{idlibro}")
	public String mostrarCopiasLibro(Model modelo, @PathVariable("idlibro") long idlibro) {
		Libro libro = libroservice.getById(idlibro);
		modelo.addAttribute("libro", libro);
		modelo.addAttribute("copias", copiaservice.findByLibro(libro));
		return "copia/mostrar";
	}

	@PostMapping("/savecopia/{idlibro}")
	public String saveCopia(@ModelAttribute("copia") Copia copia, @PathVariable("idlibro") long idlibro, Model modelo) {
		Libro libro = libroservice.getById(idlibro);
		copia.setLibro(libro);
		copiaservice.save(copia);
		modelo.addAttribute("libro", libro);
		return "redirect:/copias/" + idlibro;
	}

	@GetMapping("/addcopia/{idlibro}")
	public String formCopia(Model modelo, @PathVariable("idlibro") long idlibro) {
		Copia copia = new Copia();
		Libro libro = libroservice.getById(idlibro);
		modelo.addAttribute("libro", libro);
		modelo.addAttribute("copia", copia);
		return "copia/addCopia";
	}

	@GetMapping("/updatecopia/{idcopia}")
	public String updatecopia(Model modelo, @PathVariable("idcopia") long idcopia) {
		Copia copia = copiaservice.getById(idcopia);
		modelo.addAttribute("libro", copia.getLibro());
		modelo.addAttribute("copia", copia);
		return "copia/updateCopia";
	}

	@GetMapping("/deletecopia/{idcopia}")
	public String deleteCopia(@PathVariable("idcopia") long idcopia, Model modelo) {
		Libro libro = copiaservice.getById(idcopia).getLibro();
		modelo.addAttribute("libro", libro);
		copiaservice.deleteById(idcopia);
		return "redirect:/copias/" + libro.getIdlibro();

	}

}
