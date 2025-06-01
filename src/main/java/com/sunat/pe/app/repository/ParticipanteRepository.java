package com.sunat.pe.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunat.pe.app.entities.Participante;

public interface ParticipanteRepository extends JpaRepository<Participante, Long> {
    	
	List<Participante> findByDni(String dni);
	
	List<Participante> findByIdEvento(Long idEvento);
	
	List<Participante> findByIdEventoAndDni(Long idEvento, String dni);

}