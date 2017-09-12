package com.company.ejemplorest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERSONA")
public class Persona {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;

	@Column(name = "NOMBRE", nullable = false, length = 100)
	private String nombre;

	@Column(name = "APELLIDOS", length = 200)
	private String apellidos;

	@Column(name = "EDAD")
	private Integer edad;

	@Column(name = "GAY")
	private boolean gay;

	public Persona() {
		super();
	}

	public Persona(Integer id, String nombre, String apellidos, int edad, boolean gay) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.gay = gay;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public boolean isGay() {
		return gay;
	}

	public void setGay(boolean gay) {
		this.gay = gay;
	}
}
