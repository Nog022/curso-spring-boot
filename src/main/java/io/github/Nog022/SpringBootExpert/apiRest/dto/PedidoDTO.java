package io.github.Nog022.SpringBootExpert.apiRest.dto;
/**
{
    "cliente" : 1,
    "total": 100,
    "itens" : [
        {
            "produto" 1,
            "quantidade" : 10
        }
    ]
}
*/

import io.github.Nog022.SpringBootExpert.validation.NotEmptyList;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PedidoDTO {
	@NotNull(message = "{campo.codigo-cliente.obrigatorio}")
	private Integer cliente;

	@NotNull(message = "{campo.total-pedido.obrigatorio}")
	private BigDecimal total;

	@NotEmptyList(message = "{campo.items-pedido.obrigatorio}")
	private List<ItemPedidoDTO> itens;
}
