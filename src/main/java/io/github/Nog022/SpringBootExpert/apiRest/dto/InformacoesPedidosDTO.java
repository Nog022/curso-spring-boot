package io.github.Nog022.SpringBootExpert.apiRest.dto;

import lombok.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InformacoesPedidosDTO {

    private Integer codigo;
    private String cpf;
    private String nomeCliente;
    private BigDecimal total;
    private String dataPedido;
    private String status;
    List<InformacoesItemPedidosDTO>  itens;
}
