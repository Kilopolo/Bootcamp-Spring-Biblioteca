package com.capgemini.bibliotecaSpring.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.bibliotecaSpring.model.Autor;
import com.capgemini.bibliotecaSpring.model.Copia;
import com.capgemini.bibliotecaSpring.model.Lector;
import com.capgemini.bibliotecaSpring.model.Libro;
import com.capgemini.bibliotecaSpring.model.Multa;
import com.capgemini.bibliotecaSpring.model.Prestamo;
import com.capgemini.bibliotecaSpring.service.AutorService;
import com.capgemini.bibliotecaSpring.service.CopiaService;
import com.capgemini.bibliotecaSpring.service.LectorService;
import com.capgemini.bibliotecaSpring.service.LibroService;
import com.capgemini.bibliotecaSpring.service.MultaService;
import com.capgemini.bibliotecaSpring.service.PrestamoService;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.AutorService;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.CopiaService;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.LectorService;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.LibroService;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.PrestamoService;

@Controller
public class Controlador {
	@Autowired
	public LibroService libroservice;
	@Autowired
	public AutorService autorservice;
	@Autowired
	public LectorService lectorservice;
	@Autowired
	public CopiaService copiaservice;
	@Autowired
	public PrestamoService prestamoservice;


	@GetMapping("/")
	public String index() {
		System.out.println("Hola, mundo");
		return "index";
	}

	// AUTORES
	@GetMapping("/autores")
	public String mostrarAutores(Model modelo) {
		modelo.addAttribute("autores", autorservice.getAll());
		return "autor/mostrar";
	}

	@GetMapping("/addautor")
	public String formAutor(Model modelo) {
		Autor autor = new Autor();
		modelo.addAttribute("autor", autor);
		return "autor/addAutor";
	}

	@GetMapping("/deleteautor/{idautor}")
	public String deleteAutor(@PathVariable("idautor") long idautor, Model modelo) {
		autorservice.deleteById(idautor);
		return "redirect:/autores";
		
	}
	
	@GetMapping("/updateautor/{idautor}")
	public String updateAutor(Model modelo, @PathVariable	("idautor") long idautor) {
		Autor autor = autorservice.getById(idautor);
		modelo.addAttribute("autor", autor);
		return "autor/updateAutor";
	}
	
	@PostMapping("/saveAutor")
	public String saveAutor(@ModelAttribute("autor") Autor autor) {
		autorservice.save(autor);
		return "redirect:/autores";
	}
	
	

	// LIBROS
	@GetMapping("/libros/{idautor}")
	public String mostrarLibros(Model modelo, @PathVariable ("idautor") long idautor) {
		Autor autor = autorservice.getById(idautor);
		modelo.addAttribute("autor",autor);
		modelo.addAttribute("libros", libroservice.findByAutor(autor));
		return "libro/mostrar";
	}

	@GetMapping("/addlibro/{idautor}")
	public String formLibro(Model modelo, @PathVariable	("idautor") long idautor) {
		Libro libro = new Libro();
		Autor autor = autorservice.getById(idautor);
		modelo.addAttribute("autor",autor);
		modelo.addAttribute("libro", libro);
		return "libro/addLibro";
	}

	@GetMapping("/deletelibro/{idlibro}")
	public String deleteLibro(@PathVariable("idlibro") long idlibro, Model modelo) {
		Autor autor =libroservice.getById(idlibro).getAutor();
		modelo.addAttribute("autor", autor);
		libroservice.deleteById(idlibro);
		return "redirect:/libros/"+autor.getIdautor();

	}
	@GetMapping("/updatelibro/{idlibro}")
	public String updateLibro(Model modelo, @PathVariable	("idlibro") long idlibro) {
		Libro libro = libroservice.getById(idlibro);
		modelo.addAttribute("autor",libro.getAutor());
		modelo.addAttribute("libro", libro);
		return "libro/updateLibro";
	}
	
	@PostMapping("/saveLibro")
	public String saveLibro(@ModelAttribute("libro") Libro libro) {
		libroservice.save(libro);
		return "redirect:/libros";
	}

	// LECTORES
	@GetMapping("/lectores")
	public String mostrarLectores(Model modelo) {
		modelo.addAttribute("lectores", lectorservice.getAll());
		System.out.println("hola lectores");
		return "lector/mostrar";
	}
	
	@GetMapping("/addlector")
	public String formLector(Model modelo) {
		Lector lector = new Lector();
		modelo.addAttribute("lector", lector);
		return "lector/addLector";
	}
	
