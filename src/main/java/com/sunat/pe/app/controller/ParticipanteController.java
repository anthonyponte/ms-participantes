package com.sunat.pe.app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunat.pe.app.entities.Participante;
import com.sunat.pe.app.service.IParticipanteService;

@RestController
@RequestMapping("/participante")
public class ParticipanteController {

	private final IParticipanteService participanteService;

	public ParticipanteController(IParticipanteService participanteService) {
		super();
		this.participanteService = participanteService;
	}
	
	@GetMapping
	public ResponseEntity<List<Participante>> listarParticipantes() {
		return ResponseEntity.ok(participanteService.listarParticipantes());
	}
	
	@PostMapping("/{idEvento}/{dni}/{nombresyApellidos}")
	public ResponseEntity<Participante> agregarParticipante(
	        @PathVariable Long idEvento, 
	        @PathVariable String dni, 
	        @PathVariable String nombresyApellidos) {
	    
	    return ResponseEntity.ok(participanteService.agregarParticipante(idEvento, dni, nombresyApellidos));
	}
	
	@PostMapping
	public ResponseEntity<Participante> agregarParticipante(@RequestBody Participante participante) {
		 return ResponseEntity.ok(
				 participanteService
				 .agregarParticipante(participante.getIdEvento(), 
						 participante.getDni(), 
						 participante.getNombresApellidos()));
	}
	
	@DeleteMapping("/{idParticipante}")
	public ResponseEntity<Void> eliminarParticipante(@PathVariable Long idParticipante) {
		participanteService.eliminarParticipante(idParticipante);
		return ResponseEntity.noContent().build();
	}
	
}
