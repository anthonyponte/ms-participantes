package com.anthonyponte.participantes.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.anthonyponte.participantes.dto.ParticipanteDTO;
import com.anthonyponte.participantes.entity.Participante;

public class ParticipanteMapper {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public static ParticipanteDTO toDTO(Participante participante) {
        ParticipanteDTO dto = new ParticipanteDTO();
        dto.setId(participante.getId());
        dto.setDni(participante.getDni());
        dto.setNombresApellidos(participante.getNombresApellidos());
        dto.setFechaRegistro(participante.getFechaRegistro().format(formatter));
        dto.setIdEvento(participante.getIdEvento());

        return dto;
    }

    public static Participante toEntity(ParticipanteDTO dto) {
        Participante participante = new Participante();
        participante.setId(dto.getId());
        participante.setDni(dto.getDni());
        participante.setNombresApellidos(dto.getNombresApellidos());
        participante.setFechaRegistro(LocalDateTime.now());
        participante.setIdEvento(dto.getIdEvento());

        return participante;
    }
}
