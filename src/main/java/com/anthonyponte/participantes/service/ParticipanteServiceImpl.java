package com.anthonyponte.participantes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anthonyponte.participantes.entity.Participante;
import com.anthonyponte.participantes.repository.ParticipanteRepository;

@Component
public class ParticipanteServiceImpl implements ParticipanteService {
	@Autowired
	private ParticipanteRepository repository;

	@Override
	public List<Participante> listarParticipantesPorId(Long id) {
		return repository.findAllById(id);
	}

	@Override
	public Optional<Participante> obtenerParticipantePorId(Long id) {
		return repository.findById(id);
	}

	@Override
	public Participante obtenerParticipantePorDniYIdEvento(String dni, Long idEvento) {
		return repository.findByDniAndIdEvento(dni, idEvento);
	}

	@Override
	public Participante guardarParticipante(Participante participante) {
		return repository.save(participante);
	}

	@Override
	public void eliminarParticipante(Long id) {
		repository.deleteById(id);
	}
}
