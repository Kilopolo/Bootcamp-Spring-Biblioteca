package com.capgemini.bibliotecaSpring.service.serviceImpl;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bibliotecaSpring.enumerados.EstadoCopia;
import com.capgemini.bibliotecaSpring.exceptions.LectorNotFoundException;
import com.capgemini.bibliotecaSpring.exceptions.MaximoLibrosPrestadosException;
import com.capgemini.bibliotecaSpring.model.Copia;
import com.capgemini.bibliotecaSpring.model.Lector;
import com.capgemini.bibliotecaSpring.model.Libro;
import com.capgemini.bibliotecaSpring.model.Multa;
import com.capgemini.bibliotecaSpring.model.Prestamo;
import com.capgemini.bibliotecaSpring.repositorio.CopiaRepositorio;
import com.capgemini.bibliotecaSpring.repositorio.LectorRepositorio;
import com.capgemini.bibliotecaSpring.repositorio.MultaRepositorio;
import com.capgemini.bibliotecaSpring.repositorio.PrestamoRepositorio;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.LectorService;

@Service
public class LectorServiceImpl extends ServiceImpl<LectorRepositorio, Lector> implements LectorService {

	private static final int DIAS_MULTA = 0;
	private static final int MAX_COPIAS = 3;
	@Autowired
	public LectorRepositorio lectorrepo;
	@Autowired
	public MultaRepositorio multarepo;
	@Autowired
	public PrestamoRepositorio prestamorepo;
	@Autowired
	public CopiaRepositorio copiarepo;

	@Override
	public void devolver(Lector lector, long idprestamo) {
		List<Prestamo> prestamos = prestamorepo.findByLector(lector);
		Prestamo prestamoADevolver = encontrarPrestamoPorNSocio(prestamos, lector.getIdlector());
		LocalDate fechaDevuelta = LocalDate.now();
		LocalDate fechaPrevista= prestamoADevolver.getFechaFin();
		Period periodo = fechaPrevista.until(fechaDevuelta);
		int diasRetraso = periodo.getDays();
		if (diasRetraso > 0) {
			prestamoADevolver.setFechaFin(LocalDate.now());
//			if(prestamorepo.restraso(prestamoADevolver)) {
				multar(lector.getIdlector(), prestamoADevolver);
//			}
				
			Copia copia = prestamoADevolver.getCopia();
			copia.setEstado(EstadoCopia.BIBLIOTECA);
			prestamos.remove(prestamoADevolver);
			lectorrepo.save(lector);
			prestamorepo.delete(prestamoADevolver);
		
	}

	private Prestamo encontrarPrestamoPorNSocio(List<Prestamo> prestamos, Long nSocio) {
		for (Prestamo prestamo : prestamos) {
			Lector lector = prestamo.getLector();
			if (lector != null && lector.getIdlector().equals(nSocio)) {
				return prestamo;
			}
		}
		return null;
	}

	@Override
	public void prestar(long id, LocalDate fechaAct, Copia copia) {
		Optional<Lector> lectorOptional = lectorrepo.findById(id);

		if (lectorOptional.isPresent()) {
			Lector lector = lectorOptional.get();
			Libro libro = copia.getLibro();
 
			if (isAvailableCopia(copia, lector) && isNotMoroso(lector)) {
				copia.setEstado(EstadoCopia.PRESTADO);

				Prestamo nuevoPrestamo = new Prestamo();
				nuevoPrestamo.setIdprestamo(50l);
				nuevoPrestamo.setFechaInicio(fechaAct);
				nuevoPrestamo.setFechaFin(fechaAct.plusDays(30));
				nuevoPrestamo.setLector(lector);
				nuevoPrestamo.setCopia(copia);

				System.out.println(nuevoPrestamo);
				prestamorepo.save(nuevoPrestamo);
				System.out.println(prestamorepo.findAll());
				copiarepo.save(copia);
				// return nuevoPrestamo;
			} else {
				throw new MaximoLibrosPrestadosException();
			}
		} else {
			throw new LectorNotFoundException(id);
		}
	}

	private boolean isAvailableCopia(Copia copia, Lector lector) {
		return copia.getEstado() == EstadoCopia.BIBLIOTECA;
	}

	private boolean isNotMoroso(Lector lector) {
		Multa multa = lector.getMulta();
		return multa == null || multa.getFFin() == null || multa.getFFin().isBefore(LocalDate.now());
	}

	@Override
	public void multar(long idLector, Prestamo prestamo) {
		LocalDate fechaDevuelta = LocalDate.now();
		LocalDate fechaPrevista= prestamo.getFechaFin();
		Period periodo = fechaPrevista.until(fechaDevuelta);
		int diasRetraso = periodo.getDays();
		if (diasRetraso > 0) {
			Optional<Lector> lector = lectorrepo.findById(idLector);
			Copia copia= prestamo.getCopia();
			copia.setEstado(EstadoCopia.RETRASO);
			if (lector.isPresent()) {
				Lector l = lector.get();
				int numLibrosPrestados = l.getPrestamosLector().size();
				if (numLibrosPrestados >= DIAS_MULTA) {
					LocalDate fechaInicio = LocalDate.now();
					LocalDate fechaFinMulta = fechaInicio.plusDays(diasRetraso);

					Multa multa = new Multa();
					multa.setFInicio(fechaInicio);
					multa.setFFin(fechaFinMulta);
					multa.setLector(l);
					multarepo.save(multa);
				}
			}
		}
	}

}
