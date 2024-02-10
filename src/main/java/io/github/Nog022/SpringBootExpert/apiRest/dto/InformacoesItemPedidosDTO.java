package io.github.Nog022.SpringBootExpert.apiRest.dto;

import lombok.*;

import java.math.BigDecimal;
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InformacoesItemPedidosDTO {

    private String descricao;
    private BigDecimal precoUnitatio;
    private Integer quantidade;
}
