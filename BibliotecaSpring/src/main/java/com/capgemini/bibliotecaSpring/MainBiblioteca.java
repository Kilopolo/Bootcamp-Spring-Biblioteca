package com.capgemini.bibliotecaSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.capgemini.bibliotecaSpring.repositorio.LectorRepositorio;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.AutorService;

@SpringBootApplication
public class MainBiblioteca {
	

	public static void main(String[] args) {
		
		

		ApplicationContext ac = SpringApplication.run(MainBiblioteca.class, args);
//		System.out.println(ac.getDisplayName().toString());
		System.out.println("http://localhost:8080/");
		System.out.println("INSERTANDO USUARIOS");
		

	}
}
