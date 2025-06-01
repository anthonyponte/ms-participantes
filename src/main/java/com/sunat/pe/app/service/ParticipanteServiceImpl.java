package com.sunat.pe.app.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.sunat.pe.app.entities.Participante;
import com.sunat.pe.app.repository.ParticipanteRepository;

@Service
public class ParticipanteServiceImpl implements IParticipanteService {

	private final ParticipanteRepository participanteRepository;
	
	public ParticipanteServiceImpl(ParticipanteRepository participanteRepository) {
		super();
		this.participanteRepository = participanteRepository;
	}

	@Override
	public List<Participante> listarParticipantes() {		
		return participanteRepository.findAll();
	}

	@Override
	public Participante agregarParticipante(Long idEvento, String dni, String nombresyApellidos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarParticipante(Long idParticipante) {
		participanteRepository.deleteById(idParticipante);
		
	}

	@Override
	public List<Participante> buscarParticipantes(Long idEvento, String dni) {
		// TODO Auto-generated method stub
		return participanteRepository.findByIdEventoAndDni(idEvento, dni);
	}

	@Override
	public List<Participante> buscarParticipantes(Long idEvento) {
		return participanteRepository.findByIdEvento(idEvento);
	}
}
