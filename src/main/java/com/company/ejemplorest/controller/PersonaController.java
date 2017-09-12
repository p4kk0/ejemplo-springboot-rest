package com.company.ejemplorest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import com.company.ejemplorest.service.PersonaService;
import com.company.ejemplorest.util.MensajeError;

@RestController
public class PersonaController {
	
	public static final Logger logger = LoggerFactory.getLogger(PersonaController.class);

	@Autowired
	@Qualifier("personaServiceImpl")
	private PersonaService personaService;

	@GetMapping("/personas")
	public ResponseEntity<List<Persona>> getPersonas() {
		logger.info("Consulta personas");
		List<Persona> personas = personaService.getPersonas();
		if (personas.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Persona>>(personas, HttpStatus.OK);
	}
	

	@GetMapping("/personas/{id}")
	public ResponseEntity<?> getPersona(@PathVariable("id") int id) {
		logger.info("Consulta persona con id: {} ", id);
		Persona persona = personaService.buscarPersona(id);
		if (persona == null) {
			return new ResponseEntity<MensajeError>(new MensajeError("La persona con id " + id + " no existe."),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Persona>(persona, HttpStatus.OK);
	}
	

	@PostMapping("/personas")
	public ResponseEntity<String> guardarPersona(@RequestBody Persona persona) {
		logger.info("Guarda persona {} ", persona.toString());
		personaService.guardarPersona(persona);
		return new ResponseEntity<String>("Registro correcto", HttpStatus.CREATED);
	}

	
	@PutMapping("/personas/{id}")
	public ResponseEntity<?> actualizarPersona(@PathVariable("id") int id, @RequestBody Persona persona) {
		logger.info("Actualiza persona con id: {} ", id);
		Persona personaActual = personaService.buscarPersona(id);

		if (personaActual == null) {
			return new ResponseEntity<MensajeError>(new MensajeError("La persona con id " + id + " no existe."),
					HttpStatus.NOT_FOUND);
		}

		logger.info("Datos persona anteriores: {} ", personaActual.toString());
		personaActual.setNombre(persona.getNombre());
		personaActual.setApellidos(persona.getApellidos());
		personaActual.setEdad(persona.getEdad());
		personaActual.setGay(persona.isGay());
		logger.info("Datos persona actual: {} ", personaActual.toString());

		personaService.actualizarPersona(personaActual);
		return new ResponseEntity<Persona>(personaActual, HttpStatus.OK);
	}

	
	@DeleteMapping("/personas/{id}")
	public ResponseEntity<?> eliminarPersona(@PathVariable("id") int id) {
		logger.info("Elimina persona con id: {} ", id);
		if (!personaService.isPersonaExiste(id)) {
			return new ResponseEntity<MensajeError>(new MensajeError("La persona con id " + id + " no existe."),
					HttpStatus.NOT_FOUND);
		}
		personaService.eliminarPersona(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
