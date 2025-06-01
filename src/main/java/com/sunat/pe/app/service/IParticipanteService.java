package com.sunat.pe.app.service;

import java.util.List;
import com.sunat.pe.app.entities.Participante;

public interface IParticipanteService {
	
	public List<Participante> listarParticipantes();

	public Participante agregarParticipante(Long idEvento, String dni, String nombresyApellidos);

	public void eliminarParticipante(Long idParticipante);
	
	public List<Participante> buscarParticipantes(Long idEvento, String dni);
	
	public List<Participante> buscarParticipantes(Long idEvento);
}
