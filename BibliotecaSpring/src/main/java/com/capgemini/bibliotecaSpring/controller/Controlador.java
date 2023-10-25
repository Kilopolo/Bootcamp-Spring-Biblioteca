package com.capgemini.bibliotecaSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capgemini.bibliotecaSpring.service.LibroService;

@Controller
public class Controlador {
	
	@Autowired
	private LibroService service;

	@RequestMapping("/")
	public String home() {
		System.out.println("home??");
		return "index";
	}
	
	
	

}
