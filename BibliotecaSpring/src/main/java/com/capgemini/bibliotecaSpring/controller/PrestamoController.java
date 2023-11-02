package com.capgemini.bibliotecaSpring.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capgemini.bibliotecaSpring.enumerados.EstadoCopia;
import com.capgemini.bibliotecaSpring.model.Copia;
import com.capgemini.bibliotecaSpring.model.Lector;
import com.capgemini.bibliotecaSpring.model.Prestamo;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.CopiaService;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.LectorService;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.PrestamoService;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.UserService;

@Controller
@RequestMapping({ "/admin", "/" })
public class PrestamoController {

	@Autowired
	LectorService lectorservice;
	@Autowired
	CopiaService copiaservice;
	@Autowired
	PrestamoService prestamoservice;
	@Autowired
	UserService userservice;

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
		Copia copia = prestamo.getCopia();
		copia.setEstado(EstadoCopia.PRESTADO);
		prestamo.setLector(lector);
		prestamo.setCopia(copia);
		prestamo.setFechaInicio(LocalDate.now());
		prestamo.setFechaFin(LocalDate.now().plusDays(30));
		prestamoservice.save(prestamo);
		modelo.addAttribute("lector", lector);
		return "redirect:/prestamos/" + idlector;
	}

	@GetMapping("/addprestamo/{idlector}")
	public String formPrestamo(Model modelo, @PathVariable("idlector") long idlector) {
		Prestamo prestamo;
		Lector lector;

		prestamo = new Prestamo();
		lector = lectorservice.getById(idlector);
		prestamo.setFechaInicio(LocalDate.now());

		modelo.addAttribute("lector", lector);
		modelo.addAttribute("prestamo", prestamo);
		modelo.addAttribute("copias", copiaservice.copiaBiblioteca());
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
	
	@GetMapping("/devolver/{idprestamo}")
	public String devolverPrestamo(@PathVariable("idprestamo") long idprestamo, Model modelo) {
		Lector lector = prestamoservice.getById(idprestamo).getLector();
		Prestamo prestamo =prestamoservice.getById(idprestamo);
		prestamo.setFechaFin(LocalDate.now());
		LocalDate fechaFin= prestamo.getFechaFin();
		lectorservice.devolver(lector.getIdlector(), fechaFin);
		modelo.addAttribute("lector", lector);
		return "redirect:/prestamos/" + lector.getIdlector();

	}
	

}
