package com.company.ejemplorest.model;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.hateoas.ResourceSupport;

public class Persona extends ResourceSupport{

	private Integer idPersona;
	private String nombre;
	private String apellidos;
	private Integer edad;
	private boolean gay;

	public Persona() {
		super();
	}

	public Persona(Integer idPersona, String nombre, String apellidos, Integer edad, boolean gay, List<Empleo> empleos) {
		super();
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.gay = gay;
	}

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
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

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}

}
