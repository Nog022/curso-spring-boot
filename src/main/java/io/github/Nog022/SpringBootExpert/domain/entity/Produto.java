package io.github.Nog022.SpringBootExpert.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "produto")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "DESCRICAO")
	@NotEmpty(message = "{campo.descricao.obrigatorio}")
	private String descricao;

	@Column(name = "PRECO_UNITARIO")
	@NotNull(message = "{campo.preco.obrigatorio}")
	private BigDecimal preco;

	@OneToMany(mappedBy = "produto")
	private Set<ItemPedido> produtoId;

}
