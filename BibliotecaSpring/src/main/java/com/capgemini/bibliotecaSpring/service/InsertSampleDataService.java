package com.capgemini.bibliotecaSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.capgemini.bibliotecaSpring.model.User;
import com.capgemini.bibliotecaSpring.service.security.RolesService;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.LectorService;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.UserService;

import jakarta.annotation.PostConstruct;

@Service
public class InsertSampleDataService {
	@Autowired
	private UserService usersService;

	@Autowired
	private RolesService rolesService;

	@Autowired
	private LectorService lectorService;
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	@PostConstruct
	public void init() {

		/**al parecer si que funciona**/
		User admin = new User();
		admin.setEmail("admin@gmail.com");
		admin.setPassword(bCryptPasswordEncoder.encode("1234"));
		admin.setRole(rolesService.getRoles()[1]);
		usersService.save(admin);

		User user = new User();
		user.setEmail("user@gmail.com");
		user.setPassword(bCryptPasswordEncoder.encode("1234"));
		user.setRole(rolesService.getRoles()[0]);
		user.setLector(lectorService.getById(1));
		usersService.save(user);

	}

}