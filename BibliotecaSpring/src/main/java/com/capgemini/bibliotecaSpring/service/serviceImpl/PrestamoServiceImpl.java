package com.capgemini.bibliotecaSpring.service.serviceImpl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bibliotecaSpring.enumerados.EstadoCopia;
import com.capgemini.bibliotecaSpring.model.Copia;
import com.capgemini.bibliotecaSpring.model.Lector;
import com.capgemini.bibliotecaSpring.model.Multa;
import com.capgemini.bibliotecaSpring.model.Prestamo;
import com.capgemini.bibliotecaSpring.repositorio.MultaRepositorio;
import com.capgemini.bibliotecaSpring.repositorio.PrestamoRepositorio;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.PrestamoService;

@Service
public class PrestamoServiceImpl extends ServiceImpl<PrestamoRepositorio, Prestamo> implements PrestamoService {

	@Autowired
	PrestamoRepositorio pr;
	@Autowired
	MultaRepositorio mr;

	@Override
	public List<Prestamo> findByLector(Lector lector) {
		// TODO Auto-generated method stub
		return pr.findByLector(lector);
	}

	public LocalDate getFechaDevolucionEsperada(LocalDate fechaInicio) {
		if (fechaInicio != null) {
			return fechaInicio.plusDays(30);
		} else {
			return fechaInicio;
		}
	}

	public Prestamo guardar(Prestamo prestamo) {
		Copia copia = prestamo.getCopia();
		copia.setEstado(EstadoCopia.PRESTADO);
		LocalDate fechaInicio = LocalDate.now();
		LocalDate fechaFin = LocalDate.now().plusDays(30);
		prestamo.setFechaInicio(fechaInicio);
		prestamo.setFechaFin(fechaFin);
		return pr.save(prestamo);
	}

	@Override
	public void borrar(Prestamo prestamo) {
		Copia copia = prestamo.getCopia();
		copia.setEstado(EstadoCopia.BIBLIOTECA);
		deleteById(prestamo.getIdprestamo());

	}

	// Devuelve el libro a la biblioteca si está en plazo y cambia el estado de la
	// copia
	// Si esta restrasado cambia el estado de la copia
	@Override
	public void devolver(Prestamo prestamo) {
		Copia copia = prestamo.getCopia();
		LocalDate fechaDevuelta = LocalDate.now();
		LocalDate FechaPrevista = prestamo.getFechaFin();
		int dias = (int) ChronoUnit.DAYS.between(FechaPrevista, fechaDevuelta);
		if (copia.getEstado() == EstadoCopia.PRESTADO) {
			if (dias > 0) {
				prestamo.setFechaFin(fechaDevuelta);
				multar(prestamo.getLector(), dias);
			}
			copia.setEstado(EstadoCopia.BIBLIOTECA);
			prestamo.setFechaFin(fechaDevuelta);
			pr.save(prestamo);
		} else {
			System.out.println("Error");
		}
	}

	// Multar
	public void multar(Lector lector, int dias) {
		LocalDate fechaInicio = LocalDate.now();
		LocalDate fechaFinMulta = fechaInicio.plusDays(dias);
		Multa multa = new Multa();
		multa.setFInicio(fechaInicio);
		multa.setFFin(fechaFinMulta);
		multa.setLector(lector);
		mr.save(multa);

	}
}
