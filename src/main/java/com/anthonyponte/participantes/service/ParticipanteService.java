package com.anthonyponte.participantes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.anthonyponte.participantes.entity.Participante;

@Service
public interface ParticipanteService {
	public List<Participante> listarParticipantesPorId(Long id);

	public Optional<Participante> obtenerParticipantePorId(Long id);

	public Participante obtenerParticipantePorDniYIdEvento(String dni, Long idEvento);

	public Participante guardarParticipante(Participante participante);

	public void eliminarParticipante(Long id);
}
