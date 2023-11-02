package com.capgemini.bibliotecaSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capgemini.bibliotecaSpring.model.Lector;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.LectorService;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.MultaService;

@Controller
@RequestMapping({ "/admin", "/" })
public class MultaController {
	
	@Autowired
	LectorService lectorservice;
	@Autowired
	MultaService multaservice;
	
	@GetMapping("/multas/{idlector}")
	public String mostrarMultasLector(Model modelo, @PathVariable("idlector") long idlector) {
		Lector lector = lectorservice.getById(idlector);
		modelo.addAttribute("lector", lector);
		modelo.addAttribute("multas", multaservice.findByLector(lector));
		return "multa/mostrar";
	}
}
