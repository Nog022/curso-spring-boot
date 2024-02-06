package io.github.Nog022.SpringBootExpert.service;

import io.github.Nog022.SpringBootExpert.apiRest.dto.PedidoDTO;
import io.github.Nog022.SpringBootExpert.domain.entity.Pedido;

public interface PedidoService {
	Pedido salvar(PedidoDTO dto);
}
