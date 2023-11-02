package com.capgemini.bibliotecaSpring.model.Backend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.capgemini.bibliotecaSpring.enumerados.EstadoCopia;
import com.capgemini.bibliotecaSpring.model.Copia;
import com.capgemini.bibliotecaSpring.model.Lector;
import com.capgemini.bibliotecaSpring.repositorio.CopiaRepositorio;
import com.capgemini.bibliotecaSpring.repositorio.LectorRepositorio;
import com.capgemini.bibliotecaSpring.repositorio.MultaRepositorio;
import com.capgemini.bibliotecaSpring.repositorio.PrestamoRepositorio;
import com.capgemini.bibliotecaSpring.service.serviceImpl.LectorServiceImpl;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.PrestamoService;


@ExtendWith(MockitoExtension.class)
class TestLogicaLector {
	
	@Mock
    private MultaRepositorio multaRepositorio;

	 @Mock
	    private LectorRepositorio lectorRepositorio;

    @Mock
    private PrestamoRepositorio prestamoRepositorio;

    @Mock
    private PrestamoService prestamoService;

    @Mock
    private CopiaRepositorio copiaRepositorio;

    @InjectMocks
    private LectorServiceImpl lectorService;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	 
	 
	 @Test
	    public void testPrestar() {
	        Lector lector = new Lector();
	        lector.setIdlector(1l); 

	        Copia copia = new Copia();
	        copia.setIdcopia(44l);
	        copia.setEstado(EstadoCopia.BIBLIOTECA); 

	        when(lectorRepositorio.findById(1l)).thenReturn(Optional.of(lector));
	        when(copiaRepositorio.save(copia)).thenReturn(copia);
	       

	        LocalDate fechaActual = LocalDate.now(); 
	        lectorService.prestar(1l, fechaActual, copia);

	        
	        assertEquals(EstadoCopia.PRESTADO, copia.getEstado()); 
	        System.out.println(copia);
	    }
	 
	 @Test
	    void testMultar() {
	        Lector lector = new Lector(); // Crear objeto Lector para la prueba
	        int diasRetraso = 5; // Establecer días de retraso

	        // Simular el comportamiento del repositorio y el objeto Lector
	        when(lectorRepositorio.findById(1L)).thenReturn(Optional.of(lector));
	        // Simular el resto de operaciones necesarias para el método multar

	        // Llamar al método multar
	        lectorService.multar(1L, diasRetraso);

	        // Verificar si el lector ha sido multado
	        assertNotNull(lector.getMulta()); // Ejemplo de aserción, ajustar según tu lógica
	    }

	 
}
