package com.capgemini.bibliotecaSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capgemini.bibliotecaSpring.model.Autor;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.AutorService;

@Controller
@RequestMapping({ "/admin", "/" })
public class AutorController {
	

		@Autowired
		AutorService autorservice;


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

}
