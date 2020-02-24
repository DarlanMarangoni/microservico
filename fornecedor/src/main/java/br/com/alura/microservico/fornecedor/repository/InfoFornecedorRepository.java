package br.com.alura.microservico.fornecedor.repository;

import br.com.alura.microservico.fornecedor.model.InfoFornecedor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoFornecedorRepository extends CrudRepository<InfoFornecedor, Long> {

    public InfoFornecedor findByEstado(String estado);
}
