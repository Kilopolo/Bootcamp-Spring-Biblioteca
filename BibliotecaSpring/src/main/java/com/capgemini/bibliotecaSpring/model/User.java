package com.capgemini.bibliotecaSpring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Inheritance (strategy=InheritanceType.JOINED)
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue
	private long id;
	@Column//(unique = true)
	private String email;
	@Column
	private String password;
	/*
	 * @Transient private String passwordConfirm;
	 * 
	 * private String role;
	 * 
	 * @Transient private boolean selected = false;
	 */



	


}
