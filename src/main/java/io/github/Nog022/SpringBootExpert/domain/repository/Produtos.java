package io.github.Nog022.SpringBootExpert.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.Nog022.SpringBootExpert.domain.entity.Produto;

public interface Produtos extends JpaRepository<Produto, Integer>{

}
