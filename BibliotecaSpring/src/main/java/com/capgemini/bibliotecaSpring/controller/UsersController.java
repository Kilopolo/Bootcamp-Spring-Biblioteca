package com.capgemini.bibliotecaSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.capgemini.bibliotecaSpring.enumerados.EstadoCopia;
import com.capgemini.bibliotecaSpring.model.Copia;
import com.capgemini.bibliotecaSpring.model.Lector;
import com.capgemini.bibliotecaSpring.model.Prestamo;
import com.capgemini.bibliotecaSpring.model.User;
import com.capgemini.bibliotecaSpring.service.security.RolesService;
import com.capgemini.bibliotecaSpring.service.security.SecurityService;
import com.capgemini.bibliotecaSpring.service.serviceImpl.UsersServiceImpl;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.AutorService;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.CopiaService;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.LectorService;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.LibroService;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.PrestamoService;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.UserService;
import com.capgemini.bibliotecaSpring.validators.SignUpFormValidator;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController {

	@Autowired
	private UsersServiceImpl usersServiceImpl;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private SignUpFormValidator signUpFormValidator;

	@Autowired
	private RolesService rolesService;

	@Autowired
	private HttpSession httpSession;

	@Autowired
	LibroService libroservice;
	@Autowired
	AutorService autorservice;
	@Autowired
	LectorService lectorservice;
	@Autowired
	CopiaService copiaservice;
	@Autowired
	PrestamoService prestamoservice;
	@Autowired
	UserService userservice;
	
	// GESTION DE LOGIN/REGISTRO

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(@ModelAttribute @Validated User user, BindingResult result) {

		// TODO validar datos
//		signUpFormValidator.validate(user, result);
//		if (result.hasErrors()) {
//			return "signup";
//		}
		Lector lector = user.getLector();
		lectorservice.save(lector);
		// Asigno rol usuario
		user.setRole(rolesService.getRoles()[0]);
		user.setLector(lector);

		usersServiceImpl.addUser(user);

		System.out.println("" + lector.toString());
		securityService.autoLogin(user.getEmail(), user.getPasswordConfirm());
//		securityService.autoLogin(user.getEmail(), user.getPasswordConfirm());
		return "redirect:/login";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model) {
		model.addAttribute("user", new User());
		User activeUser = getActiveUser();
		httpSession.setAttribute("activeUser", activeUser);
		return "signup";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {

		return "login";
	}

	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public String home(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		User activeUser = usersServiceImpl.getUserByEmail(email);
		httpSession.setAttribute("activeUser", activeUser);

		return "home";
	}

	// GESTION DE USUARIOS

//	@RequestMapping(value = "/user/home")
//	public String getUserHome(Model model) {
//		model.addAttribute("rolesList", rolesService.getRoles());
//		User activeUser = getActiveUser();
//		model.addAttribute("user", activeUser);
//		return "user/home";
//	}

	private User getActiveUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		User activeUser = usersServiceImpl.getUserByEmail(email);
		return activeUser;
	}

	// PRESTAMO USER
	@GetMapping("/reservas")
	public String mostrarPrestamosUser(Model modelo) {
		User activeUser = getActiveUser();
		Lector lector = activeUser.getLector();
		modelo.addAttribute("lector", lector);
		modelo.addAttribute("prestamos", prestamoservice.findByLector(lector));
		return "prestamo/mostrarUser";
	}

	@PostMapping("/savereserva")
	public String savePrestamoUser(@ModelAttribute("prestamo") Prestamo prestamo, Model modelo) {
		User activeUser = getActiveUser();
		Lector lector = activeUser.getLector();
		prestamo.setLector(lector);
		Copia copia = prestamo.getCopia();
		copia.setEstado(EstadoCopia.PRESTADO);
		prestamo.setCopia(copia);
		prestamoservice.save(prestamo);
		modelo.addAttribute("lector", lector);
		return "redirect:/reservas";
	}

	@GetMapping("/addreserva")
	public String formPrestamoUser(Model modelo) {
		Prestamo prestamo = new Prestamo();
		User activeUser = getActiveUser();
		Lector lector = activeUser.getLector();
		modelo.addAttribute("lector", lector);
		modelo.addAttribute("prestamo", prestamo);
		modelo.addAttribute("copias", copiaservice.getAll());
		return "prestamo/addPrestamoUser";
	}

	// USER
	// LECTORES
	@GetMapping("/perfil")
	public String mostrarLectores(Model modelo) {
		User activeUser = getActiveUser();
		modelo.addAttribute("user", activeUser);
		return "lector/perfil";
	}
	@GetMapping("/updateperfil/{id}")
	public String updateLector(Model modelo, @PathVariable("id") long id) {
		User user = userservice.getById(id);
		modelo.addAttribute("user", user);
		return "lector/updatePerfil";
	}

}