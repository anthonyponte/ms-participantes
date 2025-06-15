package com.anthonyponte.participantes.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.anthonyponte.participantes.dto.Evento;

@FeignClient(name = "ms-eventos")
public interface EventosFeignClient {
	@GetMapping("/api/v1/eventos/{id}")
	ResponseEntity<Evento> obtenerEventoPorId(@PathVariable Long id);

	@PutMapping("/api/v1/eventos/{id}")
	ResponseEntity<Evento> actualizarEvento(@PathVariable Long id, @RequestBody Evento evento);
}
