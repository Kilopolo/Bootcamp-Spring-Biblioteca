package com.capgemini.Biblioteca.model;

import com.capgemini.Biblioteca.enumerado.TipoLibro;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="libros")
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long idlibro;
	@Column
	private String titulo;
	@Column
	private String editorial;
	@Column
	private TipoLibro tipo;
	@Column
	private int anyo;
	
}