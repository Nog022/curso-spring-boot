package io.github.Nog022.SpringBootExpert.domain.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.github.Nog022.SpringBootExpert.domain.entity.Cliente;


public interface Clientes extends JpaRepository<Cliente, Integer>{

	//select c from Cliente c where c.nome like :nome
	List<Cliente> findByNomeLike(String nome);
	

	boolean existsByNome(String nome);
	
	@Query("delete from Cliente c where c.nome =:nome")
	void deleteByNome(String nome);
	
	@Query("select c from Cliente c left join fetch c.pedidos p where c.id =:id")
	Cliente findClienteFetchPedidos(@Param("id") Integer id);
}
