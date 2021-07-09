package br.com.microservices.fornecedor.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.microservices.fornecedor.model.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Long> {

}
