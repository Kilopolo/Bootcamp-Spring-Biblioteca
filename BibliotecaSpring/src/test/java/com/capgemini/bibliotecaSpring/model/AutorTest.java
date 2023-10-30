package com.capgemini.bibliotecaSpring.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.bibliotecaSpring.service.AutorService;
@SpringBootTest
class AutorTest {
	@Autowired
	AutorService autorservice;

	/*
	 * @BeforeAll static void setUpBeforeClass() throws Exception { }
	 * 
	 * @AfterAll static void tearDownAfterClass() throws Exception { }
	 * 
	 * @BeforeEach void setUp() throws Exception { }
	 * 
	 * @AfterEach void tearDown() throws Exception { }
	 */

	@Test
	void test1() {
		System.out.println(autorservice.getById(1L).getNombre());
		Autor autor = autorservice.getById(1L);
		assertEquals("Bram Stoker",autor.getNombre());
	}

}
