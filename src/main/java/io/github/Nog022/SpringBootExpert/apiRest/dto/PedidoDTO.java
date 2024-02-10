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
	@NotNull(message = "Informe o código do cliente")
	private Integer cliente;

	@NotNull(message = "Informe o Total do pedido")
	private BigDecimal total;

	private List<ItemPedidoDTO> itens;
}
