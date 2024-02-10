package io.github.Nog022.SpringBootExpert.service;

import io.github.Nog022.SpringBootExpert.apiRest.dto.PedidoDTO;
import io.github.Nog022.SpringBootExpert.domain.entity.Pedido;
import io.github.Nog022.SpringBootExpert.domain.enums.StatusPedido;
import org.springframework.stereotype.Component;

@Component
public interface PedidoService {
	Pedido salvar(PedidoDTO dto);

//	Optional<Pedido> obterPedidoCompleto(Integer id);

	void atualizaStatus(Integer id, StatusPedido statusPedido);
}
