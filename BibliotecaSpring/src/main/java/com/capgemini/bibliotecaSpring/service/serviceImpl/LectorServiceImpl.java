package com.capgemini.bibliotecaSpring.service.serviceImpl;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.capgemini.bibliotecaSpring.model.Copia;
import com.capgemini.bibliotecaSpring.model.Lector;
import com.capgemini.bibliotecaSpring.repositorio.LectorRepositorio;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.LectorService;

@Service
public class LectorServiceImpl extends ServiceImpl<LectorRepositorio, Lector> implements LectorService {

	private final int MAX_LIBROS = 3;
	private static final int DIAS_MULTA = 0;
	private static final int MAX_COPIAS = 3;
	@Autowired
	public LectorRepositorio lectorrepo;
	@Autowired
	public MultaRepositorio multarepo;
	@Autowired
	public PrestamoRepositorio prestamorepo;
	@Autowired
	public PrestamoService prestamoservice;
	@Autowired
	public CopiaRepositorio copiarepo;

	@Override
	public void devolver(long id, LocalDate fechaDevuelto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void prestar(long id, LocalDate fechaAct, Copia copia) {
		// TODO Auto-generated method stub

	}

	@Override
	public void multar(long idLector, int diasRetraso) {
		// TODO Auto-generated method stub

	}

	/*
	 * private static final int DIAS_MULTA = 0; private static final int MAX_COPIAS
	 * = 3;
	 * 
	 * @Autowired public LectorRepositorio lectorrepo;
	 * 
	 * @Autowired public MultaRepositorio multarepo;
	 * 
	 * @Autowired public PrestamoRepositorio prestamorepo;
	 * 
	 * @Autowired public PrestamoService prestamoservice;
	 * 
	 * @Autowired public CopiaRepositorio copiarepo;
	 * 
	 * private final int MAX_LIBROS = 3;
	 * 
	 * 
	 * @Override public void devolver(long id, LocalDate date) { // TODO
	 * Auto-generated method stub
	 * 
	 * 
	 * if (lectorOptional.isPresent()) { Lector lector = lectorOptional.get();
	 * List<Prestamo> prestamos=lector.getPrestamosLector(); Prestamo
	 * prestamoADevolver = encontrarPrestamoPorNSocio(prestamos, id);
	 * 
	 * if (prestamoADevolver != null) {
	 * prestamoADevolver.setFechaFin(fechaDevuelto);
	 * prestamos.remove(prestamoADevolver); lectorrepo.save(lector);
	 * prestamoservice.deleteById(id); } } else { throw new
	 * LectorNotFoundException(id); } }
	 * 
	 * private Prestamo encontrarPrestamoPorNSocio(List<Prestamo> prestamos, Long
	 * nSocio) { for (Prestamo prestamo : prestamos) { Lector lector =
	 * prestamo.getLector(); if (lector != null &&
	 * lector.getIdlector().equals(nSocio)) { return prestamo; } } return null; }
	 * 
	 * 
	 * @Override public void prestar(long id, LocalDate fechaAct,Copia copia) {
	 * Optional<Lector> lectorOptional = lectorrepo.findById(id);
	 * 
	 * if (lectorOptional.isPresent()) { Lector lector = lectorOptional.get(); Libro
	 * libro = copia.getLibro();
	 * 
	 * if (isAvailableCopia(copia, lector) && isNotMoroso(lector)) {
	 * copia.setEstado(EstadoCopia.PRESTADO); Prestamo nuevoPrestamo = new
	 * Prestamo(); nuevoPrestamo.setIdprestamo(50l);
	 * nuevoPrestamo.setFechaInicio(fechaAct);
	 * nuevoPrestamo.setFechaFin(fechaAct.plusDays(30));
	 * nuevoPrestamo.setLector(lector); nuevoPrestamo.setCopia(copia);
	 * System.out.println(nuevoPrestamo); prestamoservice.save(nuevoPrestamo);
	 * System.out.println(prestamoservice.getAll()); copiarepo.save(copia); //return
	 * nuevoPrestamo; } else { throw new MaximoLibrosPrestadosException(); } } else
	 * { throw new LectorNotFoundException(id); } }
	 * 
	 * private boolean isAvailableCopia(Copia copia, Lector lector) { return
	 * copia.getEstado() == EstadoCopia.BIBLIOTECA; }
	 * 
	 * private boolean isNotMoroso(Lector lector) { Multa multa = lector.getMulta();
	 * return multa == null || multa.getFFin() == null ||
	 * multa.getFFin().isBefore(LocalDate.now());
	 * 
	 * }
	 * 
	 * @Override public void multar(long idLector, int diasRetraso) { // TODO
	 * Auto-generated method stub
	 * 
	 * }
	 */

}
