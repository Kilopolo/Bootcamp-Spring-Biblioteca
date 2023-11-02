package com.capgemini.bibliotecaSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capgemini.bibliotecaSpring.model.Lector;
import com.capgemini.bibliotecaSpring.model.User;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.LectorService;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.UserService;

@Controller
@RequestMapping({ "/admin", "/" })
public class LectorController {
	
	
	@Autowired
	LectorService lectorservice;
	@Autowired
	UserService userservice;

	
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
		User user = userservice.getById(id);
		Lector lector = user.getLector();
		userservice.deleteById(id);
		lectorservice.deleteById(lector.getIdlector());
		return "redirect:/admin/lectores";

	}

}
