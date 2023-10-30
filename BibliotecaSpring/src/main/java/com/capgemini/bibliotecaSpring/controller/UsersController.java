package com.capgemini.bibliotecaSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.capgemini.bibliotecaSpring.model.Lector;
import com.capgemini.bibliotecaSpring.model.User;
import com.capgemini.bibliotecaSpring.service.security.RolesService;
import com.capgemini.bibliotecaSpring.service.security.SecurityService;
import com.capgemini.bibliotecaSpring.service.serviceImpl.UsersServiceImpl;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.LectorService;
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
	private LectorService lectorService;
	
	// GESTION DE LOGIN/REGISTRO

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(@ModelAttribute @Validated User user, BindingResult result) {

		// TODO validar datos
//		signUpFormValidator.validate(user, result);
//		if (result.hasErrors()) {
//			return "signup";
//		}
		Lector l = new Lector("no-name", "no-phone", "no-direction");
		lectorService.save(l);
		Lector last = lectorService.getAll().getLast();
		//Asigno rol usuario
		user.setRole(rolesService.getRoles()[0]);
		user.setLector(last);
		
		usersServiceImpl.addUser(user);
		
		System.out.println(""+l.toString());
		securityService.autoLogin(user.getEmail(), user.getPasswordConfirm());
		return "redirect:/home";
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

}