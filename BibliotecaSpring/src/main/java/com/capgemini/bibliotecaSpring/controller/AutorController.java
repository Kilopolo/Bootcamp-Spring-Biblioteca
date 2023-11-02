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
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.AutorService;

@Controller
@RequestMapping({ "/admin", "/" })
public class AutorController {
	

		@Autowired
		AutorService autorservice;


		@GetMapping("/autores")
		public String mostrarAutores(Model modelo) {
			return findPaginatedAutor(1, "nombre", "asc", modelo);
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
		
		// Paginacion
		@GetMapping("/pageautor/{pageNo}")
		public String findPaginatedAutor(@PathVariable (value="pageNo") int pageNo, @RequestParam ("sortField") String sortField,@RequestParam ("sortDir") String sortDir, Model modelo ) {
			int pageSize= 5;
			Page<Autor> page = autorservice.findPaginated(pageNo, pageSize, sortField, sortDir);
			List<Autor> autores= page.getContent();//Ya viene recortada --> slice
			modelo.addAttribute("sortDir", sortDir);
			modelo.addAttribute("sortField", sortField);
			modelo.addAttribute("currentPage", pageNo);
			modelo.addAttribute("totalPages", page.getTotalPages()); //Total de paginas
			modelo.addAttribute("totalItems", page.getTotalElements()); //Total de elements por pagina
			modelo.addAttribute("autores", autores);
			modelo.addAttribute("reverseSortDir", sortDir.equalsIgnoreCase("asc") ? "desc" : "asc");
			return "autor/mostrar";
		}


}
