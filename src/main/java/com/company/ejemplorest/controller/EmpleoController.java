package com.company.ejemplorest.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.ejemplorest.model.Empleo;
import com.company.ejemplorest.service.EmpleoService;
import com.company.ejemplorest.service.PersonaService;
import com.company.ejemplorest.util.MensajeError;

@RestController
public class EmpleoController {
	
	@Autowired
	@Qualifier("empleoServiceImpl")
	private EmpleoService empleoService;
	
	@Autowired
	@Qualifier("personaServiceImpl")
	private PersonaService personaService;
	
	@GetMapping("/personas/{idPersona}/empleos")
	public ResponseEntity<List<Empleo>> getEmpleosByPersona(@PathVariable("idPersona") int idPersona) {
		List<Empleo> empleos = empleoService.getEmpleosByIdPersona(idPersona);
		if (empleos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		for(Empleo empleo: empleos){
			addEmpleoLinks(idPersona, empleo);
		}
		
		return new ResponseEntity<List<Empleo>>(empleos, HttpStatus.OK);
	}
	
	@GetMapping("/personas/{idPersona}/empleos/{idEmpleo}")
	public ResponseEntity<Empleo> getEmpleoByPersona(@PathVariable("idPersona") int idPersona, @PathVariable("idEmpleo") int idEmpleo) {
		Empleo empleo = empleoService.getEmpleoByIdPersonaAndIdEmpleo(idPersona, idEmpleo);
		if (empleo == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		addEmpleoLinks(idPersona, empleo);
		
		return new ResponseEntity<Empleo>(empleo, HttpStatus.OK);
	}
	
	

	@PostMapping("/personas/{idPersona}/empleos")
	public ResponseEntity<?> guardarEmpleoByPersona(@PathVariable("idPersona") int idPersona, @RequestBody Empleo empleo) {
		if(!personaService.isPersonaExiste(idPersona)){
			return new ResponseEntity<MensajeError>(new MensajeError("La persona con idPersona " + idPersona + " no existe."),
					HttpStatus.NOT_FOUND);
		}
		Empleo empleoRegistrado = empleoService.guardarEmpleoByPersona(idPersona, empleo);
		
		addEmpleoLinks(idPersona, empleoRegistrado);
		
		final HttpHeaders headers = getHeaderResourceLocation(idPersona, empleoRegistrado);
        
		return new ResponseEntity<Empleo>(empleoRegistrado, headers, HttpStatus.CREATED);
	}
	
	private void addEmpleoLinks(int idPersona, Empleo empleo){
		addSelfLink(idPersona, empleo);
		addPersonaLink(idPersona, empleo);
	}
	
	private void addSelfLink(int idPersona, Empleo empleo){
		empleo.add(linkTo(methodOn(EmpleoController.class).getEmpleoByPersona(idPersona, empleo.getIdEmpleo())).withSelfRel());
	}
	
	private void addPersonaLink(int idPersona, Empleo empleo){
		empleo.add(linkTo(methodOn(PersonaController.class).getPersona(idPersona)).withRel("persona"));
	}
	
	private HttpHeaders getHeaderResourceLocation(int idPersona, Empleo empleo){
		final HttpHeaders headers = new HttpHeaders();
        headers.setLocation(linkTo(methodOn(EmpleoController.class).getEmpleoByPersona(idPersona, empleo.getIdEmpleo())).toUri());
        return headers;
	}


}
