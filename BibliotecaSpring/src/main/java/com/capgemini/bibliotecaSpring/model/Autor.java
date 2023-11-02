package com.capgemini.bibliotecaSpring.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "autores")
public class Autor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long idautor;
	@Column
	private String nombre;
	@Column
	private String nacionalidad;
	@Column(name = "fecNac")
	private LocalDate fechaNacimiento;
	@OneToMany(mappedBy = "autor", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@JsonBackReference
	private List<Libro> Libros;

}
