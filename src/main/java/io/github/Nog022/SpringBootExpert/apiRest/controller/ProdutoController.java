package io.github.Nog022.SpringBootExpert.apiRest.controller;

import io.github.Nog022.SpringBootExpert.domain.entity.Cliente;
import io.github.Nog022.SpringBootExpert.domain.entity.Produto;
import io.github.Nog022.SpringBootExpert.domain.repository.Produtos;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/api/produtos" , consumes = "application/json")
public class ProdutoController {

	private Produtos produtos;

	public ProdutoController(Produtos produtos) {
		this.produtos = produtos;
	}

	@GetMapping("{id}")
	public Produto getProdutoById(@PathVariable Integer id) {
		
		return produtos.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto nao foi encontrado"));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto save(@RequestBody Produto produto) {
		return produtos.save(produto);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable Integer id ,@RequestBody Produto produto) {
		produtos.findById(id).map(produtoExistente -> { produto.setId(produtoExistente.getId());
		produtos.save(produtoExistente); 
		return produtoExistente;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto nao foi encontrado"));
	}
	
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id ) {
		produtos.findById(id).map(produto -> {
			produtos.delete(produto); 
			return produto;
			}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto nao foi encontrado"));
	}
	
	@GetMapping
	public List<Produto> find(Produto filtro) {
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
		
		Example example = Example.of(filtro, matcher);
		
		List<Cliente> lista = produtos.findAll(example);
		
		return produtos.findAll();
	}
	
	
	


	
}
