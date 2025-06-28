package com.anthonyponte.participantes.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.anthonyponte.participantes.dto.EventoDTO;

@FeignClient(name = "ms-eventos")
public interface EventosFeignClient {
	@GetMapping("/api/v1/eventos/{id}")
	ResponseEntity<EventoDTO> obtenerEventoPorId(@PathVariable Long id);

	@PutMapping("/api/v1/eventos/{id}")
	ResponseEntity<EventoDTO> actualizarEvento(@PathVariable Long id, @RequestBody EventoDTO eventoDTO);
}
