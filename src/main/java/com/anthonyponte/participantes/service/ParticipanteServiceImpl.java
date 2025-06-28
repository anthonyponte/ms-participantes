package com.anthonyponte.participantes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.anthonyponte.participantes.dto.EventoDTO;
import com.anthonyponte.participantes.entity.Participante;
import com.anthonyponte.participantes.feign.EventosFeignClient;
import com.anthonyponte.participantes.repository.ParticipanteRepository;

@Component
public class ParticipanteServiceImpl implements ParticipanteService {
	@Autowired
	private ParticipanteRepository repository;

	@Autowired
	private EventosFeignClient client;

	@Override
	public List<Participante> listarParticipantesPorDni(String dni) {
		return repository.findAllByDni(dni);
	}

	@Override
	public Participante guardarParticipante(Participante participante) {
		Participante p = null;
		Long idEvento = participante.getIdEvento();
		ResponseEntity<EventoDTO> response = client.obtenerEventoPorId(idEvento);
		if (response.getStatusCode().is2xxSuccessful()) {

			EventoDTO evento = response.getBody();
			if (evento.getCapacidadMax() == 0) {
				throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "No hay capacidad en el evento");
			}

			p = repository.save(participante);

			evento.setCapacidadMax(evento.getCapacidadMax() - 1);
			client.actualizarEvento(idEvento, evento);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Evento no encontrado");
		}

		return p;
	}

	@Override
	public void eliminarParticipantePorId(Long id) {
		Participante participante = repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Participante no encontrado"));

		Long idEvento = participante.getIdEvento();
		ResponseEntity<EventoDTO> response = client.obtenerEventoPorId(idEvento);
		EventoDTO evento = response.getBody();

		repository.deleteById(id);

		evento.setCapacidadMax(evento.getCapacidadMax() + 1);
		client.actualizarEvento(idEvento, evento);
	}
}
