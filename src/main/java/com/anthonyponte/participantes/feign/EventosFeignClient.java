package com.anthonyponte.participantes.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-eventos")
public interface EventosFeignClient {
	@GetMapping("/api/v1/eventos/{id}/existe")
	ResponseEntity<?> existeEventoPorId(@PathVariable Long id);

	@PatchMapping("/api/v1/eventos/{id}/disminuir-capacidad-max")
	ResponseEntity<?> disminuirCapacidadMax(@PathVariable Long id);

	@PatchMapping("/api/v1/eventos/{id}/aumentar-capacidad-max")
	ResponseEntity<?> aumentarCapacidadMax(@PathVariable Long id);
}
