package com.capgemini.bibliotecaSpring.service.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bibliotecaSpring.Exceptions.LectorNotFoundException;
import com.capgemini.bibliotecaSpring.Exceptions.MaximoLibrosPrestadosException;
import com.capgemini.bibliotecaSpring.model.Lector;
import com.capgemini.bibliotecaSpring.model.Multa;
import com.capgemini.bibliotecaSpring.model.Prestamo;
import com.capgemini.bibliotecaSpring.repositorio.LectorRepositorio;
import com.capgemini.bibliotecaSpring.repositorio.MultaRepositorio;
import com.capgemini.bibliotecaSpring.repositorio.PrestamoRepositorio;
import com.capgemini.bibliotecaSpring.service.LectorService;
import com.capgemini.bibliotecaSpring.service.PrestamoService;

@Service
public class LectorServiceImpl extends ServiceImpl<LectorRepositorio, Lector> implements LectorService {

	private static final int DIAS_MULTA = 0;
	private static final int MAX_LIBROS = 3;
	@Autowired
	public LectorRepositorio lectorrepo;
	@Autowired
	public MultaRepositorio multarepo;
	@Autowired
	public PrestamoRepositorio prestamorepo;
	@Autowired
	public PrestamoService prestamoservice;

	@Override
	public void devolver(long id, LocalDate fechaDevuelto) {
	    Optional<Lector> lectorOptional = lectorrepo.findById(id);

	    if (lectorOptional.isPresent()) {
	        Lector lector = lectorOptional.get();
	        List<Prestamo> prestamos=lector.getPrestamosLector();
	        Prestamo prestamoADevolver = encontrarPrestamoPorNSocio(prestamos, id);

	        if (prestamoADevolver != null) {
	            prestamoADevolver.setFechaFin(fechaDevuelto);
	            prestamos.remove(prestamoADevolver);
	            lectorrepo.save(lector);
	            prestamoservice.deleteById(id);
	        }
	    } else {
	    	throw new LectorNotFoundException(id);
	    }
	}

	// Método de ejemplo para encontrar un préstamo basado en algún criterio, ajusta esto según tus necesidades.
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
	public void prestar(long id, LocalDate fechaAct) {
	    Optional<Lector> lector = lectorrepo.findById(id);
	    if (lector.isPresent()) {
	        Lector l = lector.get();
	        int numLibrosPrestados = l.getPrestamosLector().size();
	        if (numLibrosPrestados < MAX_LIBROS) {
	            Prestamo nuevoPrestamo = new Prestamo();
	            nuevoPrestamo.setFechaInicio(fechaAct);
	            nuevoPrestamo.setLector(l);
	            prestamorepo.save(nuevoPrestamo);
	        } else {
	        	throw new MaximoLibrosPrestadosException();
	        }
	    }
	}

	@Override
	public void multar(long idLector, int diasRetraso) {
	    if (diasRetraso > 0) {
	        Optional<Lector> lector = lectorrepo.findById(idLector);
	        if (lector.isPresent()) {
	        	Lector l=lector.get();
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
