package io.github.Nog022.SpringBootExpert.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.Nog022.SpringBootExpert.domain.entity.Cliente;
import io.github.Nog022.SpringBootExpert.domain.entity.Pedido;

public interface Pedidos extends JpaRepository<Pedido, Integer>{
	
	List<Pedido> findByCliente(Cliente Cliente);
}
