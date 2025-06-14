package com.anthonyponte.participantes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anthonyponte.participantes.entity.Participante;
import com.anthonyponte.participantes.feign.EventosFeignClient;
import com.anthonyponte.participantes.service.ParticipanteService;

@RestController
@RequestMapping("/api/v1/participantes")
public class ParticipanteController {
	@Autowired
	private ParticipanteService service;

	@Autowired
	private EventosFeignClient client;

	@GetMapping("/{id}")
	public ResponseEntity<List<Participante>> listarParticipantesPorId(@PathVariable Long id) {
		return ResponseEntity.ok(service.listarParticipantesPorId(id));
	}

	@PostMapping
	public ResponseEntity<?> guardarParticipante(@RequestBody Participante participante) {
		Long idEvento = participante.getIdEvento();
		ResponseEntity<?> response = client.existeEventoPorId(idEvento);
		if (response.getStatusCode().is2xxSuccessful()) {
			response = client.disminuirCapacidadMax(idEvento);
			if (response.getStatusCode().is2xxSuccessful()) {
				return ResponseEntity.ok(service.guardarParticipante(participante));
			} else {
				return response;
			}
		} else {
			return response;
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarParticipante(@PathVariable Long id) {
		Optional<Participante> participante = service.obtenerParticipantePorId(id);
		if (participante.isPresent()) {
			Long idEvento = participante.get().getIdEvento();
			ResponseEntity<?> response = client.aumentarCapacidadMax(idEvento);
			if (response.getStatusCode().is2xxSuccessful()) {
				service.eliminarParticipante(id);
				return ResponseEntity.ok().build();
			} else {
				return response;
			}
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
