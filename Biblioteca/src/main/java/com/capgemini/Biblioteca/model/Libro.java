package com.capgemini.Biblioteca.model;

import com.capgemini.Biblioteca.enumerado.TipoLibro;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="libros")
public class Libro extends BaseEntity {
	@Column
	private String titulo;
	@Column
	private String editorial;
	@Column
	private TipoLibro tipo;
	@Column
	private int anyo;
	
}
