package com.anthonyponte.participantes.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anthonyponte.participantes.entity.Participante;

@Service
public interface ParticipanteService {
	public List<Participante> listarParticipantesPorDni(String dni);

	public Participante guardarParticipante(Participante participante);

	public void eliminarParticipantePorId(Long id);
}
