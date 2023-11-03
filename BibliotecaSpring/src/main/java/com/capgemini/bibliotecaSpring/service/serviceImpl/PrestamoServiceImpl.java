package com.capgemini.bibliotecaSpring.service.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bibliotecaSpring.enumerados.EstadoCopia;
import com.capgemini.bibliotecaSpring.model.Copia;
import com.capgemini.bibliotecaSpring.model.Lector;
import com.capgemini.bibliotecaSpring.model.Prestamo;
import com.capgemini.bibliotecaSpring.repositorio.PrestamoRepositorio;
import com.capgemini.bibliotecaSpring.service.serviceInterfaces.PrestamoService;

@Service
public class PrestamoServiceImpl extends ServiceImpl<PrestamoRepositorio, Prestamo> implements PrestamoService {

	@Autowired
	PrestamoRepositorio pr;

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
		LocalDate fechaInicio=LocalDate.now();
		LocalDate fechaFin=LocalDate.now().plusDays(30);
		prestamo.setCopia(copia);
		prestamo.setFechaInicio(fechaInicio);
		prestamo.setFechaFin(fechaFin);
		return pr.save(prestamo);
	}

	@Override
	public void borrar(Prestamo prestamo) {
		Copia copia = prestamo.getCopia();
		copia.setEstado(EstadoCopia.BIBLIOTECA);
		deleteById(prestamo.getIdprestamo());;
	}
	

}
