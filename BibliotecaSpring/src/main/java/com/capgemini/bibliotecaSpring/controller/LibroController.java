package com.capgemini.bibliotecaSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.bibliotecaSpring.model.Autor;
import com.capgemini.bibliotecaSpring.model.Libro;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.AutorService;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.LibroService;

@Controller
@RequestMapping({ "/admin", "/" })
public class LibroController {
	
	@Autowired
	LibroService libroservice;
	@Autowired
	AutorService autorservice;

	
	@GetMapping("/libros/{idautor}")
	public String mostrarLibros(Model modelo, @PathVariable("idautor") long idautor) {
		Autor autor = autorservice.getById(idautor);
		modelo.addAttribute("autor", autor);
		modelo.addAttribute("libros", libroservice.findByAutor(autor));
		return "libro/mostrar";
	}

	@GetMapping("/libros")
	public String mostrarTodoLibros(Model modelo) {
		return findPaginatedLibro(1, "titulo", "asc", modelo);
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
	
	// Paginacion
	@GetMapping("/pagelibro/{pageNo}")
	public String findPaginatedLibro(@PathVariable (value="pageNo") int pageNo, @RequestParam ("sortField") String sortField,@RequestParam ("sortDir") String sortDir, Model modelo ) {
		int pageSize= 5;
		Page<Libro> page = libroservice.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Libro> libros= page.getContent();//Ya viene recortada --> slice
		modelo.addAttribute("sortDir", sortDir);
		modelo.addAttribute("sortField", sortField);
		modelo.addAttribute("currentPage", pageNo);
		modelo.addAttribute("totalPages", page.getTotalPages()); //Total de paginas
		modelo.addAttribute("totalItems", page.getTotalElements()); //Total de elements por pagina
		modelo.addAttribute("libros", libros);
		modelo.addAttribute("reverseSortDir", sortDir.equalsIgnoreCase("asc") ? "desc" : "asc");
		return "libro/mostrarTodos";
	}

}
