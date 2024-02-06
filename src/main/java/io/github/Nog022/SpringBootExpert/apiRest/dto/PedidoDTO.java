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

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PedidoDTO {
	private Integer cliente;
	private BigDecimal total;
	private List<ItemPedidoDTO> itens;
}
