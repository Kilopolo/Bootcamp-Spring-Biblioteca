package com.capgemini.bibliotecaSpring.model.Backend;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.bibliotecaSpring.model.Autor;
import com.capgemini.bibliotecaSpring.model.Libro;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.AutorService;

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
	void testFindById() {
		System.out.println("Test 1: " + autorservice.getById(1L).getNombre());
		Autor autor = autorservice.getById(1L);
		assertEquals("Bram Stoker", autor.getNombre());
	}

	@Test
	void testSave() {
		Autor autor = new Autor(10L, "Cervantes", "Española", LocalDate.of(1547, 9, 29), new ArrayList<Libro>());
		autorservice.save(autor);
		assertEquals("Cervantes", autor.getNombre());
		System.out.println("Test 2: " + autorservice.getById(10L).getNombre());
	}

	@Test
	void testDeleteById() {
		Autor autor = autorservice.getById(10L);
		autorservice.deleteById(autor.getIdautor());
		assertEquals(10L, autor.getIdautor());
		System.out.println("Test 3: " + autor.getNombre());
	}

}