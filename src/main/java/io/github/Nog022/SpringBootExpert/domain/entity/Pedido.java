package io.github.Nog022.SpringBootExpert.domain.entity;

import io.github.Nog022.SpringBootExpert.domain.enums.StatusPedido;
import io.github.Nog022.SpringBootExpert.validation.NotEmptyList;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PEDIDO")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "CLIENTE_ID")
	private Cliente cliente;

	@Column(name = "DATA_PEDIDO")
	private LocalDate dataPedido;

	@Column(name = "TOTAL", precision = 20, scale = 2)
	private BigDecimal total;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private StatusPedido status;

	@OneToMany(mappedBy = "pedido")
	@NotEmptyList(message = "Pedido não pode ser realizado sem itens")
	private List<ItemPedido> itensPedidos;

}
