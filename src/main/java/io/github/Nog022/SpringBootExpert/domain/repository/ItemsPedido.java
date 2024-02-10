package io.github.Nog022.SpringBootExpert.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.Nog022.SpringBootExpert.domain.entity.ItemPedido;
import org.springframework.stereotype.Component;

@Component
public interface ItemsPedido extends JpaRepository<ItemPedido, Integer>{

}
