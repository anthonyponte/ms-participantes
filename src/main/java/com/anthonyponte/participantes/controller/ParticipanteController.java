package com.anthonyponte.participantes.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.anthonyponte.participantes.dto.ParticipanteDTO;
import com.anthonyponte.participantes.entity.Participante;
import com.anthonyponte.participantes.mapper.ParticipanteMapper;
import com.anthonyponte.participantes.service.ParticipanteService;

@RestController
@RequestMapping("/api/v1/participantes")
public class ParticipanteController {
	@Autowired
	private ParticipanteService service;

	@GetMapping
	public List<ParticipanteDTO> listarParticipantesPorDni(@RequestParam String dni) {
		return service.listarParticipantesPorDni(dni)
				.stream()
				.map(ParticipanteMapper::toDTO)
				.toList();
	}

	@PostMapping
	public ResponseEntity<?> guardarParticipante(@RequestBody ParticipanteDTO participanteDTO) {
		Participante participante = ParticipanteMapper.toEntity(participanteDTO);
		Participante p = service.guardarParticipante(participante);
		ParticipanteDTO dto = ParticipanteMapper.toDTO(p);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.build(p.getId());

		return ResponseEntity.created(uri).body(dto);
	}

	@DeleteMapping("/{id}")
	public void eliminarParticipantePorId(@PathVariable Long id) {
		service.eliminarParticipantePorId(id);
	}
}
