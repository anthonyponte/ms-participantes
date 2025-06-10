package com.anthonyponte.participantes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anthonyponte.participantes.entity.Participante;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Long> {
	List<Participante> findAllById(Long id);

	Participante findByDniAndEventoId(String dni, Long eventoId);
}
