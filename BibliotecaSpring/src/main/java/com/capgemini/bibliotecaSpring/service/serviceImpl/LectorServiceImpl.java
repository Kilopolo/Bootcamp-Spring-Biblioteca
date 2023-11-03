package com.capgemini.bibliotecaSpring.service.serviceImpl;

import java.time.LocalDate;
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
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.MultaService;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.PrestamoService;

@Service
public class LectorServiceImpl extends ServiceImpl<LectorRepositorio, Lector> implements LectorService {

	
	private static final int MULTA_POR_DIA_DE_RETRASO = 2;
    private static final int MAX_LIBROS_PRESTADOS = 3;
	@Autowired
	public LectorRepositorio lectorrepo;
	@Autowired
	public MultaRepositorio multarepo;
	@Autowired
	public MultaService multaService;
	@Autowired
	public PrestamoRepositorio prestamorepo;
	@Autowired
	public PrestamoService prestamoservice;
	@Autowired
	public LectorService lectorservice;
	@Autowired
	public CopiaRepositorio copiarepo;
	
	@Autowired
    public LectorServiceImpl(LectorRepositorio lectorrepo) {
        this.lectorrepo = lectorrepo;
    }
	
	public List<Prestamo> obtenerPrestamosPorNSocio(Long nSocio) {
        return lectorrepo.findPrestamosByNSocioAndEstadoBiblioteca(nSocio);
    }

	@Override
	public void devolver(long id, LocalDate fechaDevuelto) {
		Optional<Lector> lectorOptional = lectorrepo.findById(id);

		if (lectorOptional.isPresent()) {
			Lector lector = lectorOptional.get();
			List<Prestamo> prestamos = lector.getPrestamosLector();
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
//				nuevoPrestamo.setIdprestamo(50l);	que se autogenere
				nuevoPrestamo.setFechaInicio(LocalDate.now());
				nuevoPrestamo.setFechaFin(fechaAct.plusDays(30));
				nuevoPrestamo.setLector(lector);
				nuevoPrestamo.setCopia(copia);
				prestamoservice.save(nuevoPrestamo);
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
	public void multar(long idLector, int diasRetraso) {
		 Optional<Lector> lectorOptional = lectorrepo.findById(idLector);

	        if (lectorOptional.isPresent()) {
	            Lector lector = lectorOptional.get();
	            List<Prestamo> prestamos = lector.getPrestamosLector();  //ultimo de los prestados "DEVUELTO" el ultimo

	            int numLibrosPrestados = (prestamos != null) ? prestamos.size() : 0;

	            if (numLibrosPrestados >= MAX_LIBROS_PRESTADOS && diasRetraso > 0) {
	                LocalDate fechaInicio = LocalDate.now();
	                LocalDate fechaFinMulta = fechaInicio.plusDays(diasRetraso * MULTA_POR_DIA_DE_RETRASO);

	                lector.setMulta(new Multa(1L, fechaInicio, fechaFinMulta, lector)); // Suponiendo que existe una clase Multa

	                lectorrepo.save(lector);
	            }
	        } else {
	            throw new LectorNotFoundException(idLector);
	        }
	    }

}
