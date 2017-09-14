package com.company.ejemplorest.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PERSONA")
public class Persona {

	@Id
	@GeneratedValue
	@Column(name = "ID_PERSONA")
	private Integer idPersona;

	@Column(name = "NOMBRE", nullable = false, length = 100)
	private String nombre;

	@Column(name = "APELLIDOS", length = 200)
	private String apellidos;

	@Column(name = "EDAD")
	private Integer edad;

	@Column(name = "GAY")
	private boolean gay;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "persona")
	private List<Empleo> empleos;

	public Persona() {
		super();
	}

	public Persona(Integer idPersona) {
		super();
		this.idPersona = idPersona;
	}

	public Persona(Integer idPersona, String nombre, String apellidos, Integer edad, boolean gay, List<Empleo> empleos) {
		super();
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.gay = gay;
		this.empleos = empleos;
	}

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer id) {
		this.idPersona = id;
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

	public List<Empleo> getEmpleos() {
		return empleos;
	}

	public void setEmpleos(List<Empleo> empleos) {
		this.empleos = empleos;
	}

}
