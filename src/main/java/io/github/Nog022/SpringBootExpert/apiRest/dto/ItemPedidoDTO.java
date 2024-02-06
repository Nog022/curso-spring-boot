package io.github.Nog022.SpringBootExpert.apiRest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemPedidoDTO {
	private Integer produto;
	private Integer quantidade;
	
}
