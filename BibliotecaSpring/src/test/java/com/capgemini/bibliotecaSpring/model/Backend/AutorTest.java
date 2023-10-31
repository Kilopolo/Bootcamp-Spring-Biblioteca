package com.capgemini.bibliotecaSpring.model.Backend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.bibliotecaSpring.enumerados.EstadoCopia;
import com.capgemini.bibliotecaSpring.model.Copia;
import com.capgemini.bibliotecaSpring.model.Lector;
import com.capgemini.bibliotecaSpring.repositorio.CopiaRepositorio;
import com.capgemini.bibliotecaSpring.repositorio.LectorRepositorio;
import com.capgemini.bibliotecaSpring.repositorio.PrestamoRepositorio;
import com.capgemini.bibliotecaSpring.service.serviceImpl.LectorServiceImpl;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.AutorService;

@SpringBootTest
class AutorTest {
	 @InjectMocks
	    private LectorServiceImpl lectorService;

	    @Mock
	    private LectorRepositorio lectorRepositorio;

	    @Mock
	    private CopiaRepositorio copiaRepositorio;

	    @Mock
	    private PrestamoRepositorio prestamoRepositorio;

	@Autowired
	AutorService autorservice;
	
	@BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

	/*
	 * @BeforeAll static void setUpBeforeClass() throws Exception { }
	 *
	 * @AfterAll static void tearDownAfterClass() throws Exception { }
	 *
	 * @BeforeEach void setUp() throws Exception { }
	 *
	 * @AfterEach void tearDown() throws Exception { }
	 */

//	@Test
//	void testFindById() {
//		System.out.println("Test 1: " + autorservice.getById(1L).getNombre());
//		Autor autor = autorservice.getById(1L);
//		assertEquals("Bram Stoker", autor.getNombre());
//	}

//	@Test
//	void testSave() {
//		Autor autor = new Autor(10L, "Cervantes", "Española", LocalDate.of(1547, 9, 29), new ArrayList<Libro>());
//		autorservice.save(autor);
//		assertEquals("Cervantes", autor.getNombre());
//		System.out.println("Test 2: " + autorservice.getById(10L).getNombre());
//	}

//	@Test
//	void testDeleteById() {
//		Autor autor = autorservice.getById(10L);
//		autorservice.deleteById(autor.getIdautor());
//		assertEquals(10L, autor.getIdautor());
//		System.out.println("Test 3: " + autor.getNombre());
//	}
	
	 @Test
	    public void testPrestar() {
	        Lector lector = new Lector(); // Aquí debes completar con los atributos necesarios
	        lector.setIdlector(1l); // Id de ejemplo

	        Copia copia = new Copia(); // Aquí debes completar con los atributos necesarios
	        copia.setEstado(EstadoCopia.BIBLIOTECA); // Establecer el estado de la copia

	        when(lectorRepositorio.findById(1l)).thenReturn(Optional.of(lector));
	        when(copiaRepositorio.save(copia)).thenReturn(copia);
	        // Puedes continuar con el mock y la simulación de otros métodos necesarios

	        LocalDate fechaActual = LocalDate.now(); // Puedes establecer una fecha actual
	        lectorService.prestar(1, fechaActual, copia);

	        // Aquí puedes agregar aserciones para comprobar el resultado esperado
	        assertEquals(EstadoCopia.PRESTADO, copia.getEstado()); // Verificar si la copia está prestada
	        // Puedes añadir más aserciones dependiendo de la lógica que quieras validar
	    }

}