package io.github.Nog022.SpringBootExpert.domain.repository;

import io.github.Nog022.SpringBootExpert.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Pedidos extends JpaRepository<Pedido, Integer>{
	
	//List<Pedido> findByCliente(Cliente Cliente);

//	@Query("SELECT p FROM Pedido p LEFT JOIN FETCH p.itens WHERE p.id = :id")
//	Optional<Pedido> findByIdFetchItens(Integer id);
}
