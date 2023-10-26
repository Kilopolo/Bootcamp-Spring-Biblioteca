package com.capgemini.bibliotecaSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.bibliotecaSpring.service.LibroService;

@Controller
public class Controlador {
	
	@Autowired
	private LibroService service;

	@GetMapping("/")
	public String home() {
		System.out.println("home??");
		return "index";
	}
	
//	@RequestMapping(value="/")
//	public ModelAndView home2() {
//	    ModelAndView model = new ModelAndView("index");
//	    return model;
//	}
//	

}
