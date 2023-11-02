package com.capgemini.bibliotecaSpring.model;

import java.util.List;

import com.capgemini.bibliotecaSpring.enumerados.EstadoCopia;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Table(name = "copias")
public class Copia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long idcopia;
	@Column
	@Enumerated(value = EnumType.STRING)
	private EstadoCopia estado;
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "idlibro")
	private Libro libro;
	@OneToMany(mappedBy = "copia", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@JsonManagedReference
	private List<Prestamo> prestamosCopia;

}
