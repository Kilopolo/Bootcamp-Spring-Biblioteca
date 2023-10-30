package com.capgemini.bibliotecaSpring.repositorio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.bibliotecaSpring.model.User;

public interface UsersRepository extends JpaRepository<User, Long> {
	Page<User> findAll(Pageable pageable);

	User findByEmail(String email);
}