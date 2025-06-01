package com.sunat.pe.app.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.sunat.pe.app.controller.dto.Evento;

//@FeignClient(name = "ms-eventos", url = "http://ms-eventos:9090")
@FeignClient(name = "ms-eventos")
public interface EventosFeignClient {

	@GetMapping("/eventos/{codigo}")
	Evento obtenerPorCodigo(@PathVariable String codigo);	

}
