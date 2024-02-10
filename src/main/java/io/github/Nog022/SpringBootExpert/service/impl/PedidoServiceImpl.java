package io.github.Nog022.SpringBootExpert.service.impl;

import io.github.Nog022.SpringBootExpert.apiRest.dto.ItemPedidoDTO;
import io.github.Nog022.SpringBootExpert.apiRest.dto.PedidoDTO;
import io.github.Nog022.SpringBootExpert.domain.entity.Cliente;
import io.github.Nog022.SpringBootExpert.domain.entity.ItemPedido;
import io.github.Nog022.SpringBootExpert.domain.entity.Pedido;
import io.github.Nog022.SpringBootExpert.domain.entity.Produto;
import io.github.Nog022.SpringBootExpert.domain.enums.StatusPedido;
import io.github.Nog022.SpringBootExpert.domain.repository.Clientes;
import io.github.Nog022.SpringBootExpert.domain.repository.ItemsPedido;
import io.github.Nog022.SpringBootExpert.domain.repository.Pedidos;
import io.github.Nog022.SpringBootExpert.domain.repository.Produtos;
import io.github.Nog022.SpringBootExpert.exception.PedidoNaoEncontradoException;
import io.github.Nog022.SpringBootExpert.exception.RegraNegocioException;
import io.github.Nog022.SpringBootExpert.service.PedidoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService{


	private final Pedidos repository;


	private final Clientes clientesRepository;


	private final Produtos produtosRepository;


	private final ItemsPedido itemsPedidoRepository;

//	public PedidoServiceImpl(Pedidos repository, Clientes clientesRepository, Produtos produtosRepository, ItemsPedido itemsPedidoRepository) {
//		this.repository = repository;
//		this.clientesRepository = clientesRepository;
//		this.produtosRepository = produtosRepository;
//		this.itemsPedidoRepository = itemsPedidoRepository;
//	}

	@Override
	@Transactional
	public Pedido salvar(PedidoDTO dto) {
		Integer idCliente = dto.getCliente();
		Cliente cliente =  clientesRepository.findById(idCliente)
						  .orElseThrow(() -> new RegraNegocioException("Codigo de cliente invalido"));

		Pedido pedido = new Pedido();
		pedido.setTotal(dto.getTotal());
		pedido.setDataPedido(LocalDate.now());
		pedido.setCliente(cliente);
		pedido.setStatus(StatusPedido.REALIZADO);

		List<ItemPedido> itemsPedido = converterItems(pedido, dto.getItens());
		repository.save(pedido);
		itemsPedidoRepository.saveAll(itemsPedido);
		pedido.setItensPedidos(itemsPedido);

		return pedido;
	}

	@Override
	@Transactional
	public void atualizaStatus(Integer id, StatusPedido statusPedido) {
		repository.findById(id).map(pedido -> {
			pedido.setStatus(statusPedido);
			return repository.save(pedido);
		}).orElseThrow(() -> new PedidoNaoEncontradoException());
	}

//	@Override
//	public Optional<Pedido> obterPedidoCompleto(Integer id) {
//		return repository.findByIdFetchItens(id);
//	}

	private List<ItemPedido> converterItems(Pedido pedido , List<ItemPedidoDTO> items) {
		if(items.isEmpty()) {
			throw new RegraNegocioException("Nao eh possivel realizar um pedido sem items.");
		}

		return items.stream().map(dto -> {
			Integer idProduto = dto.getProduto();
			Produto produto = produtosRepository
			.findById(idProduto)
			.orElseThrow(() -> new RegraNegocioException("Codigo do produito invalido:" + idProduto));


			ItemPedido itemPedido = new ItemPedido();
			itemPedido.setQuantidade(dto.getQuantidade());
			itemPedido.setPedido(pedido);
			itemPedido.setProduto(produto);

			return itemPedido;
		}).collect(Collectors.toList());
	}


}
