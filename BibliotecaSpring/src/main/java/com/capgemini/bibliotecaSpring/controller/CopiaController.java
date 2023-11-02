package com.capgemini.bibliotecaSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capgemini.bibliotecaSpring.model.Copia;
import com.capgemini.bibliotecaSpring.model.Libro;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.CopiaService;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.LibroService;

@Controller
@RequestMapping({ "/admin", "/" })
public class CopiaController {
	@Autowired
	LibroService libroservice;
	@Autowired
	CopiaService copiaservice;

	
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
