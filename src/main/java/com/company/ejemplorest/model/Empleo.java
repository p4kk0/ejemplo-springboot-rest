package com.company.ejemplorest.model;

import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Empleo extends ResourceSupport{

	private Integer idEmpleo;
	private String nombreEmpleo;
	private String empresa;
	private String sector;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date fechaInicio;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date fechaFin;

	public Empleo() {
		super();
	}

	public Empleo(Integer idEmpleo, String nombreEmpleo, String empresa, String sector, Date fechaInicio,
			Date fechaFin) {
		super();
		this.idEmpleo = idEmpleo;
		this.nombreEmpleo = nombreEmpleo;
		this.empresa = empresa;
		this.sector = sector;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	public Integer getIdEmpleo() {
		return idEmpleo;
	}

	public void setIdEmpleo(Integer idEmpleo) {
		this.idEmpleo = idEmpleo;
	}

	public String getNombreEmpleo() {
		return nombreEmpleo;
	}

	public void setNombreEmpleo(String nombreEmpleo) {
		this.nombreEmpleo = nombreEmpleo;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}

}
