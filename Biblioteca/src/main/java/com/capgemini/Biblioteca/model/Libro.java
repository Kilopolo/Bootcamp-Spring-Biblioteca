package com.capgemini.Biblioteca.model;

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
	private int anyo;
	
}
