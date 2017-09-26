package com.company.ejemplorest.mapper;

import org.springframework.stereotype.Component;

import com.company.ejemplorest.model.Persona;

@Component
public class PersonaMapper {

	public com.company.ejemplorest.entity.Persona fromModel2Entity(Persona personaModel){
		com.company.ejemplorest.entity.Persona persona = new com.company.ejemplorest.entity.Persona();
		persona.setIdPersona(personaModel.getIdPersona());
		persona.setNombre(personaModel.getNombre());
		persona.setApellidos(personaModel.getApellidos());
		persona.setEdad(personaModel.getEdad());
		return persona;
	}
	
	public Persona  fromEntity2Model(com.company.ejemplorest.entity.Persona  personaEntity){
		Persona persona = new Persona();
		persona.setIdPersona(personaEntity.getIdPersona());
		persona.setNombre(personaEntity.getNombre());
		persona.setApellidos(personaEntity.getApellidos());
		persona.setEdad(personaEntity.getEdad());
		return persona;
	}
}
