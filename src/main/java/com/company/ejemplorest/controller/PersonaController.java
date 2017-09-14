package com.company.ejemplorest.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.ejemplorest.model.Persona;
import com.company.ejemplorest.service.EmpleoService;
import com.company.ejemplorest.service.PersonaService;
import com.company.ejemplorest.util.MensajeError;

@RestController
public class PersonaController {
	
	public static final Logger logger = LoggerFactory.getLogger(PersonaController.class);

	@Autowired
	@Qualifier("personaServiceImpl")
	private PersonaService personaService;
	
	@Autowired
	@Qualifier("empleoServiceImpl")
	private EmpleoService empleoService;

	@GetMapping("/personas")
	public ResponseEntity<List<Persona>> getPersonas() {
		logger.info("Consulta personas");
		List<Persona> personas = personaService.getPersonas();
		if (personas.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		for(Persona persona: personas){
			addSelfLink(persona);
			if (empleoService.getEmpleosByIdPersona(persona.getIdPersona()).size() > 0) {
				addEmpleosLink(persona);
            }
		}
		
		return new ResponseEntity<List<Persona>>(personas, HttpStatus.OK);
	}
	

	@GetMapping("/personas/{idPersona}")
	public ResponseEntity<?> getPersona(@PathVariable("idPersona") int idPersona) {
		logger.info("Consulta persona con idPersona: {} ", idPersona);
		if (!personaService.isPersonaExiste(idPersona)) {
			return new ResponseEntity<MensajeError>(new MensajeError("La persona con idPersona " + idPersona + " no existe."),
					HttpStatus.NOT_FOUND);
		}
		
		Persona persona = personaService.buscarPersona(idPersona);
		
		addSelfLink(persona);
		if (empleoService.getEmpleosByIdPersona(persona.getIdPersona()).size() > 0) {
			addEmpleosLink(persona);
        }
		
		return new ResponseEntity<Persona>(persona, HttpStatus.OK);
	}
	

	@PostMapping("/personas")
	public ResponseEntity<?> guardarPersona(@RequestBody Persona persona) {
		logger.info("Guarda persona {} ", persona.toString());
		Persona personaRegistrada = personaService.guardarPersona(persona);
		
		addSelfLink(personaRegistrada);
		final HttpHeaders headers = getHeaderResourceLocation(personaRegistrada);
		
		return new ResponseEntity<Persona>(personaRegistrada, headers, HttpStatus.CREATED);
	}

	
	@PutMapping("/personas/{id}")
	public ResponseEntity<?> actualizarPersona(@PathVariable("idPersona") int idPersona, @RequestBody Persona persona) {
		logger.info("Actualiza persona con idPersona: {} ", idPersona);

		if (!personaService.isPersonaExiste(idPersona)) {
			return new ResponseEntity<MensajeError>(new MensajeError("La persona con idPersona " + idPersona + " no existe."),
					HttpStatus.NOT_FOUND);
		}

		Persona personaActual = personaService.buscarPersona(idPersona);
		logger.info("Datos persona anteriores: {} ", personaActual.toString());
		personaActual.setNombre(persona.getNombre());
		personaActual.setApellidos(persona.getApellidos());
		personaActual.setEdad(persona.getEdad());
		personaActual.setGay(persona.isGay());
		logger.info("Datos persona actual: {} ", personaActual.toString());

		personaService.actualizarPersona(personaActual);
		
		addSelfLink(personaActual);
		final HttpHeaders headers = getHeaderResourceLocation(personaActual);
        
		return new ResponseEntity<Persona>(personaActual, headers, HttpStatus.OK);
	}

	
	@DeleteMapping("/personas/{id}")
	public ResponseEntity<?> eliminarPersona(@PathVariable("idPersona") int idPersona) {
		logger.info("Elimina persona con id: {} ", idPersona);
		if (!personaService.isPersonaExiste(idPersona)) {
			return new ResponseEntity<MensajeError>(new MensajeError("La persona con idPersona " + idPersona + " no existe."),
					HttpStatus.NOT_FOUND);
		}
		personaService.eliminarPersona(idPersona);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	private void addSelfLink(Persona persona){
		persona.add(linkTo(methodOn(PersonaController.class).getPersona(persona.getIdPersona())).withSelfRel());
	}
	
	private void addEmpleosLink(Persona persona){
		persona.add(linkTo(methodOn(EmpleoController.class).getEmpleosByPersona(persona.getIdPersona())).withRel("empleos"));
	}
	
	private HttpHeaders getHeaderResourceLocation(Persona persona){
		final HttpHeaders headers = new HttpHeaders();
        headers.setLocation(linkTo(methodOn(PersonaController.class).getPersona(persona.getIdPersona())).toUri());
        return headers;
	}
}
