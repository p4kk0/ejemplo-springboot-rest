package com.company.ejemplorest.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "EMPLEO")
public class Empleo {

	@Id
	@GeneratedValue
	@Column(name = "ID_EMPLEO")
	private Integer idEmpleo;

	@Column(name = "NOMBRE_EMPLEO", nullable = false, length = 100)
	private String nombreEmpleo;

	@Column(name = "EMPRESA", nullable = false, length = 100)
	private String empresa;

	@Column(name = "SECTOR", nullable = false, length = 100)
	private String sector;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHA_INICIO")
	private Date fechaInicio;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHA_FIN")
	private Date fechaFin;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_PERSONA", nullable = false)
	private Persona persona;

	public Empleo() {
		super();
	}

	public Empleo(Integer idEmpleo) {
		super();
		this.idEmpleo = idEmpleo;
	}

	public Empleo(Integer idEmpleo, String nombreEmpleo, String empresa, String sector, Date fechaInicio, Date fechaFin,
			Persona persona) {
		super();
		this.idEmpleo = idEmpleo;
		this.nombreEmpleo = nombreEmpleo;
		this.empresa = empresa;
		this.sector = sector;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.persona = persona;
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

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}