	@PostMapping("/saveLector")
	public String saveLector(@ModelAttribute("lector") Lector lector) {
		lectorservice.save(lector);
		return "redirect:/lectores";
	}
	
	
	//PRESTAMOS
	@GetMapping("/prestamos/{idlector}")
	public String mostrarPrestamosLector(Model modelo, @PathVariable ("idlector") long idlector) {
		Lector lector = lectorservice.getById(idlector);
		modelo.addAttribute("lector",lector);
		modelo.addAttribute("prestamos", prestamoservice.findByLector(lector));
		return "prestamo/mostrar";
	}
	
	@GetMapping("/addprestamo/{idlector}")
	public String formPrestamo(Model modelo, @PathVariable	("idlector") long idlector) {
		Prestamo prestamo = new Prestamo();
		Lector lector = lectorservice.getById(idlector);
		modelo.addAttribute("lector",lector);
		modelo.addAttribute("prestamo", prestamo);
		modelo.addAttribute("copias", copiaservice.getAll());
		return "prestamo/addPrestamo";
	}
	
	@PostMapping("/savePrestamo")
	public String savePrestamo(@ModelAttribute("prestamo") Prestamo prestamo) {
		prestamoservice.save(prestamo);
		return "redirect:/prestamos";
	}
	
	
	//COPIAS
	@GetMapping("/copias/{idlibro}")
	public String mostrarCopiasLibro(Model modelo, @PathVariable ("idlibro") long idlibro) {
		Libro libro = libroservice.getById(idlibro);
		modelo.addAttribute("libro",libro);
		modelo.addAttribute("copias", copiaservice.findByLibro(libro));
		return "copia/mostrar";
	}
	@GetMapping("/addcopia/{idlibro}")
	public String formCopia(Model modelo, @PathVariable	("idlibro") long idlibro) {
		Copia copia = new Copia();
		Libro libro = libroservice.getById(idlibro);
		modelo.addAttribute("libro",libro);
		modelo.addAttribute("copia", copia);
		return "copia/addCopia";
	}
	
	@PostMapping("/saveCopias")
	public String saveCopia(@ModelAttribute("copia") Copia copia) {
		copiaservice.save(copia);
		return "redirect:/copias";
	}
	
	
	
	//LOGICA DEL PROGRAMA 
//	@GetMapping("/devolverlibro/{idprestamo}")
//	public String devolverLibro(@PathVariable("idprestamo") long idprestamo, @RequestParam("fechaDevolucion") LocalDate fechaDevolucion) {
//	    Prestamo prestamo = prestamoservice.getById(idprestamo);
//	    Lector lector = prestamo.getLector();
//	    
//	    LocalDate fechaDevolucionEsperada = prestamo.getFechaDevolucionEsperada();
//	    int diasDeRetraso = calcularDiasDeRetraso(fechaDevolucionEsperada, fechaDevolucion);
//	    int tasaSancionDiaria = 2; 
//	    int sancion = diasDeRetraso * tasaSancionDiaria;
//
//	    // Verificar si el lector tiene una multa
//	    List<Multa> multas = MultaService.obtenerMultasPorLector(lector);
//	    if (!multas.isEmpty()) {
//	        // Actualizar la multa existente
//	        Multa multa = multas.get(0);
//	        multa.setFFin(multa.getFFin().plusDays(sancion)); // Extender la fecha de finalización de la multa
//	        multa.setTiempoMultado(multa.getTiempoMultado() + sancion);
//	        multaService.actualizarMulta(multa);
//	    } else {
//	        // Crear una nueva multa
//	        Multa multa = new Multa();
//	        multa.setFInicio(LocalDate.now());
//	        multa.setFFin(LocalDate.now().plusDays(sancion));
//	        multa.setTiempoMultado(sancion);
//	        multa.setLector(lector);
//	        multaService.crearMulta(multa);
//	    }
//	    
//	    // Restringir el alquiler de nuevos libros si hay una sanción pendiente
//	    if (!multas.isEmpty() && multas.get(0).getFFin().isAfter(LocalDate.now())) {
//	        return "redirect:/mensajeSancion"; // Mostrar un mensaje de sanción
//	    }
//	    
//	    // Lógica para la devolución del libro y actualización de la base de datos
//
//	    return "redirect:/prestamos/" + lector.getIdlector();
//	}
//
//	private int calcularDiasDeRetraso(LocalDate fechaDevolucionEsperada, LocalDate fechaDevolucion) {
//	    if (fechaDevolucionEsperada != null && fechaDevolucion != null) {
//	        return (int) ChronoUnit.DAYS.between(fechaDevolucionEsperada, fechaDevolucion);
//	    } else {
//	        return 0;
//	    }
//	}
}
