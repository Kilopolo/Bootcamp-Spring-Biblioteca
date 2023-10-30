package com.capgemini.bibliotecaSpring.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lectores")
public class Lector {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nSocio")
	private Long idlector;
	@Column
	private String nombre;
	@Column
	private String telefono;
	@Column
	private String direccion;
	@OneToMany(mappedBy = "lector", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<Prestamo> prestamosLector;
	@OneToOne(mappedBy = "lector", fetch = FetchType.LAZY)
	private Multa multa;
}
