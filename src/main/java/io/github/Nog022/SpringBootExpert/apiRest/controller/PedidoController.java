package io.github.Nog022.SpringBootExpert.apiRest.controller;

import io.github.Nog022.SpringBootExpert.apiRest.dto.PedidoDTO;
import io.github.Nog022.SpringBootExpert.domain.entity.Pedido;
import io.github.Nog022.SpringBootExpert.service.PedidoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping(value = "/api/pedidos", consumes = "application/json" )
public class PedidoController {


	private PedidoService service;

	public PedidoController(PedidoService service) {
		this.service = service;
	}

	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Integer save(@RequestBody PedidoDTO dto) {
		try {
			Pedido pedido =  service.salvar(dto);
			return pedido.getId();
		}catch (Exception e){
			log.error("Pedidos Save " + e.getMessage());
		}
		return null;
	}
	
}
