package com.company.ejemplorest.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.ejemplorest.mapper.PersonaMapper;
import com.company.ejemplorest.model.Persona;
import com.company.ejemplorest.repository.PersonaRepository;
import com.company.ejemplorest.service.PersonaService;

@Service("personaServiceImpl")
public class PersonaServiceImpl implements PersonaService {
	
	@Autowired
	private PersonaRepository personaRepository;
	
	@Autowired
	private PersonaMapper personaMapper;

	@Override
	public List<Persona> getPersonas() {
		List<com.company.ejemplorest.entity.Persona> personas = personaRepository.findAll();
		List<Persona> personasModel = new ArrayList<>();
		personas.stream().forEach(t -> personasModel.add(personaMapper.fromEntity2Model(t)));
		return personasModel;
	}

	@Override
	public Persona buscarPersona(Integer idPersona) {
		Optional<com.company.ejemplorest.entity.Persona> persona = personaRepository.findById(idPersona);
		return persona.isPresent() ? personaMapper.fromEntity2Model(persona.get()) : null;
	}

	@Override
	public Persona guardarPersona(Persona persona) {
		com.company.ejemplorest.entity.Persona personaEntity = (com.company.ejemplorest.entity.Persona) personaRepository.save(personaMapper.fromModel2Entity(persona));
		return personaMapper.fromEntity2Model(personaEntity);
	}

	@Override
	public Persona actualizarPersona(Persona persona) {
		com.company.ejemplorest.entity.Persona personaEntity = (com.company.ejemplorest.entity.Persona) personaRepository.save(personaMapper.fromModel2Entity(persona));
		return personaMapper.fromEntity2Model(personaEntity);
	}

	@Override
	public void eliminarPersona(Integer idPersona) {
		Optional<com.company.ejemplorest.entity.Persona> persona =  personaRepository.findById(idPersona);
		if(persona.isPresent()){
			personaRepository.delete(persona.get());
		}
	}

	@Override
	public boolean isPersonaExiste(int idPersona) {
		return personaRepository.existsById(idPersona);
	}

}
