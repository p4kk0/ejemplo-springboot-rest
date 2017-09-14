package com.company.ejemplorest.service;

import java.util.List;

import com.company.ejemplorest.model.Empleo;
import com.company.ejemplorest.model.Persona;

public interface EmpleoService {
	List<Empleo> getEmpleos();
	Empleo buscarEmpleo(Integer idEmpleo);
	Empleo guardarEmpleo(Empleo empleo);
	Empleo actualizarEmpleo(Empleo empleo);
	void eliminarEmpleo(Integer idEmpleo);
	boolean isEmpleoExiste(int idEmpleo);
	
	List<Empleo> getEmpleosByIdPersona(Integer idPersona);
	Empleo getEmpleoByIdPersonaAndIdEmpleo(Integer idPersona, Integer idEmpleo);
	Empleo guardarEmpleoByPersona(Integer idPersona, Empleo empleo);
}
