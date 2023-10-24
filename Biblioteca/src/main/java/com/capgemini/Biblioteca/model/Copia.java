package com.capgemini.Biblioteca.model;

import com.capgemini.Biblioteca.enumerado.EstadoCopia;
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
@Table(name="copias")
public class Copia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long idcopia;
	@Column
	private EstadoCopia estado;
}
