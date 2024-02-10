package io.github.Nog022.SpringBootExpert.apiRest.controller;

import io.github.Nog022.SpringBootExpert.apiRest.dto.AtualizacaoStatusPedidoDTO;
import io.github.Nog022.SpringBootExpert.apiRest.dto.PedidoDTO;
import io.github.Nog022.SpringBootExpert.domain.entity.Pedido;
import io.github.Nog022.SpringBootExpert.domain.enums.StatusPedido;
import io.github.Nog022.SpringBootExpert.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RequestMapping(value = "/api/pedidos", consumes = "application/json" )
@RestController
public class PedidoController {

	private final PedidoService service;

	public PedidoController(PedidoService service) {

		this.service = service;

	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Integer save(@RequestBody @Valid PedidoDTO dto) {

		Pedido pedido = service.salvar(dto);
		return pedido.getId();

	}

	@PatchMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateStatusPedido(@PathVariable Integer id,
			@RequestBody AtualizacaoStatusPedidoDTO dto){
		String status = dto.getNovoStatus();
		service.atualizaStatus(id, StatusPedido.valueOf(status));

	}

//	@GetMapping("{id}")
//	public InformacoesPedidosDTO getPedidoById(@PathVariable Integer id) {
//		Pedido pedido = service.obterPedidoCompleto(id)
//				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não foi encontrado"));
//
//		return InformacoesPedidosDTO.builder()
//				.codigo(pedido.getId())
//				.cpf(pedido.getCliente().getCpf())
//				.nomeCliente(pedido.getCliente().getNome())
//				.dataPedido(pedido.getDataPedido().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
//				.total(pedido.getTotal())
	//TODO COLOCAR O ATRIBUTO STATUS NESSA LINHA

//				.itens(convertendo(pedido.getItensPedidos()))
//				.build();
//	}
//
//	private List<InformacoesItemPedidosDTO> convertendo(List<ItemPedido> itensPedidos){
//		if(CollectionUtils.isEmpty(itensPedidos)){
//			return Collections.emptyList();
//		}
//
//		return itensPedidos.stream().map(item -> InformacoesItemPedidosDTO.builder()
//				.descricao(item.getProduto().getDescricao())
//				.precoUnitatio(item.getProduto().getPreco())
//				.quantidade(item.getQuantidade())
//				.build()).collect(Collectors.toList());
//	}


}

