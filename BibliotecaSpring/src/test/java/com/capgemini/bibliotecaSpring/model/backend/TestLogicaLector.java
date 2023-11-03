package com.capgemini.bibliotecaSpring.model.backend;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.capgemini.bibliotecaSpring.MainBiblioteca;
import com.capgemini.bibliotecaSpring.WebSecurityConfig;
import com.capgemini.bibliotecaSpring.model.User;
import com.capgemini.bibliotecaSpring.repositorio.CopiaRepositorio;
import com.capgemini.bibliotecaSpring.repositorio.LectorRepositorio;
import com.capgemini.bibliotecaSpring.repositorio.MultaRepositorio;
import com.capgemini.bibliotecaSpring.repositorio.PrestamoRepositorio;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.LectorService;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.PrestamoService;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.UserService;

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@ContextConfiguration(classes = { WebSecurityConfig.class, MainBiblioteca.class })
@AutoConfigureMockMvc
class TestLogicaLector {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MultaRepositorio multaRepositorio;

	@MockBean
	private LectorRepositorio lectorRepositorio;

	@MockBean
	private PrestamoRepositorio prestamoRepositorio;

	@MockBean
	private PrestamoService prestamoService;

	@MockBean
	private CopiaRepositorio copiaRepositorio;
	@MockBean
	private UserService userService;

	@MockBean
	private LectorService lectorService;

	/**
	 * @BeforeAll static void setUpBeforeClass() throws Exception { }
	 * 
	 * @AfterAll static void tearDownAfterClass() throws Exception { }
	 * 
	 * @BeforeEach void setUp() throws Exception { }
	 * 
	 * @AfterEach void tearDown() throws Exception { }
	 */
//	@Test
//	public void testPrestar() {
//		Lector lector = new Lector();
//		lector.setIdlector(1l);
//
//		Copia copia = new Copia();
//		copia.setIdcopia(44l);
//		copia.setEstado(EstadoCopia.BIBLIOTECA);
//
//		when(lectorRepositorio.findById(1l)).thenReturn(Optional.of(lector));
//		when(copiaRepositorio.save(copia)).thenReturn(copia);
//
//		LocalDate fechaActual = LocalDate.now();
//		lectorService.prestar(1l, fechaActual, copia);
//
//		assertEquals(EstadoCopia.PRESTADO, copia.getEstado());
//		System.out.println(copia); 
//	    lectorService.prestar(1l, fechaActual, copia);
//	    assertEquals(EstadoCopia.PRESTADO, copia.getEstado()); 
//	    System.out.println(copia);
//	}

//	 @Test
//	    public void testPrestar() {
//	        Lector lector = new Lector();
//	        lector.setIdlector(1l); 
//	        Copia copia = new Copia();
//	        copia.setIdcopia(44l);
//	        copia.setEstado(EstadoCopia.BIBLIOTECA); 
//	        when(lectorRepositorio.findById(1l)).thenReturn(Optional.of(lector));
//	        when(copiaRepositorio.save(copia)).thenReturn(copia);
//	        LocalDate fechaActual = LocalDate.now(); 
//	        lectorService.prestar(1l, fechaActual, copia);
//	        assertEquals(EstadoCopia.PRESTADO, copia.getEstado()); 
//	        System.out.println(copia);
//	    }

//	 @Test
//	 void testMultar() {
//		 Multa multa = new Multa(40l,LocalDate.now(),LocalDate.now().plusDays(10),null);
//		 User user=new User(33l,"ppe@gemeil.com","sextime","sextime","USER",false,null);
//		 Lector lector = new Lector();
//		 
//		    lector.setIdlector(20L);
//		    lector.setNombre("juanpedro");
//		    lector.setTelefono("657757665");
//		    lector.setDireccion("calle falsa");
//		    lector.setPrestamosLector(new ArrayList<Prestamo>());
//		    lector.setMulta(multa);
//		    lector.setUser(user);
//		    multa.setLector(lector);
//		    user.setLector(lector);
//
//		    // Simular préstamos con retraso
//		    Prestamo prestamo1 = new Prestamo();
//		    prestamo1.setFechaFin(LocalDate.now().minusDays(7)); 
//		    prestamo1.setIdprestamo(1l);
//		    Prestamo prestamo2 = new Prestamo();
//		    prestamo2.setIdprestamo(2l);
//		    prestamo2.setFechaFin(LocalDate.now().minusDays(5)); 
//		    Prestamo prestamo3 = new Prestamo();
//		    prestamo3.setIdprestamo(3l);
//		    prestamo3.setFechaFin(LocalDate.now().minusDays(3)); 
//		    Prestamo prestamo4 = new Prestamo();
//		    prestamo4.setIdprestamo(4l);
//		    prestamo4.setFechaFin(LocalDate.now().minusDays(2)); 
//		    
//		    List<Prestamo> prestamos = new ArrayList<>();
//		    prestamos.add(prestamo1);
//		    prestamos.add(prestamo2);
//		    prestamos.add(prestamo3);
//		    prestamos.add(prestamo4);
//		    lector.setPrestamosLector(prestamos);
//
//		    when(lectorRepositorio.findById(1L)).thenReturn(Optional.of(lector));
//
//		    int diasRetraso = 5;
//		    lectorService.multar(1L, diasRetraso);
//
//		    // Verificar si se ha generado la multa
//		    assertNotNull(lector.getMulta());
//		    System.out.println("Multa generada: " + lector.getMulta());
//		    System.out.println("Días de multa: " + diasRetraso);
//		}

//	 @Test
//	 void testPrestamoById() {
//		 Long nSocio = 8L;
//		 	
//		 	Lector socio = lectorService.getById(nSocio);
//		 	System.out.println(socio.toString());
//	        List<Prestamo> prestamos = lectorRepositorio.findPrestamosByNSocioAndEstadoBiblioteca(nSocio);
//	        for (Prestamo prestamo : socio.getPrestamosLector()) {
//				
//			}
//	    }

	@Test
	@WithMockUser(username = "admin@gmail.com", password = "1234", roles = { "ADMIN" })
	public void testGetAllUsers() throws Exception {
		User user = new User();
		user.setId(11l);
		user.setEmail("pepe@mail.pepe");
		user.setPassword("1234");
		when(userService.getById(11l)).thenReturn(user);
		System.out.println(userService.getById(11l).toString());
	}

}
