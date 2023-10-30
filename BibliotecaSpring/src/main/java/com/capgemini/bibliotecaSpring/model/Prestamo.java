package com.capgemini.bibliotecaSpring.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="prestamos")
public class Prestamo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long idprestamo;
	@Column
	private LocalDate fechaInicio;
	@Column
	private LocalDate fechaFin;
	@ManyToOne
	@JoinColumn(name="idcopia")
	private Copia copia;
	@ManyToOne
	@JoinColumn(name="nSocio")
	private Lector lector;
	
	public LocalDate getFechaDevolucionEsperada() {
	    if (fechaInicio != null) {
	        return fechaInicio.plusDays(30);
	    } else {
	        return fechaFin; 
	    }
	}


}
