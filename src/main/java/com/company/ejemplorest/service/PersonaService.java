package com.company.ejemplorest.service;

import java.util.List;

import com.company.ejemplorest.model.Persona;

public interface PersonaService {
	
	List<Persona> getPersonas();
	Persona buscarPersona(Integer id);
	Persona guardarPersona(Persona persona);
	Persona actualizarPersona(Persona persona);
	void eliminarPersona(Integer id);
	boolean isPersonaExiste(int id);
}
