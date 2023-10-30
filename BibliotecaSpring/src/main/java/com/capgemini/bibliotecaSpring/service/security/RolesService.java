package com.capgemini.bibliotecaSpring.service.security;

import org.springframework.stereotype.Service;

@Service
public class RolesService {
	String[] roles = { "USER", "ADMIN" };

	public String[] getRoles() {
		return roles;
	}
}