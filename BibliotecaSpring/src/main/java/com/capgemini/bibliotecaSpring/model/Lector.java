package com.capgemini.bibliotecaSpring.model;

import java.util.ArrayList;
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
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@PrimaryKeyJoinColumn(name="idLector")
@Table(name = "lectores")
public class Lector {

	public Lector(String nombre, String telefono, String direccion, List<Prestamo> prestamosLector, Multa multa,
			User user) {
		super();

		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.prestamosLector = prestamosLector;
		this.multa = multa;
		this.user = user;
	}

	public Lector(String nombre, String telefono, String direccion) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
	}

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
	@OneToOne(mappedBy = "lector")
	private User user;
}
