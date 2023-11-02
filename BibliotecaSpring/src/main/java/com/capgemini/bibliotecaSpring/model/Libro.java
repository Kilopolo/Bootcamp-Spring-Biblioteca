package com.capgemini.bibliotecaSpring.model;

import java.util.List;

import com.capgemini.bibliotecaSpring.enumerados.TipoLibro;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "libros")
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
	@Enumerated(value = EnumType.STRING)
	private TipoLibro tipo;
	@Column
	private int anyo;
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "idautor")
	private Autor autor;
	@OneToMany(mappedBy = "libro", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@JsonBackReference
	private List<Copia> copias;

}
