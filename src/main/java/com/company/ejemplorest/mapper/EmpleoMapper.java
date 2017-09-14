package com.company.ejemplorest.mapper;

import org.springframework.stereotype.Component;

import com.company.ejemplorest.model.Empleo;

@Component
public class EmpleoMapper {
	
	public com.company.ejemplorest.entity.Empleo fromModel2Entity(Empleo empleoModel){
		com.company.ejemplorest.entity.Empleo empleo = new com.company.ejemplorest.entity.Empleo();
		empleo.setIdEmpleo(empleoModel.getIdEmpleo());
		empleo.setNombreEmpleo(empleoModel.getNombreEmpleo());
		empleo.setEmpresa(empleoModel.getEmpresa());
		empleo.setSector(empleoModel.getSector());
		empleo.setFechaInicio(empleoModel.getFechaInicio());
		empleo.setFechaFin(empleoModel.getFechaFin());
		return empleo;
	}
	
	public Empleo  fromEntity2Model(com.company.ejemplorest.entity.Empleo  empleoEntity){
		Empleo empleo = new Empleo();
		empleo.setIdEmpleo(empleoEntity.getIdEmpleo());
		empleo.setNombreEmpleo(empleoEntity.getNombreEmpleo());
		empleo.setEmpresa(empleoEntity.getEmpresa());
		empleo.setSector(empleoEntity.getSector());
		empleo.setFechaInicio(empleoEntity.getFechaInicio());
		empleo.setFechaFin(empleoEntity.getFechaFin());
		return empleo;
	}
}
