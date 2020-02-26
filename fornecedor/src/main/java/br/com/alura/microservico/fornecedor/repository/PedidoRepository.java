package br.com.alura.microservico.fornecedor.repository;

import br.com.alura.microservico.fornecedor.model.Pedido;
import org.springframework.data.repository.CrudRepository;

public interface PedidoRepository extends CrudRepository<Pedido, Long> {

}
